package com.future.client.entity;

import java.math.BigDecimal;

/**
 * 止盈设置
 * @author caojia
 *
 */
public class TargetProfit {

    //品种
    private String product;
    
    //止损跳数
    private int stopLessTick;
    
    //触发止盈幅度
    private BigDecimal tigger;
    
    //跟踪止盈回撤幅度
    private BigDecimal back;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getStopLessTick() {
        return stopLessTick;
    }

    public void setStopLessTick(int stopLessTick) {
        this.stopLessTick = stopLessTick;
    }

    public BigDecimal getTigger() {
        return tigger;
    }

    public void setTigger(BigDecimal tigger) {
        this.tigger = tigger;
    }

    public BigDecimal getBack() {
        return back;
    }

    public void setBack(BigDecimal back) {
        this.back = back;
    }
    
}
