package com.future.trade.api.vo;

/**
 * 报单提交状态
 * @author caojia
 *
 */
public enum OrderSubmitStatus {

    /**
     * 已提交
     */
    InsertSubmitted('0', "已提交"),
    
    /**
     * 撤单已提交
     */
    CancelSubmitted('1', "撤单已提交"),
    
    /**
     * 修改已提交
     */
    ModifySubmitted('2', "修改已提交"),
    
    /**
     * 已接受
     */
    Accepted('3', "已接受"),
    
    /**
     * 报单已被拒绝
     */
    InsertRejected('4', "报单已被拒绝"),
    
    /**
     * 撤单已被拒绝
     */
    CancelRejected('5', "撤单已被拒绝"),
    
    /**
     * 改单已被拒绝
     */
    ModifyRejected('6', "改单已被拒绝");
    
    final char code;
    
    final String text;
    
    private OrderSubmitStatus(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
    
    public static OrderSubmitStatus ofCode(char code){
        for(OrderSubmitStatus orderSubmitStatus : OrderSubmitStatus.values()){
          if(code == orderSubmitStatus.getCode()){
            return orderSubmitStatus;
          }
        }
        return null;  
    }
}
