package com.future.trade.api.exception;

public enum TradeError {
    
    ConnectFailed("00001", "与CTP网络连接失败"),
    
    UnprocessedRequestsLimit("00002", "未处理请求超过许可数"),
    
    RPSLimit("00003", "每秒发送请求数超过许可数");

    final String errorCode;
    
    final String errorMsg;
    
    private TradeError(String errorCode, String errorMsg){
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
