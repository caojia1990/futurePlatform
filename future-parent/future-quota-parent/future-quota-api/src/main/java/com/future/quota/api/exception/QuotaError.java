package com.future.quota.api.exception;

public enum QuotaError {
    
    Success("00000", "成功"),
    
    GET_EMA_FAILED("Q00001", "获取EMA指标异常"),
    
    SAVE_EMA_FAILED("Q00002", "保存EMA指标异常"),
    
    REMOVE_EMA_FAILED("Q00003", "删除EMA指标异常");
    
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
