package com.future.order.api.vo;

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
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 账户编号
     */
    private String accountNo;
    
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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    
}
