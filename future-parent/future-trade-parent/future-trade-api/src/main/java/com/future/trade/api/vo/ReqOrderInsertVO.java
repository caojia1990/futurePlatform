package com.future.trade.api.vo;

import java.io.Serializable;

/**
 * 下单参数
 * @author caojia
 *
 */
public class ReqOrderInsertVO implements Serializable{

    
    /**
     * 
     */
    private static final long serialVersionUID = 4943864265015243840L;

    /**
     * 请求编号
     */
    private int requestID;
    
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
    private String orderRef;
    
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
     * 自动挂起标志 一般选0
     */
    private int isAutoSuspend;
    
    /**
     * 业务单元
     */
    private String businessUnit;
    
    /**
     * 用户强平标志  一般选0
     */
    private int userForceClose;

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
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
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
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

    public int getUserForceClose() {
        return userForceClose;
    }

    public void setUserForceClose(int userForceClose) {
        this.userForceClose = userForceClose;
    }
    

}
