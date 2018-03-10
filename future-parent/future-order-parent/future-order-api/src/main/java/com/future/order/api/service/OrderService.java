package com.future.order.api.service;

import com.future.trade.api.vo.ReqOrderInsertVO;

/**
 * 报单接口
 * @author caojia
 *
 */
public interface OrderService {
	
	/**
	 * 报单接口
	 * @param reqOrderInsertVO
	 */
	public void reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO);
    
    /**
     * 开仓
     */
    public void openOrder();
    
    /**
     * 撤单
     */
    public void cancelOrder();
    
    /**
     * 平仓
     */
    public void closeOrder();
    
    /**
     * 平今
     */
    public void closeToday();
    
    /**
     * 查询报单
     */
    public void queryOrder();
    

}
