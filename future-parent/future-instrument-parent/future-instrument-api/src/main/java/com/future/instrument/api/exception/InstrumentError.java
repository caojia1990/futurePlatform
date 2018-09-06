package com.future.instrument.api.exception;

public enum InstrumentError {

    DATABASE_FAILED("I00001", "数据库异常"),
    
    INSTRUMENT_NOT_EXSITS("I00002", "合约不存在");

    final String errorCode;
    
    final String errorMsg;
    
    private InstrumentError(String errorCode, String errorMsg){
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
