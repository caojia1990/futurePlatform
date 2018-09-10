package com.future.quota.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 指数移动平均
 * @author caojia
 *
 */
public class EMA implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -1973357561470774731L;

    private String instrumentId;
    
    private String tradingDay;
    
    private String title;
    
    private String period;
    
    private BigDecimal ema5;
    
    private BigDecimal ema10;
    
    private BigDecimal ema20;
    
    private BigDecimal ema30;
    
    private BigDecimal ema60;
    
    private BigDecimal ema619;
    
    private BigDecimal highestPrice;
    
    private BigDecimal lowestPrice;
    
    private BigDecimal upperPrice;
    
    private BigDecimal lowerPrice;
    
    private BigDecimal closePrice;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getEma5() {
        return ema5;
    }

    public void setEma5(BigDecimal ema5) {
        this.ema5 = ema5;
    }

    public BigDecimal getEma10() {
        return ema10;
    }

    public void setEma10(BigDecimal ema10) {
        this.ema10 = ema10;
    }

    public BigDecimal getEma20() {
        return ema20;
    }

    public void setEma20(BigDecimal ema20) {
        this.ema20 = ema20;
    }

    public BigDecimal getEma30() {
        return ema30;
    }

    public void setEma30(BigDecimal ema30) {
        this.ema30 = ema30;
    }

    public BigDecimal getEma60() {
        return ema60;
    }

    public void setEma60(BigDecimal ema60) {
        this.ema60 = ema60;
    }

    public BigDecimal getEma619() {
        return ema619;
    }

    public void setEma619(BigDecimal ema619) {
        this.ema619 = ema619;
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

    public BigDecimal getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(BigDecimal highestPrice) {
        this.highestPrice = highestPrice;
    }

    public BigDecimal getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(BigDecimal lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }
    
}
