package com.future.instrument.api.vo;

import java.io.Serializable;

/**
 * 合约保证金率
 * @author caojia
 */
public class InstrumentMarginRateVO implements Serializable{

    /**
     * 投资者编号
     */
    private String investorID;
    
    /**
     * 
     */
    private char investorRange;
    
    /**
     * 合约编号
     */
    private String instrumentID;
    
    /**
     * 
     */
    private int isRelative;
    
    /**
     * 投机套保标志
     */
    private char hedgeFlag;
    
    /**
     * 多头保证金（按金额）
     */
    private double longMarginRatioByMoney;
    
    /**
     * 多头保证金（按手数）
     */
    private double longMarginRatioByVolume;
    
    /**
     * 多头保证金（按金额）
     */
    private double shortMarginRatioByMoney;
    
    /**
     * 多头保证金（按手数）
     */
    private double shortMarginRatioByVolume;

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public char getInvestorRange() {
        return investorRange;
    }

    public void setInvestorRange(char investorRange) {
        this.investorRange = investorRange;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public int getIsRelative() {
        return isRelative;
    }

    public void setIsRelative(int isRelative) {
        this.isRelative = isRelative;
    }

    public char getHedgeFlag() {
        return hedgeFlag;
    }

    public void setHedgeFlag(char hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    public double getLongMarginRatioByMoney() {
        return longMarginRatioByMoney;
    }

    public void setLongMarginRatioByMoney(double longMarginRatioByMoney) {
        this.longMarginRatioByMoney = longMarginRatioByMoney;
    }

    public double getLongMarginRatioByVolume() {
        return longMarginRatioByVolume;
    }

    public void setLongMarginRatioByVolume(double longMarginRatioByVolume) {
        this.longMarginRatioByVolume = longMarginRatioByVolume;
    }

    public double getShortMarginRatioByMoney() {
        return shortMarginRatioByMoney;
    }

    public void setShortMarginRatioByMoney(double shortMarginRatioByMoney) {
        this.shortMarginRatioByMoney = shortMarginRatioByMoney;
    }

    public double getShortMarginRatioByVolume() {
        return shortMarginRatioByVolume;
    }

    public void setShortMarginRatioByVolume(double shortMarginRatioByVolume) {
        this.shortMarginRatioByVolume = shortMarginRatioByVolume;
    }
    
    
}
