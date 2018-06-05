package com.future.order.api.vo;

import java.io.Serializable;

/**
 * 成交回报
 * @author caojia
 *
 */
public class OnRtnTradeVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -5737531848459078186L;

    /**
     * 客户端请求编号，报单时传入的值
     */
    private int clientRequestId;
    
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
     * 交易所代码
     */
    private String exchangeId;
    
    /**
     * 成交编号
     */
    private String tradeId;
    
    /**
     * 买卖方向
     */
    private Direction direction;
    
    /**
     * 报单编号
     */
    private String orderSysId;
    
    /**
     * 合约在交易所的代码
     */
    private String exchangeInstId;
    
    /**
     * 开平标志
     */
    private OffsetFlag offsetFlag;
    
    /**
     * 投机套保标志
     */
    private HedgeFlag hedgeFlag;
    
    /**
     * 价格
     */
    private double price;
    
    /**
     * 数量
     */
    private int volume;
    
    /**
     * 成交时期
     */
    private String tradeDate;
    
    /**
     * 成交时间
     */
    private String tradeTime;
    
    /**
     * 成交类型
     */
    private char tradeType;
    
    
    /**
     * 序号
     */
    private int sequenceNo;
    
    /**
     * 交易日
     */
    private String tradingDay;

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
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

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getOrderSysId() {
        return orderSysId;
    }

    public void setOrderSysId(String orderSysId) {
        this.orderSysId = orderSysId;
    }

    public String getExchangeInstId() {
        return exchangeInstId;
    }

    public void setExchangeInstId(String exchangeInstId) {
        this.exchangeInstId = exchangeInstId;
    }

    public OffsetFlag getOffsetFlag() {
        return offsetFlag;
    }

    public void setOffsetFlag(OffsetFlag offsetFlag) {
        this.offsetFlag = offsetFlag;
    }

    public HedgeFlag getHedgeFlag() {
        return hedgeFlag;
    }

    public void setHedgeFlag(HedgeFlag hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public char getTradeType() {
        return tradeType;
    }

    public void setTradeType(char tradeType) {
        this.tradeType = tradeType;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String toString() {
        return "OnRtnTradeVO [investorId=" + investorId + ", accountNo=" + accountNo + ", instrumentId=" + instrumentId
                + ", orderRef=" + orderRef + ", userId=" + userId + ", exchangeId=" + exchangeId + ", tradeId="
                + tradeId + ", direction=" + direction + ", orderSysId=" + orderSysId + ", exchangeInstId="
                + exchangeInstId + ", offsetFlag=" + offsetFlag + ", hedgeFlag=" + hedgeFlag + ", price=" + price
                + ", volume=" + volume + ", tradeDate=" + tradeDate + ", tradeTime=" + tradeTime + ", tradeType="
                + tradeType + ", sequenceNo=" + sequenceNo + ", tradingDay=" + tradingDay + "]";
    }
    
}
