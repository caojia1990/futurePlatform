package com.future.trade.api.vo;

import java.io.Serializable;

/**
 * 撤单入参
 * @author caojia
 *
 */
public class ReqOrderActionVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -412905252182731164L;

    /**
     * 经纪公司代码
     */
    private String brokerID;
    
    /**
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 报单操作引用
     */
    private String orderActionRef;
    
    /**
     * 报单引用
     */
    private String orderRef;
    
    /**
     * 请求编号
     */
    private String requestID;
    
    /**
     * 前置编号
     */
    private int frontID;
    
    /**
     * 会话编号
     */
    private String sessionID;
    
    /**
     * 交易所代码
     */
    private String exchangeID;
    
    /**
     * 报单编号
     */
    private String orderSysID;
    
    /**
     * 操作标志
     */
    private ActionFlag actionFlag;
    
    /**
     * 价格
     */
    private double limitPrice;
    
    /**
     * 数量变化
     */
    private int volumeChange;
    
    /**
     * 操作日期
     */
    private String actionDate;
    
    /**
     * 操作时间
     */
    private String actionTime;
    
    /**
     * 交易所交易员代码
     */
    private String traderID;
    
    /**
     * 安装编号
     */
    private String installID;
    
    /**
     * 本地报单编号
     */
    private String orderLocalID;
    
    /**
     * 操作本地编号
     */
    private String actionLocalID;
    
    /**
     * 会员代码
     */
    private String participantID;
    
    /**
     * 客户代码
     */
    private String clientID;
    
    /**
     * 业务单元
     */
    private String businessUnit;
    
    /**
     * 报单操作状态
     */
    private OrderActionStatus orderActionStatus;
    
    /**
     * 用户代码
     */
    private String userID;
    
    /**
     * 状态信息
     */
    private String statusMsg;

    public String getBrokerID() {
        return brokerID;
    }

    public void setBrokerID(String brokerID) {
        this.brokerID = brokerID;
    }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public String getOrderActionRef() {
        return orderActionRef;
    }

    public void setOrderActionRef(String orderActionRef) {
        this.orderActionRef = orderActionRef;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public int getFrontID() {
        return frontID;
    }

    public void setFrontID(int frontID) {
        this.frontID = frontID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(String exchangeID) {
        this.exchangeID = exchangeID;
    }

    public String getOrderSysID() {
        return orderSysID;
    }

    public void setOrderSysID(String orderSysID) {
        this.orderSysID = orderSysID;
    }

    public ActionFlag getActionFlag() {
        return actionFlag;
    }

    public void setActionFlag(ActionFlag actionFlag) {
        this.actionFlag = actionFlag;
    }

    public double getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(double limitPrice) {
        this.limitPrice = limitPrice;
    }

    public int getVolumeChange() {
        return volumeChange;
    }

    public void setVolumeChange(int volumeChange) {
        this.volumeChange = volumeChange;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getTraderID() {
        return traderID;
    }

    public void setTraderID(String traderID) {
        this.traderID = traderID;
    }

    public String getInstallID() {
        return installID;
    }

    public void setInstallID(String installID) {
        this.installID = installID;
    }

    public String getOrderLocalID() {
        return orderLocalID;
    }

    public void setOrderLocalID(String orderLocalID) {
        this.orderLocalID = orderLocalID;
    }

    public String getActionLocalID() {
        return actionLocalID;
    }

    public void setActionLocalID(String actionLocalID) {
        this.actionLocalID = actionLocalID;
    }

    public String getParticipantID() {
        return participantID;
    }

    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public OrderActionStatus getOrderActionStatus() {
        return orderActionStatus;
    }

    public void setOrderActionStatus(OrderActionStatus orderActionStatus) {
        this.orderActionStatus = orderActionStatus;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
    
    
}
