package com.future.client.entity;

/**
 * 平仓关系
 * @author caojia
 *
 */
public class CloseRelation {
    
    //客户端请求ID
    private String clientRequestId;
    
    //开仓成交ID
    private String openTradeId;
    
    //开仓日期
    private String openDate;

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getOpenTradeId() {
        return openTradeId;
    }

    public void setOpenTradeId(String openTradeId) {
        this.openTradeId = openTradeId;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    
}
