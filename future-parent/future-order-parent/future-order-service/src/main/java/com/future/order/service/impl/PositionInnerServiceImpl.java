package com.future.order.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.future.common.exception.CommonFutureException;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.order.api.vo.InvestorPositionDetailVO;
import com.future.order.api.vo.InvestorPositionVO;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.service.dao.InvestorPositionDao;
import com.future.order.service.dao.InvestorPositionDetailDao;
import com.future.order.service.inner.PositionInnerService;

@Service("positionInnerService")
public class PositionInnerServiceImpl implements PositionInnerService {
	
	@Autowired
	private InvestorPositionDetailDao investorPositionDetailDao;
	
	@Autowired
	private InvestorPositionDao investorPositionDao;
	
	@Autowired
	private InstrumentService instrumentService;

	@Override
	public void increasePosition(OnRtnTradeVO onRtnTradeVO) throws CommonFutureException {
		
	    InstrumentVO instrumentVO = this.instrumentService.queryInstrument(onRtnTradeVO.getInstrumentId());
	    
		//保存持仓明细
		InvestorPositionDetailVO detailVO = new InvestorPositionDetailVO();
        detailVO.setAccountNo(onRtnTradeVO.getAccountNo());
        detailVO.setCombInstrumentID(onRtnTradeVO.getInstrumentId());
        detailVO.setDirection(onRtnTradeVO.getDirection());
        detailVO.setHedgeFlag(onRtnTradeVO.getHedgeFlag());
        detailVO.setInstrumentID(onRtnTradeVO.getInstrumentId());
        detailVO.setInvestorID(onRtnTradeVO.getInvestorId());
        detailVO.setOpenDate(onRtnTradeVO.getTradeDate());
        detailVO.setOpenPrice(new BigDecimal(onRtnTradeVO.getPrice()));
        detailVO.setTradeID(onRtnTradeVO.getTradeId());
        detailVO.setTradeType(onRtnTradeVO.getTradeType());
        detailVO.setTradingDay(onRtnTradeVO.getTradingDay());
        detailVO.setVolume(onRtnTradeVO.getVolume());
        investorPositionDetailDao.insert(detailVO);
        // 更新持仓信息
        InvestorPositionVO investorPositionVO = null;
        try {
            investorPositionVO = this.investorPositionDao.selectByCondition(onRtnTradeVO.getAccountNo(), 
                    onRtnTradeVO.getInstrumentId(), onRtnTradeVO.getDirection());
            //累计今日持仓
            investorPositionVO.setPosition(investorPositionVO.getPosition()+onRtnTradeVO.getVolume());
            //开仓金额
            investorPositionVO.setOpenAmount(investorPositionVO.getOpenAmount()
                    .add(new BigDecimal(onRtnTradeVO.getPrice())
                            .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                            .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                            )
                    );
            //持仓金额
            investorPositionVO.setPositionCost(investorPositionVO.getPositionCost()
                    .add(new BigDecimal(onRtnTradeVO.getPrice())
                            .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                            .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                            )
                    );
            
            
        } catch (EmptyResultDataAccessException e) {
            investorPositionVO = new InvestorPositionVO();
            investorPositionVO.setAccountNo(onRtnTradeVO.getAccountNo());
            investorPositionVO.setInstrumentID(onRtnTradeVO.getInstrumentId());
            investorPositionVO.setInvestorID(onRtnTradeVO.getInvestorId());
            investorPositionVO.setHedgeFlag(onRtnTradeVO.getHedgeFlag());
            investorPositionVO.setOpenAmount(new BigDecimal(onRtnTradeVO.getPrice())
                    .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                    .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                    );//开仓金额
            investorPositionVO.setOpenVolume(onRtnTradeVO.getVolume());
            investorPositionVO.setPosiDirection(onRtnTradeVO.getDirection());
            investorPositionVO.setPosition(onRtnTradeVO.getVolume());
            investorPositionVO.setPositionCost(new BigDecimal(onRtnTradeVO.getPrice())
                    .multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
                    .multiply(new BigDecimal(onRtnTradeVO.getVolume()))
                    );//持仓金额
            investorPositionVO.setTradingDay(onRtnTradeVO.getTradeDate());
            investorPositionVO.setPosition(onRtnTradeVO.getVolume());
            this.investorPositionDao.insert(investorPositionVO);
        }
        
	}

	@Override
	public void reducePosition(OnRtnTradeVO onRtnTradeVO) {
	    
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
                    //平仓盈亏 = （卖出价-买入价）*合约乘数*手数
                    
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
