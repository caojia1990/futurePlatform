package com.future.quota.api.exception;

import com.future.common.exception.CommonFutureException;

public class QuotaException extends CommonFutureException{

    /**
     * 
     */
    private static final long serialVersionUID = -1191683224908536102L;

    /**
     * 
     */
    
    static final String SERVICE_NAME = "quota-service";
    
    final String errorCode;
    
    final String errorMsg;

    public QuotaException(String errorCode, String errorMsg) {
        super(SERVICE_NAME, errorCode, errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public QuotaException(String errorCode, String errorMsg, Throwable cause) {
        super(SERVICE_NAME, errorCode, errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    
    public QuotaException(QuotaError quotaError) {
        super(SERVICE_NAME, quotaError.errorCode, quotaError.errorMsg);
        this.errorCode = quotaError.errorCode;
        this.errorMsg = quotaError.errorMsg;
    }
    
    public QuotaException(QuotaError quotaError, Throwable cause) {
        super(SERVICE_NAME, quotaError.errorCode, quotaError.errorMsg, cause);
        this.errorCode = quotaError.errorCode;
        this.errorMsg = quotaError.errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
    

}
