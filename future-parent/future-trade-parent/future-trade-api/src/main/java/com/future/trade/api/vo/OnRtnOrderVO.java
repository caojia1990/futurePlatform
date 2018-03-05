package com.future.trade.api.vo;

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
     * 经纪公司代码
     */
    private String brokerID;
    
    /**
     * 投资者代码
     */
    private String investorID;
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
     * 自动挂起标志
     */
    private int isAutoSuspend;
    /**
     * 业务单元
     */
    private String businessUnit;
    /**
     * 请求编号
     */
    private int requestID;
    /**
     * 本地报单编号  
     * exchangeID+ traderID+ OrderLocalID
     * 交易席位在向交易所报单时，产生这组交易序列号，标示每一笔发往交易所的报单
     */
    private String orderLocalID;
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
     * 会员代码
     */
    private String participantID;
    /**
     * 客户代码
     */
    private String clientID;
    /**
     * 合约在交易所的代码
     */
    private String exchangeInstID;
    /**
     * 交易所交易员代码
     */
    private String traderID;
    /**
     * 安装编号
     */
    private int installID;
    /**
     * 报单提交状态
     */
    private OrderSubmitStatus orderSubmitStatus;
    /**
     * 报单提示序号
     */
    private int notifySequence;
    /**
     * 交易日
     */
    private String tradingDay;
    /**
     * 结算编号
     */
    private int settlementID;
    
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
    private double volumeTraded;
    /**
     * 剩余数量
     */
    private double volumeTotal;
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
     * 最后修改交易所交易员代码
     */
    private String activeTraderID;
    /**
     * 结算会员编号
     */
    private String clearingPartID;
    /**
     * 序号
     */
    private int sequenceNo;
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
     * 用户端产品信息
     */
    private String userProductInfo;
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
    public int getIsAutoSuspend() {
        return isAutoSuspend;
    }
    public void setIsAutoSuspend(int isAutoSuspend) {
        this.isAutoSuspend = isAutoSuspend;
    }
    public String getBusinessUnit() {
        return businessUnit;
    }
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    public int getRequestID() {
        return requestID;
    }
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }
    public String getOrderLocalID() {
        return orderLocalID;
    }
    public void setOrderLocalID(String orderLocalID) {
        this.orderLocalID = orderLocalID;
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
    public String getExchangeInstID() {
        return exchangeInstID;
    }
    public void setExchangeInstID(String exchangeInstID) {
        this.exchangeInstID = exchangeInstID;
    }
    public String getTraderID() {
        return traderID;
    }
    public void setTraderID(String traderID) {
        this.traderID = traderID;
    }
    public int getInstallID() {
        return installID;
    }
    public void setInstallID(int installID) {
        this.installID = installID;
    }
    public OrderSubmitStatus getOrderSubmitStatus() {
        return orderSubmitStatus;
    }
    public void setOrderSubmitStatus(OrderSubmitStatus orderSubmitStatus) {
        this.orderSubmitStatus = orderSubmitStatus;
    }
    public int getNotifySequence() {
        return notifySequence;
    }
    public void setNotifySequence(int notifySequence) {
        this.notifySequence = notifySequence;
    }
    public String getTradingDay() {
        return tradingDay;
    }
    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }
    public int getSettlementID() {
        return settlementID;
    }
    public void setSettlementID(int settlementID) {
        this.settlementID = settlementID;
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
    public void setVolumeTraded(double volumeTraded) {
        this.volumeTraded = volumeTraded;
    }
    public double getVolumeTotal() {
        return volumeTotal;
    }
    public void setVolumeTotal(double volumeTotal) {
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
    public String getActiveTraderID() {
        return activeTraderID;
    }
    public void setActiveTraderID(String activeTraderID) {
        this.activeTraderID = activeTraderID;
    }
    public String getClearingPartID() {
        return clearingPartID;
    }
    public void setClearingPartID(String clearingPartID) {
        this.clearingPartID = clearingPartID;
    }
    public int getSequenceNo() {
        return sequenceNo;
    }
    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
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
    public String getUserProductInfo() {
        return userProductInfo;
    }
    public void setUserProductInfo(String userProductInfo) {
        this.userProductInfo = userProductInfo;
    }
    public String getStatusMsg() {
        return statusMsg;
    }
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
    
    

}
