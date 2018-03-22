package com.future.order.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 投资者持仓明细
 * @author caojia
 *
 */
public class InvestorPositionDetailVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -5560766673523616722L;
    
    /**
     * 合约代码
     */
    private String instrumentID;

    /**
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 投机套保标志
     */
    private HedgeFlag hedgeFlag;
    
    /**
     * 买卖方向
     */
    private Direction direction;
    
    /**
     * 开仓日期
     */
    private String openDate;
    
    /**
     * 成交编号
     */
    private String tradeID;
    
    /**
     * 数量
     */
    private int volume;
    
    /**
     * 开仓价
     */
    private BigDecimal openPrice;
    
    /**
     * 交易日
     */
    private String tradingDay;
    
    /**
     * 结算编号
     */
    private String settlementID;
    
    /**
     * 成交类型
     */
    private char tradeType;
    
    /**
     * 组合合约代码
     */
    private String combInstrumentID;

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public HedgeFlag getHedgeFlag() {
        return hedgeFlag;
    }

    public void setHedgeFlag(HedgeFlag hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getTradeID() {
        return tradeID;
    }

    public void setTradeID(String tradeID) {
        this.tradeID = tradeID;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getSettlementID() {
        return settlementID;
    }

    public void setSettlementID(String settlementID) {
        this.settlementID = settlementID;
    }

    public char getTradeType() {
        return tradeType;
    }

    public void setTradeType(char tradeType) {
        this.tradeType = tradeType;
    }

    public String getCombInstrumentID() {
        return combInstrumentID;
    }

    public void setCombInstrumentID(String combInstrumentID) {
        this.combInstrumentID = combInstrumentID;
    }
    

}
