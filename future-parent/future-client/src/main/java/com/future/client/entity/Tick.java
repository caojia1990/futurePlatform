package com.future.client.entity;

public class Tick {
    
    private String instrumentId;
    
    private double lastPrice;
    
    private double bidPrice;
    
    private int bidVoume;
    
    private double askPrice;
    
    private int askVolume;
    
    private int volume;
    
    private int averageVolume;
    
    private double openInterest;
    
    private double turnover;
    
    private int tickCount = 0;

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

    public double getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(double openInterest) {
        this.openInterest = openInterest;
    }

    public int getAverageVolume() {
        return averageVolume;
    }

    public void setAverageVolume(int averageVolume) {
        this.averageVolume = averageVolume;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getBidVoume() {
        return bidVoume;
    }

    public void setBidVoume(int bidVoume) {
        this.bidVoume = bidVoume;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskVolume() {
        return askVolume;
    }

    public void setAskVolume(int askVolume) {
        this.askVolume = askVolume;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }
    
    public void tickIncr(){
        this.tickCount ++;
    }
}
