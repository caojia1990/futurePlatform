package com.future.order.api.vo;

/**
 * 下单参数
 * @author caojia
 *
 */
public class ReqOrderInsertVO extends OnRspInfo{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -7390751012439707057L;

    /**
     * 客户端请求编号（由客户端指定，报单和成交返回时会带上该编号）
     */
    private String clientRequestId;
    
    /**
     * 请求编号（由下单中心指定）
     */
    private int requestId;
    
    /**
     * 投资者代码
     */
    private String investorId;
    
    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 合约代码
     */
    private String instrumentId;
    
    /**
     * 报单引用
     */
    private String orderRef;
    
    /**
     * 用户代码
     */
    private String userId;
    
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
    
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestID) {
        this.requestId = requestID;
    }

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorID) {
        this.investorId = investorID;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

}
