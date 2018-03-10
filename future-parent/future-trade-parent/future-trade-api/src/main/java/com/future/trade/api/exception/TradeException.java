package com.future.trade.api.exception;

import com.future.common.exception.CommonFutureException;

/**
 * 交易接口异常类
 * @author caojia
 */
public class TradeException extends CommonFutureException{

    /**
     * 
     */
    private static final long serialVersionUID = -8309432584021846210L;
    
    static final String SERVICE_NAME = "trade-service";
    
    final String errorCode;
    
    final String errorMsg;
    
    public TradeException(String errorCode, String errorMsg){
        super(SERVICE_NAME, errorCode, errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public TradeException(String errorCode, String errorMsg, Throwable cause){
    		super(SERVICE_NAME, errorCode, errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public TradeException(TradeError tradeError){
    		super(SERVICE_NAME, tradeError.errorCode, tradeError.errorMsg);
        this.errorCode = tradeError.errorCode;
        this.errorMsg = tradeError.errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    
}
