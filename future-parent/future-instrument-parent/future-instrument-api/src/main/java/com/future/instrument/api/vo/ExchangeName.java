/**
 * 
 */
package com.future.instrument.api.vo;

/**
 * @author caojia
 */
public enum ExchangeName {

    /**
     * 上期所
     */
    SHFE("SHFE"),
    
    /**
     * 大商所
     */
    DCE("DCE"),
    
    /**
     * 郑商所
     */
    CZCE("CZCE"),
    
    /**
     * 中金所
     */
    CFFEX("CFFEX");
    
    
    final String exchangeCode;
    
    private ExchangeName(String exchangeCode){
        this.exchangeCode = exchangeCode;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }
    
    
}
