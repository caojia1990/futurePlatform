package com.future.trade.service.impl;

import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderField;
import org.springframework.stereotype.Service;

import com.future.trade.api.exception.TradeError;
import com.future.trade.api.exception.TradeException;
import com.future.trade.api.service.TradeService;
import com.future.trade.api.vo.ReqOrderActionVO;
import com.future.trade.api.vo.ReqOrderInsertVO;
import com.future.trade.service.TradeMain;

/**
 * 交易接口实现
 * @author caojia
 *
 */
@Service("tradeService")
public class TradeServiceImpl implements TradeService{
    
    @Override
    public int reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) throws TradeException {
        // TODO Auto-generated method stub
        
        CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
        pInputOrder.setBrokerID(TradeMain.BROKER_ID);
        pInputOrder.setInvestorID(TradeMain.USER_ID);
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
        pInputOrder.setUserID(TradeMain.USER_ID);
        pInputOrder.setVolumeCondition(reqOrderInsertVO.getVolumeCondition().getCode());
        pInputOrder.setVolumeTotalOriginal(reqOrderInsertVO.getVolumeTotalOriginal());//手数
        
        int r = TradeMain.traderApi.reqOrderInsert(pInputOrder, reqOrderInsertVO.getRequestID());
        switch (r) {
        case 1:
            throw new TradeException(TradeError.ConnectFailed);
        case 2:
            throw new TradeException(TradeError.UnprocessedRequestsLimit);
        case 3:
            throw new TradeException(TradeError.RPSLimit);
        default:
            break;
        }
            
        return r;
    }

    @Override
    public int reqOrderAction(ReqOrderActionVO reqOrderActionVO) throws TradeException {
        // TODO Auto-generated method stub
        return 0;
    }

    
}
