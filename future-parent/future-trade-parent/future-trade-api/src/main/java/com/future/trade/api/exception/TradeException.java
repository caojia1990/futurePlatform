package com.future.trade.api.exception;

/**
 * 交易接口异常类
 * @author caojia
 */
public class TradeException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -8309432584021846210L;
    
    final String errorCode;
    
    final String errorMsg;
    
    public TradeException(String errorCode, String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public TradeException(String errorCode, String errorMsg, Throwable cause){
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public TradeException(TradeError tradeError){
        super(tradeError.errorMsg);
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
