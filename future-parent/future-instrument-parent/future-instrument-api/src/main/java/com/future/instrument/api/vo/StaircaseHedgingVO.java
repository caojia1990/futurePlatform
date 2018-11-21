package com.future.instrument.api.vo;

/**
 * 阶梯对冲
 * @author caojia
 *
 */
public class StaircaseHedgingVO {

    //合约
    private String instrumentId;
    
    //开始对冲跳数
    private int hedgingBeginTick;
    
    //结束对冲跳数
    private int hedgingEndTick;
    
    //对冲手数
    private int hedgingVolume;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public int getHedgingBeginTick() {
        return hedgingBeginTick;
    }

    public void setHedgingBeginTick(int hedgingBeginTick) {
        this.hedgingBeginTick = hedgingBeginTick;
    }

    public int getHedgingEndTick() {
        return hedgingEndTick;
    }

    public void setHedgingEndTick(int hedgingEndTick) {
        this.hedgingEndTick = hedgingEndTick;
    }

    public int getHedgingVolume() {
        return hedgingVolume;
    }

    public void setHedgingVolume(int hedgingVolume) {
        this.hedgingVolume = hedgingVolume;
    }
    
}
