package com.future.quota.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 通用行情
 * @author caojia
 */
public class MarketQuotations implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1246673588138597360L;

    //合约
    private String instrumentId;
    
    //交易日
    private String tradingDay;
    
    //最新价
    private BigDecimal lastPrice;
    
    //涨停价
    private BigDecimal upperPrice;
    
    //跌停价
    private BigDecimal lowerPrice;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getUpperPrice() {
        return upperPrice;
    }

    public void setUpperPrice(BigDecimal upperPrice) {
        this.upperPrice = upperPrice;
    }

    public BigDecimal getLowerPrice() {
        return lowerPrice;
    }

    public void setLowerPrice(BigDecimal lowerPrice) {
        this.lowerPrice = lowerPrice;
    }
    
}
