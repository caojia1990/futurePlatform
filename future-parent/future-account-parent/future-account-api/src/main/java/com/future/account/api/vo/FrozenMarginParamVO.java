package com.future.account.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 冻结保证金入参
 * @author caojia
 */
public class FrozenMarginParamVO implements Serializable{

    
    /**
     * 
     */
    private static final long serialVersionUID = -7947700911816534357L;

    /**
     * 投资者账号
     */
    private String investorNo;

    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 合约编号
     */
    private String instrumentId;
    
    /**
     * 交易手数
     */
    private int volume;
    
    /**
     * 交易价格
     */
    private BigDecimal limitPrice;
    
    /**
     * 买卖方向 0：买  1：卖
     */
    private String direction;

    public String getInvestorNo() {
        return investorNo;
    }

    public void setInvestorNo(String investorNo) {
        this.investorNo = investorNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
}
