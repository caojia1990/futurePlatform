package com.future.order.api.service;

import com.future.common.exception.CommonFutureException;
import com.future.order.api.vo.ReqOrderActionVO;
import com.future.order.api.vo.ReqOrderInsertVO;

/**
 * 报单接口
 * @author caojia
 *
 */
public interface OrderService {
	
	/**
	 * 报单录入
	 * @param reqOrderInsertVO
	 */
	public void reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) throws CommonFutureException;
	
	/**
	 * 报单操作
	 * @param reqOrderActionVO
	 * @throws CommonFutureException
	 */
	public void reqOrderAction(ReqOrderActionVO reqOrderActionVO) throws CommonFutureException;
    
    /**
     * 开仓
     */
    public void openOrder();
    
    /**
     * 撤单
     */
    public void cancelOrder(String investorNo, String acountNo, String orderRef);
    
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
