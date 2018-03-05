package com.future.trade.api.vo;

/**
 * 组合套保标志
 * @author caojia
 *
 */
public enum CombHedgeFlag {
    
    Speculation("1", "投机"),
    
    Arbitrage("2", "套利"),
    
    Hedge("1", "套保");
    
    final String code;
    
    final String text;
    
    private CombHedgeFlag(String code, String text){
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static CombHedgeFlag ofCode(String code){
        for(CombHedgeFlag combHedgeFlag : CombHedgeFlag.values()){
          if(code.equals(combHedgeFlag.getCode())){
            return combHedgeFlag;
          }
        }
        return null;  
    }

}
