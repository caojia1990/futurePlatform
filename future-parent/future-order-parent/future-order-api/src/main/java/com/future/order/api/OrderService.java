package com.future.order.api;

/**
 * 报单接口
 * @author caojia
 *
 */
public interface OrderService {
    
    /**
     * 报单
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
