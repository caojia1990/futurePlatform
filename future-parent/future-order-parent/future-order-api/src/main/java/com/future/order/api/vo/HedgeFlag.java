package com.future.order.api.vo;

public enum HedgeFlag {
    
    Speculation('1', "投机"),
    
    Arbitrage('2', "套利"),
    
    Hedge('1', "套保");
    
    final char code;
    
    final String text;
    
    private HedgeFlag(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static HedgeFlag ofCode(char code){
        for(HedgeFlag hedgeFlag : HedgeFlag.values()){
          if(code == hedgeFlag.getCode()){
            return hedgeFlag;
          }
        }
        return null;  
    }

}
