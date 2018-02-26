package com.future.trade.api.vo;

public enum CombOffsetFlag {
    
    OPEN("0", "开仓"),
    
    CLOSE("1", "平仓"),
    
    ForceClose("2", "强平"),
    
    CloseToday("3", "平今"),
    
    CloseYesterday("4", "平昨");
    
    final String code;
    
    final String text;
    
    private CombOffsetFlag(String code, String text){
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
}
