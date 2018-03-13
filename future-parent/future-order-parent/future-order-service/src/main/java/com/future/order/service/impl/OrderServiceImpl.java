package com.future.order.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.common.exception.CommonFutureException;
import com.future.instrument.api.service.CommissionService;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.service.MarginService;
import com.future.instrument.api.vo.InvestorTradeParamVO;
import com.future.order.api.service.OrderService;
import com.future.trade.api.vo.ReqOrderInsertVO;

/**
 * 报单接口实现类
 * @author caojia
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    
    static Logger logger = Logger.getLogger(OrderServiceImpl.class);
    
    @Autowired
    private InstrumentService instrumentService;
    
    @Autowired
    private CommissionService commissionService;
    
    @Autowired
    private MarginService marginService;

    @Override
    public void openOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void cancelOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeToday() {
        // TODO Auto-generated method stub

    }

    @Override
    public void queryOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) throws CommonFutureException{

        
        //调用合约中心查询应冻结手续费
        InvestorTradeParamVO paramVO = new InvestorTradeParamVO();
        paramVO.setDirection(String.valueOf(reqOrderInsertVO.getDirection().getCode()));
        paramVO.setInstrumentID(reqOrderInsertVO.getInstrumentID());
        paramVO.setInvestorNo(reqOrderInsertVO.getInvestorID());
        paramVO.setLimitPrice(new BigDecimal(reqOrderInsertVO.getLimitPrice()));
        paramVO.setOffset(reqOrderInsertVO.getCombOffsetFlag().getText());
        paramVO.setPriceType(String.valueOf(reqOrderInsertVO.getOrderPriceType()));
        paramVO.setVolume(reqOrderInsertVO.getVolumeTotalOriginal());
        BigDecimal commission = this.commissionService.calculateCommission(paramVO);
        
        //调用合约中心计算应冻结保证金
        BigDecimal margin = this.marginService.calculateMargin(paramVO);
        
        //调用账户中心冻结资金
        //TODO
        
        //生成委托编号
        
        
        //调用交易中心下单
        
        
    }

}
