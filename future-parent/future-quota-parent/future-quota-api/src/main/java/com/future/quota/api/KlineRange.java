package com.future.quota.api;

/**
 * K线时间轴
 * @author caojia
 */
public class KlineRange {

    /**
     * 序号
     */
    private int sequence;
    
    /**
     * 品种
     */
    private String product;
    
    /**
     * 周期类型
     */
    private String period;
    
    /**
     * 标题
     */
    private String title;
    
    /**
     * 开始时间
     */
    private String beginTime;
    
    /**
     * 结束时间
     */
    private String endTime;

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}
