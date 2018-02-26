package com.future.trade.api.vo;

/**
 * 买卖方向
 * @author caojia
 */
public enum Direction {
    
    /**
     * 买
     */
    BUY('0',"买"),
    
    /**
     * 卖
     */
    SELL('1',"卖");
    
    final char code;
    
    final String text;
    
    private Direction(char code ,String text){
        this.code = code;
        this.text = text;
    }
    
    public char getCode(){
        return this.code;
    }
    
    public String getText(){
        return this.text;
    }
    
}
