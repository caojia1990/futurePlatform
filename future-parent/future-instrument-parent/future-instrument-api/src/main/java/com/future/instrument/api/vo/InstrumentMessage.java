package com.future.instrument.api.vo;

public class InstrumentMessage {
    
    //消息类型 0：新增  1：修改  2：删除
    private String messageType;

    private InvestorInstrumentVO message;

    /**
     * 消息类型
     * @return  0：新增  1：修改  2：删除
     */
    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public InvestorInstrumentVO getMessage() {
        return message;
    }

    public void setMessage(InvestorInstrumentVO message) {
        this.message = message;
    }
    
    
}
