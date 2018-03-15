package com.future.order.api.vo;

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
    
    public static Direction ofCode(char code){
        for(Direction direction : Direction.values()){
          if(code == direction.getCode()){
            return direction;
          }
        }
        return null;  
    }
    
}
