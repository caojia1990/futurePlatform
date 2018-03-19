package com.future.instrument.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 投资者交易参数
 * @author caojai
 *
 */
public class InvestorTradeParamVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -921129388331078396L;
    
    /**
     * 投资者编号
     */
    private String investorNo;
    
    /**
     * 合约编号
     */
    private String instrumentID;
    
    /**
     * 开平仓标志 0：开仓 1：平仓
     */
    private String offset;
    
    /**
     * 买卖方向 0：买 1：卖
     */
    private String direction;
    
    /**
     * 价格类型
     */
    private String priceType;
    
    /**
     * 限价
     */
    private BigDecimal limitPrice;

    public String getInvestorNo() {
        return investorNo;
    }

    public void setInvestorNo(String investorNo) {
        this.investorNo = investorNo;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
    

}
