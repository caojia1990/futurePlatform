package com.future.trade.api.vo;

/**
 * 有效期类型
 * @author caojia
 *
 */
public enum TimeCondition {

    /**
     * 立即完成，否则撤销
     */
    IOC('1'),
    
    /**
     * 本节有效
     */
    GFS('2'),
    
    /**
     * 当日有效
     */
    GFD('3'),
    
    /**
     * 指定日期前有效
     */
    GTD('4'),
    
    /**
     * 撤销前有效
     */
    GTC('5'),
    
    /**
     * 集合竞价有效
     */
    GFA('6');
    
    final char code;
    
    private TimeCondition(char code){
        this.code = code;
    }

    public char getCode() {
        return code;
    }
    
    public static TimeCondition ofCode(char code){
        for(TimeCondition timeCondition : TimeCondition.values()){
          if(code == timeCondition.getCode()){
            return timeCondition;
          }
        }
        return null;  
    }
}
