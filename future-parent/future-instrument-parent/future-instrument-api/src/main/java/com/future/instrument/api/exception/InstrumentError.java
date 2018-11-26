package com.future.instrument.api.exception;

public enum InstrumentError {

    DATABASE_FAILED("I00001", "数据库异常"),
    
    INSTRUMENT_NOT_EXSITS("I00002", "合约不存在"),
    
    INVESTOR_NO_REQUIRED("I00003", "投资者编号不能为空"),

    INSTRUMENT_ID_REQUIRED("I00004", "合约编号不能为空"),
    
    STATUS_REQUIRED("I00005", "合约状态不能为空"),
    
    TARGET_REQUIRED("I00006", "止盈幅度不能为空"),
    
    RETRACEMENT_REQUIRED("I00007", "回撤止盈幅度不能为空"),
    
    HEDGING_TYPE_REQUIRED("I00008", "对冲触发类型不能为空"),
    
    HEDGING_TIGGER_REQUIRED("I00009", "触发对冲比例不能为空"),
    
    HEDGING_VOLUME_REQUIRED("I00010", "对冲手数不能为空"),
    
    HEDGING_STOP_WIN_REQUIRED("I00011", "对冲止盈跳数不能为空"),
    
    HEDGING_VOLUME_ILLEGAL("I00012", "对冲手数不合法"),
    
    HEDGING_STOP_WIN_ILLEGAL("I00013", "对冲止盈跳数不合法"),
    
    HEDGING_TIGGER_ILLEGAL("I00014", "触发对冲比例不合法"),
    
    VOLUME_ILLEGAL("I00015", "开仓手数不合法"),
    
    INSTRUMENT_ALREADY_EXSITS("I00016", "合约已存在"),
    
    GREES_HEDGING_REQUIRED("I00017", "阶梯对冲信息不能为空"),
    
    ;

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
