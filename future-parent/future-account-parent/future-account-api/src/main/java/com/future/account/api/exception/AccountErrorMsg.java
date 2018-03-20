package com.future.account.api.exception;

/**
 * 异常信息类
 * @author caojia
 */
public enum AccountErrorMsg {
    
    /**
     * 系统异常
     */
    UnexpectedError("00001", "系统异常"),
    
    /**
     * 账户资金不足
     */
    NoMoreMoney("00002", "账户资金不足");
    
    final String code;
    
    final String msg;
    
    private AccountErrorMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
}
