package com.future.trade.service.impl;

import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderField;
import org.hraink.futures.jctp.trader.JCTPTraderApi;

import com.future.trade.api.service.TradeService;
import com.future.trade.api.vo.ReqOrderInsertVO;
import com.future.trade.service.Main;

/**
 * 交易接口实现
 * @author caojia
 *
 */
public class TradeServiceImpl implements TradeService{
    
    private JCTPTraderApi traderApi;

    @Override
    public int reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) {
        // TODO Auto-generated method stub
        
        CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
        pInputOrder.setBrokerID(Main.BROKER_ID);
        pInputOrder.setInvestorID(Main.USER_ID);
        pInputOrder.setBusinessUnit(reqOrderInsertVO.getBusinessUnit());
        pInputOrder.setCombHedgeFlag(reqOrderInsertVO.getCombHedgeFlag().getCode());
        pInputOrder.setCombOffsetFlag(reqOrderInsertVO.getCombOffsetFlag().getCode());
        pInputOrder.setContingentCondition(reqOrderInsertVO.getContingentCondition().getCode());
        pInputOrder.setDirection(reqOrderInsertVO.getDirection().getCode());
        pInputOrder.setForceCloseReason(reqOrderInsertVO.getForceCloseReason().getCode());
        pInputOrder.setGTDDate(reqOrderInsertVO.getgTDDate());
        pInputOrder.setInstrumentID(reqOrderInsertVO.getInstrumentID());
        pInputOrder.setIsAutoSuspend(reqOrderInsertVO.getIsAutoSuspend());
        pInputOrder.setLimitPrice(reqOrderInsertVO.getLimitPrice());
        pInputOrder.setMinVolume(reqOrderInsertVO.getMinVolume());
        pInputOrder.setOrderPriceType(reqOrderInsertVO.getOrderPriceType().getCode());
        pInputOrder.setOrderRef(reqOrderInsertVO.getOrderRef());
        pInputOrder.setRequestID(reqOrderInsertVO.getRequestID());
        pInputOrder.setStopPrice(reqOrderInsertVO.getStopPrice());
        pInputOrder.setTimeCondition(reqOrderInsertVO.getTimeCondition().getCode());
        pInputOrder.setUserID(Main.USER_ID);
        pInputOrder.setVolumeCondition(reqOrderInsertVO.getVolumeCondition().getCode());
        pInputOrder.setVolumeTotalOriginal(reqOrderInsertVO.getVolumeTotalOriginal());//手数
        
        return traderApi.reqOrderInsert(pInputOrder, reqOrderInsertVO.getRequestID());
    }

}
