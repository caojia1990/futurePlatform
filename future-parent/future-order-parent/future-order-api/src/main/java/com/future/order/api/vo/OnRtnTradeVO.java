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
    private String orderRef;
    
    /**
     * 用户代码
     */
    private String userID;
    
    /**
     * 交易所代码
     */
    private String exchangeID;
    
    /**
     * 成交编号
     */
    private String tradeID;
    
    /**
     * 买卖方向
     */
    private Direction direction;
    
    /**
     * 报单编号
     */
    private String orderSysID;
    
    /**
     * 合约在交易所的代码
     */
    private String exchangeInstID;
    
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

    public String getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(String exchangeID) {
        this.exchangeID = exchangeID;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
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
        return "OnRtnTradeVO [investorID=" + investorID + ", accountNo=" + accountNo + ", instrumentID=" + instrumentID
                + ", orderRef=" + orderRef + ", userID=" + userID + ", exchangeID=" + exchangeID + ", tradeID="
                + tradeID + ", direction=" + direction + ", orderSysID=" + orderSysID + ", exchangeInstID="
                + exchangeInstID + ", offsetFlag=" + offsetFlag + ", hedgeFlag=" + hedgeFlag + ", price=" + price
                + ", volume=" + volume + ", tradeDate=" + tradeDate + ", tradeTime=" + tradeTime + ", tradeType="
                + tradeType + ", sequenceNo=" + sequenceNo + ", tradingDay=" + tradingDay + "]";
    }
    
}
