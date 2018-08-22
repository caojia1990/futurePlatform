package com.future.quota.api.exception;

public enum QuotaError {
    
    Success("00000", "成功");
    
    final String errorCode;
    
    final String errorMsg;
    
    private QuotaError(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
