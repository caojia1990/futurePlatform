package com.future.order.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.common.exception.CommonError;
import com.future.common.exception.CommonFutureException;
import com.future.order.api.exception.OrderException;
import com.future.order.api.service.PositionService;
import com.future.order.api.vo.InvestorPositionDetailVO;
import com.future.order.api.vo.InvestorPositionVO;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.service.dao.InvestorPositionDao;
import com.future.order.service.dao.InvestorPositionDetailDao;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
    
    static Logger logger = Logger.getLogger(PositionServiceImpl.class);
    
    @Autowired
    private InvestorPositionDetailDao investorPositionDetailDao;
    
    @Autowired
    private InvestorPositionDao investorPositionDao;
    
    /*@Autowired
    private InstrumentService instrumentService;*/

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void increasePosition(OnRtnTradeVO onRtnTradeVO) throws CommonFutureException {
        
        //InstrumentVO instrumentVO = this.instrumentService.queryInstrument(onRtnTradeVO.getInstrumentId());
        
        //保存持仓明细
        InvestorPositionDetailVO detailVO = new InvestorPositionDetailVO();
        detailVO.setInvestorID(onRtnTradeVO.getInvestorId());
        detailVO.setAccountNo(onRtnTradeVO.getAccountNo());
        detailVO.setInstrumentID(onRtnTradeVO.getInstrumentId());
        detailVO.setCombInstrumentID(onRtnTradeVO.getInstrumentId());
        detailVO.setOpenPrice(new BigDecimal(onRtnTradeVO.getPrice()));
        detailVO.setVolume(onRtnTradeVO.getVolume());
        detailVO.setDirection(onRtnTradeVO.getDirection());
        detailVO.setHedgeFlag(onRtnTradeVO.getHedgeFlag());
        detailVO.setOpenDate(onRtnTradeVO.getTradeDate());
        detailVO.setTradeID(onRtnTradeVO.getTradeId());
        detailVO.setTradeType(onRtnTradeVO.getTradeType());
        detailVO.setTradingDay(onRtnTradeVO.getTradingDay());
        try {
            investorPositionDetailDao.insert(detailVO);
        } catch (Exception e) {
            logger.error("保存持仓明细失败",e);
            throw new OrderException(CommonError.EXEC_SQL_ERROR);
        }
        // 更新持仓信息
        InvestorPositionVO investorPositionVO = null;
        try {
            investorPositionVO = this.investorPositionDao.selectByCondition(onRtnTradeVO.getAccountNo(), 
                    onRtnTradeVO.getInstrumentId(), onRtnTradeVO.getDirection());
            
            //开仓金额
            /*investorPositionVO.setOpenAmount(investorPositionVO.getOpenAmount()
                    .add(new BigDecimal(onRtnTradeVO.getPrice())
                            .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                            .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                            )
                    );*/
            //TODO 持仓成本 = （（原持仓成本*原持仓手数）+本次成交价格*成交手数）/原持仓手数+成交手数
            /*investorPositionVO.setPositionCost(investorPositionVO.getPositionCost()
                    .add(new BigDecimal(onRtnTradeVO.getPrice())
                            .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                            .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                            )
                    );*/
            
            //累计今日持仓
            investorPositionVO.setPosition(investorPositionVO.getPosition()+onRtnTradeVO.getVolume());
            try {
                this.investorPositionDao.update(investorPositionVO);
            } catch (Exception e) {
                logger.error("更新持仓汇总失败",e);
                throw new OrderException(CommonError.EXEC_SQL_ERROR);
            }
        } catch (EmptyResultDataAccessException e) {
            investorPositionVO = new InvestorPositionVO();
            investorPositionVO.setInvestorID(onRtnTradeVO.getInvestorId());
            investorPositionVO.setAccountNo(onRtnTradeVO.getAccountNo());
            investorPositionVO.setInstrumentID(onRtnTradeVO.getInstrumentId());
            investorPositionVO.setOpenVolume(onRtnTradeVO.getVolume());
            investorPositionVO.setPosition(onRtnTradeVO.getVolume());
            investorPositionVO.setPosiDirection(onRtnTradeVO.getDirection());
            investorPositionVO.setHedgeFlag(onRtnTradeVO.getHedgeFlag());
            investorPositionVO.setTradingDay(onRtnTradeVO.getTradeDate());
            /*investorPositionVO.setOpenAmount(new BigDecimal(onRtnTradeVO.getPrice())
                    .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                    .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                    );*///开仓金额
            /*investorPositionVO.setPositionCost(new BigDecimal(onRtnTradeVO.getPrice())
                    .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                    .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                    );*///TODO 持仓成本 = （（原持仓成本*原持仓手数）+本次成交价格*成交手数）/原持仓手数+成交手数
            try {
                this.investorPositionDao.insert(investorPositionVO);
            } catch (Exception e1) {
                logger.error("保存持仓汇总信息失败",e1);
                throw new OrderException(CommonError.EXEC_SQL_ERROR);
            }
        }
        
    }

    @Override
    @Transactional
    public void reducePosition(OnRtnTradeVO onRtnTradeVO) {
        
        //解冻并减少持仓
        
        switch (onRtnTradeVO.getOffsetFlag()) {
        case CLOSE:
            
            break;
        case CloseToday:
            //查询持仓明细
            List<InvestorPositionDetailVO> list = this.investorPositionDetailDao.selectByCondition(onRtnTradeVO.getAccountNo(), 
                    onRtnTradeVO.getInstrumentId(), onRtnTradeVO.getDirection(), onRtnTradeVO.getTradeDate());
            //平仓手数
            int closeVolume = onRtnTradeVO.getVolume();
            for (InvestorPositionDetailVO detail : list) {
                
                if(closeVolume > detail.getVolume()){
                    closeVolume -= detail.getVolume();
                    //TODO 平仓明细 单笔明细全平 删除持仓明细
                    
                }else{
                    if(closeVolume == detail.getVolume()){
                      //TODO 平仓明细 单笔明细全平 删除持仓明细
                    }else {
                      //TODO 单笔明细分笔平 减少持仓明细持仓手数
                    }
                    
                    break;
                }
                
            }
            break;
        case CloseYesterday:
            break;
        default:
            break;
        }

    }

    @Override
    public void frozenPosition() {
        // TODO Auto-generated method stub

    }

    @Override
    public void releasePosition() {
        // TODO Auto-generated method stub

    }

}
