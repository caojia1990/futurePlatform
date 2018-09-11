package com.future.order.api.exception;

import com.future.common.exception.CommonFutureException;

/**
 * 交易接口异常类
 * @author caojia
 */
public class OrderException extends CommonFutureException{

    /**
     * 
     */
    private static final long serialVersionUID = -8309432584021846210L;
    
    static final String SERVICE_NAME = "order-service";
    
    public OrderException(){
        super();
    }
    
    public OrderException(String errorCode, String errorMsg){
        super(SERVICE_NAME, errorCode, errorMsg);
    }
    
    public OrderException(String errorCode, String errorMsg, Throwable cause){
        super(SERVICE_NAME, errorCode, errorMsg, cause);
    }
    
    public OrderException(OrderError orderError){
        super(SERVICE_NAME, orderError.errorCode, orderError.errorMsg);
    }
    
    public OrderException(OrderError orderError, Throwable cause){
        super(SERVICE_NAME, orderError.errorCode, orderError.errorMsg, cause);
}

}
