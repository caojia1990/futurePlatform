package com.future.order.api.exception;

public enum OrderError {
    
    /**
     * 与CTP网络连接失败
     */
    DIRECTION_REQUIRED("O00001", "买卖方向为空"),
    
    INVESTORID_REQUIRED("O00002", "投资者代码为空"),
    
    ACCOUNT_NO_REQUIRED("O00003", "账户号为空");

    final String errorCode;
    
    final String errorMsg;
    
    private OrderError(String errorCode, String errorMsg){
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
