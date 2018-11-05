package com.future.common.exception;

public enum CommonError {
    
    EXEC_SQL_ERROR("C00001", "执行sql语句异常");

    final String errorCode;
    
    final String errorMsg;
    
    private CommonError(String errorCode, String errorMsg){
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
