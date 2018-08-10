package com.future.quota.api.vo;

import java.math.BigDecimal;

/**
 * 移动平均线指标
 * @author caojia
 *
 */
public class MA extends MarketQuotations {

    private static final long serialVersionUID = -6567007882552130525L;

    
    private String title;
    
    //周期
    private String persiod;
    
    private BigDecimal ma5;
    
    private BigDecimal ma10;
    
    private BigDecimal ma20;
    
    //是否完成
    private boolean isComplete;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPersiod() {
        return persiod;
    }

    public void setPersiod(String persiod) {
        this.persiod = persiod;
    }

    public BigDecimal getMa5() {
        return ma5;
    }

    public void setMa5(BigDecimal ma5) {
        this.ma5 = ma5;
    }

    public BigDecimal getMa10() {
        return ma10;
    }

    public void setMa10(BigDecimal ma10) {
        this.ma10 = ma10;
    }

    public BigDecimal getMa20() {
        return ma20;
    }

    public void setMa20(BigDecimal ma20) {
        this.ma20 = ma20;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

}
