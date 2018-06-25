package com.future.order.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 平仓明细表
 * @author caojia
 */
public class CloseDetailVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -7154977179057334542L;
    
    /**
     * 合约编号
     */
    private String instrumentID;
    
    /**
     * 子账户代码
     */
    private String investorID;
    
    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 平仓手数
     */
    private String volume;
    
    /**
     * 开仓价格
     */
    private BigDecimal openPrice;
    
    /**
     * 开仓日期
     */
    private String openDate;
    
    /**
     * 开仓成交号
     */
    private String openTradeId;
    
    /**
     * 平仓价格
     */
    private BigDecimal closePrice;
    
    /**
     * 平仓日期
     */
    private String closeDate;
    
    /**
     * 平仓成交号
     */
    private String closeTradeId;

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

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getOpenTradeId() {
        return openTradeId;
    }

    public void setOpenTradeId(String openTradeId) {
        this.openTradeId = openTradeId;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCloseTradeId() {
        return closeTradeId;
    }

    public void setCloseTradeId(String closeTradeId) {
        this.closeTradeId = closeTradeId;
    }
    
    
}
