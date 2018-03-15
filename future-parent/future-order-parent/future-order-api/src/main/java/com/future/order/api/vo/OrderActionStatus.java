package com.future.order.api.vo;

/**
 * 报单操作状态
 * @author caojia
 *
 */
public enum OrderActionStatus {
    
    Submitted('a', "已提交"),
    
    Accepted('b', "已接受"),
    
    Rejected('c', "已拒绝");
    
    final char code;
    
    final String text;
    
    private OrderActionStatus(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static OrderActionStatus ofCode(char code){
        for(OrderActionStatus orderActionStatus : OrderActionStatus.values()){
          if(code == orderActionStatus.getCode()){
            return orderActionStatus;
          }
        }
        return null;  
    }

}
