package com.future.trade.api.service;

import com.future.trade.api.exception.TradeException;
import com.future.trade.api.vo.ReqOrderActionVO;
import com.future.trade.api.vo.ReqOrderInsertVO;

/**
 * 交易接口
 * @author caojia
 *
 */
public interface TradeService {
    
    /**
     * 下单接口
     * @return
     */
    public int reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) throws TradeException;
    
    /**
     * 撤单接口
     * @param reqOrderActionVO
     * @return
     * @throws TradeException
     */
    public int reqOrderAction(ReqOrderActionVO reqOrderActionVO) throws TradeException;

}
