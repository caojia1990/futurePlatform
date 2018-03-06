package com.future.trade.api.vo;

/**
 * 开平仓标志
 * @author caojia
 *
 */
public enum OffsetFlag {
    
    OPEN('0', "开仓"),
    
    CLOSE('1', "平仓"),
    
    ForceClose('2', "强平"),
    
    CloseToday('3', "平今"),
    
    CloseYesterday('4', "平昨"),
	
	ForceOff('5', "强减"),
	
	LocalForceClose('6', "本地强平");
    
    final char code;
    
    final String text;
    
    private OffsetFlag(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static OffsetFlag ofCode(char code){
        for(OffsetFlag offsetFlag : OffsetFlag.values()){
          if(code == offsetFlag.getCode()){
            return offsetFlag;
          }
        }
        return null;  
    }
    
}
