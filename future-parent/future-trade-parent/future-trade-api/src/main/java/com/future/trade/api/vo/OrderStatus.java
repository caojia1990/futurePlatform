package com.future.trade.api.vo;

/**
 * 报单状态
 * @author caojia
 *
 */
public enum OrderStatus {
    
    /**
     * 
     */
    AllTraded('0', "全部成交"),
    
    /**
     * 部分成交还在队列中
     */
    PartTradedQueueing('1', "部分成交还在队列中"),
    
    /**
     * 部分成交不在队列中
     */
    PartTradedNotQueueing('2', "部分成交不在队列中"),
    
    /**
     * 未成交还在队列中
     */
    NoTradeQueueing('3', "未成交还在队列中"),
    
    /**
     * 未成交不在队列中
     */
    NoTradeNotQueueing('4', "未成交不在队列中"),
    
    /**
     * 已撤单
     */
    Canceled('5', "已撤单"),
    
    /**
     * 未知
     */
    Unknown('a', "未知"),
    
    /**
     * 未触发
     */
    NotTouched('b', "未触发"),
    
    /**
     * 已触发
     */
    Touched('c', "已触发");
    
    final char code;
    
    final String text;
    
    private OrderStatus(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static OrderStatus ofCode(char code){
        for(OrderStatus orderStatus : OrderStatus.values()){
          if(code == orderStatus.getCode()){
            return orderStatus;
          }
        }
        return null;  
    }

}
