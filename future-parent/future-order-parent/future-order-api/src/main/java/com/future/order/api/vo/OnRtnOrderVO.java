package com.future.order.api.vo;

import java.io.Serializable;

/**
 * 报单回报
 * @author caojia
 */
public class OnRtnOrderVO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6367780618016491530L;
    
    /**
     * 客户端请求id ,报单请求时传入,最大长度10位
     */
    private String clientRequestId;

    /**
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 合约代码
     */
    private String instrumentID;
    /**
     * 报单引用
     */
    private String OrderRef;
    /**
     * 用户代码
     */
    private String userID;
    /**
     * 报单价格条件
     */
    private OrderPriceType orderPriceType;
    /**
     * 买卖方向
     */
    private Direction direction;
    /**
     * 组合开平标志
     */
    private CombOffsetFlag combOffsetFlag;
    /**
     * 组合投机套保标志
     */
    private CombHedgeFlag combHedgeFlag;
    /**
     * 价格
     */
    private double limitPrice;
    /**
     * 数量
     */
    private int volumeTotalOriginal;
    /**
     * 有效期类型
     */
    private TimeCondition timeCondition;
    /**
     * GTD 日期
     */
    private String gTDDate;
    /**
     * 成交量类型
     */
    private VolumeCondition volumeCondition;
    /**
     * 最小成交量
     */
    private int minVolume;
    /**
     * 触发条件
     */
    private ContingentCondition contingentCondition;
    /**
     * 止损价
     */
    private double stopPrice;
    /**
     * 强平原因
     */
    private ForceCloseReason forceCloseReason;
    
    /**
     * 请求编号
     */
    private int requestID;

    /**
     * 交易所代码
     * exchangeID+ OrderSysID
     * 交易所接受了投资者报单，产生这组交易序列号，标示每一笔收到的报单。用户撤单时也可以使用这组交易序列号
     */
    private String exchangeID;
    
    /**
     * 报单编号
     * exchangeID+ OrderSysID
     * 交易所接受了投资者报单，产生这组交易序列号，标示每一笔收到的报单。用户撤单时也可以使用这组交易序列号
     */
    private String orderSysID;
    
    /**
     * 合约在交易所的代码
     */
    private String exchangeInstID;
    /**
     * 报单提交状态
     */
    private OrderSubmitStatus orderSubmitStatus;
    /**
     * 交易日
     */
    private String tradingDay;
    
    /**
     * 报单来源
     */
    private char orderSource;
    
    /**
     * 报单状态
     */
    private OrderStatus orderStatus;
    
    /**
     * 报单类型
     */
    private char orderType;
    
    /**
     * 今成交数量
     */
    private int volumeTraded;
    
    /**
     * 剩余数量
     */
    private int volumeTotal;
    
    /**
     * 报单日期
     */
    private String insertDate;
    
    /**
     * 插入时间
     */
    private String insertTime;
    
    /**
     * 激活时间
     */
    private String activeTime;
    
    /**
     * 挂起时间
     */
    private String suspendTime;
    
    /**
     * 最后修改时间
     */
    private String updateTime;
    
    /**
     * 撤销时间
     */
    private String cancelTime;
    
    /**
     * 前置编号
     */
    private int frontID;
    
    /**
     * 会话编号
     * FrontID+ SessionID+ OrderRef 
     * 用户使用这组交易序列号可以按照自己的方式来唯一标示发出的任何一笔委托。 
     * 用户登入成功后，会收到前置机编号FrontID, 会话编号SessionID和最大报单引用MaxOrderRef。
     * 用户在报单时设定报单引用OrderRef。OrderRef可以从MaxOrderRef开始递增。 
     * 如果用户没有设定OrderRef，在报单响应中，Thost会为用户设置一个的OrderRef。使得每个报单的这组序列号保持唯一。 
     * 因为这组交易序列号是由用户设定的。所以在没有得到报单响应前，就可以使用这组交易序列号进行撤单操作。
     */
    private int sessionID;
    
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
    public String getInstrumentID() {
        return instrumentID;
    }
    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }
    public String getOrderRef() {
        return OrderRef;
    }
    public void setOrderRef(String orderRef) {
        OrderRef = orderRef;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public OrderPriceType getOrderPriceType() {
        return orderPriceType;
    }
    public void setOrderPriceType(OrderPriceType orderPriceType) {
        this.orderPriceType = orderPriceType;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public CombOffsetFlag getCombOffsetFlag() {
        return combOffsetFlag;
    }
    public void setCombOffsetFlag(CombOffsetFlag combOffsetFlag) {
        this.combOffsetFlag = combOffsetFlag;
    }
    public CombHedgeFlag getCombHedgeFlag() {
        return combHedgeFlag;
    }
    public void setCombHedgeFlag(CombHedgeFlag combHedgeFlag) {
        this.combHedgeFlag = combHedgeFlag;
    }
    public double getLimitPrice() {
        return limitPrice;
    }
    public void setLimitPrice(double limitPrice) {
        this.limitPrice = limitPrice;
    }
    public int getVolumeTotalOriginal() {
        return volumeTotalOriginal;
    }
    public void setVolumeTotalOriginal(int volumeTotalOriginal) {
        this.volumeTotalOriginal = volumeTotalOriginal;
    }
    public TimeCondition getTimeCondition() {
        return timeCondition;
    }
    public void setTimeCondition(TimeCondition timeCondition) {
        this.timeCondition = timeCondition;
    }
    public String getgTDDate() {
        return gTDDate;
    }
    public void setgTDDate(String gTDDate) {
        this.gTDDate = gTDDate;
    }
    public VolumeCondition getVolumeCondition() {
        return volumeCondition;
    }
    public void setVolumeCondition(VolumeCondition volumeCondition) {
        this.volumeCondition = volumeCondition;
    }
    public int getMinVolume() {
        return minVolume;
    }
    public void setMinVolume(int minVolume) {
        this.minVolume = minVolume;
    }
    public ContingentCondition getContingentCondition() {
        return contingentCondition;
    }
    public void setContingentCondition(ContingentCondition contingentCondition) {
        this.contingentCondition = contingentCondition;
    }
    public double getStopPrice() {
        return stopPrice;
    }
    public void setStopPrice(double stopPrice) {
        this.stopPrice = stopPrice;
    }
    public ForceCloseReason getForceCloseReason() {
        return forceCloseReason;
    }
    public void setForceCloseReason(ForceCloseReason forceCloseReason) {
        this.forceCloseReason = forceCloseReason;
    }
    public int getRequestID() {
        return requestID;
    }
    public void setRequestID(int requestID) {
        this.requestID = requestID;
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
    public String getExchangeInstID() {
        return exchangeInstID;
    }
    public void setExchangeInstID(String exchangeInstID) {
        this.exchangeInstID = exchangeInstID;
    }
    public OrderSubmitStatus getOrderSubmitStatus() {
        return orderSubmitStatus;
    }
    public void setOrderSubmitStatus(OrderSubmitStatus orderSubmitStatus) {
        this.orderSubmitStatus = orderSubmitStatus;
    }
    public String getTradingDay() {
        return tradingDay;
    }
    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }
    public char getOrderSource() {
        return orderSource;
    }
    public void setOrderSource(char orderSource) {
        this.orderSource = orderSource;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public char getOrderType() {
        return orderType;
    }
    public void setOrderType(char orderType) {
        this.orderType = orderType;
    }
    public double getVolumeTraded() {
        return volumeTraded;
    }
    public void setVolumeTraded(int volumeTraded) {
        this.volumeTraded = volumeTraded;
    }
    public double getVolumeTotal() {
        return volumeTotal;
    }
    public void setVolumeTotal(int volumeTotal) {
        this.volumeTotal = volumeTotal;
    }
    public String getInsertDate() {
        return insertDate;
    }
    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
    public String getInsertTime() {
        return insertTime;
    }
    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
    public String getActiveTime() {
        return activeTime;
    }
    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }
    public String getSuspendTime() {
        return suspendTime;
    }
    public void setSuspendTime(String suspendTime) {
        this.suspendTime = suspendTime;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getCancelTime() {
        return cancelTime;
    }
    public void setCancelTime(String cancelTime) {
        this.cancelTime = cancelTime;
    }
    public int getFrontID() {
        return frontID;
    }
    public void setFrontID(int frontID) {
        this.frontID = frontID;
    }
    public int getSessionID() {
        return sessionID;
    }
    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
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
    
    
    public String getClientRequestId() {
        return clientRequestId;
    }
    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }
    @Override
    public String toString() {
        return "OnRtnOrderVO [clientRequestId=" + clientRequestId + ", investorID=" + investorID + ", accountNo="
                + accountNo + ", instrumentID=" + instrumentID + ", OrderRef=" + OrderRef + ", userID=" + userID
                + ", orderPriceType=" + orderPriceType + ", direction=" + direction + ", combOffsetFlag="
                + combOffsetFlag + ", combHedgeFlag=" + combHedgeFlag + ", limitPrice=" + limitPrice
                + ", volumeTotalOriginal=" + volumeTotalOriginal + ", timeCondition=" + timeCondition + ", gTDDate="
                + gTDDate + ", volumeCondition=" + volumeCondition + ", minVolume=" + minVolume
                + ", contingentCondition=" + contingentCondition + ", stopPrice=" + stopPrice + ", forceCloseReason="
                + forceCloseReason + ", requestID=" + requestID + ", exchangeID=" + exchangeID + ", orderSysID="
                + orderSysID + ", exchangeInstID=" + exchangeInstID + ", orderSubmitStatus=" + orderSubmitStatus
                + ", tradingDay=" + tradingDay + ", orderSource=" + orderSource + ", orderStatus=" + orderStatus
                + ", orderType=" + orderType + ", volumeTraded=" + volumeTraded + ", volumeTotal=" + volumeTotal
                + ", insertDate=" + insertDate + ", insertTime=" + insertTime + ", activeTime=" + activeTime
                + ", suspendTime=" + suspendTime + ", updateTime=" + updateTime + ", cancelTime=" + cancelTime
                + ", frontID=" + frontID + ", sessionID=" + sessionID + ", statusMsg=" + statusMsg + "]";
    }
    
    

}
