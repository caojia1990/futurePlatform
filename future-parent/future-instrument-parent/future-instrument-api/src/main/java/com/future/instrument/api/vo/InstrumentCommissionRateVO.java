package com.future.instrument.api.vo;

import java.io.Serializable;

/**
 * 合约手续费率
 * @author caojia
 *
 */
public class InstrumentCommissionRateVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -4215060489674157148L;

    /**
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 合约
     */
    private String instrumentID;
    
    /**
     * 
     */
    private char investorRange;
    
    /**
     * 开仓手续费率（按金额百分比）
     */
    private double openRatioByMoney;
    
    /**
     * 开仓手续费率（按每手）
     */
    private double openRatioByVolume;
    
    /**
     * 平仓手续费率（按金额百分比）
     */
    private double closeRatioByMoney;
    
    /**
     * 平仓手续费率（按每手）
     */
    private double closeRatioByVolume;
    
    /**
     * 平今手续费率（按金额百分比）
     */
    private double closeTodayRatioByMoney;
    
    /**
     * 平今手续费率（按每手）
     */
    private double closeTodayRatioByVolume;

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

    public char getInvestorRange() {
        return investorRange;
    }

    public void setInvestorRange(char investorRange) {
        this.investorRange = investorRange;
    }

    public double getOpenRatioByMoney() {
        return openRatioByMoney;
    }

    public void setOpenRatioByMoney(double openRatioByMoney) {
        this.openRatioByMoney = openRatioByMoney;
    }

    public double getOpenRatioByVolume() {
        return openRatioByVolume;
    }

    public void setOpenRatioByVolume(double openRatioByVolume) {
        this.openRatioByVolume = openRatioByVolume;
    }

    public double getCloseRatioByMoney() {
        return closeRatioByMoney;
    }

    public void setCloseRatioByMoney(double closeRatioByMoney) {
        this.closeRatioByMoney = closeRatioByMoney;
    }

    public double getCloseRatioByVolume() {
        return closeRatioByVolume;
    }

    public void setCloseRatioByVolume(double closeRatioByVolume) {
        this.closeRatioByVolume = closeRatioByVolume;
    }

    public double getCloseTodayRatioByMoney() {
        return closeTodayRatioByMoney;
    }

    public void setCloseTodayRatioByMoney(double closeTodayRatioByMoney) {
        this.closeTodayRatioByMoney = closeTodayRatioByMoney;
    }

    public double getCloseTodayRatioByVolume() {
        return closeTodayRatioByVolume;
    }

    public void setCloseTodayRatioByVolume(double closeTodayRatioByVolume) {
        this.closeTodayRatioByVolume = closeTodayRatioByVolume;
    }
    
}
