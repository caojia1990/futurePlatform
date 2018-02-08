package com.future.market.api.vo;

/**
 * 深度行情实体类
 * @author caojia
 */
/**
 * @author BHQH-CXYWB
 *
 */
public class DepthMarketData {
    
    /**
     * 合约代码
     */
    private String instrumentID;
    
    /**
     * 交易所代码
     */
    private String exchangeID;
    
    /**
     * 合约在交易所的代码
     */
    private String exchangeInstId;
    
    /**
     * 开盘价
     */
    private Double openPrice;
    
    /**
     * 最新价
     */
    private Double lastPrice;

    /**
     * 总成交量
     */
    private Integer volume;
    
    /**
     * 成交金额
     */
    private Double turnover;
    
    /**
     * 本次成交量
     */
    private Integer volumeChange;
    
    /**
     * 持仓量
     */
    private Double openInterest;
    
    /**
     * 本次增仓量
     */
    private Double openInterestChange;
    
    /**
     * 买一价
     */
    private Double bidPrice1;
    
    /**
     * 买一量
     */
    private Integer bidVolume1;
    
    /**
     * 卖一价
     */
    private Double askPrice1;
    
    /**
     * 卖一量
     */
    private Integer askVolume1;
    
    /**
     * 最高价
     */
    private Double highestPrice;
    
    /**
     * 最低价
     */
    private Double lowestPrice;
    
    /**
     * 涨停价
     */
    private Double upperLimitPrice;
    
    /**
     * 跌停价
     */
    private Double lowerLimitPrice;
    
    /**
     * 昨收盘
     */
    private Double preClosePrice;
    
    /**
     * 昨结算
     */
    private Double preSettlementPrice;
    
    /**
     * 昨持仓
     */
    private Double preOpenInterest;
    
    /**
     * 收盘价
     */
    private Double closePrice;
    
    /**
     * 结算价
     */
    private Double settlementPrice;
    
    /**
     * 均价
     */
    private Double averagePrice;
    
    /**
     * 今虚实度
     */
    private Double currDelta;
    
    /**
     * 昨虚实度
     */
    private Double preDelta;
    
    /**
     * 交易日
     */
    private String tradingDate;
    
    /**
     * 更新时间（秒级）
     */
    private String updateTime;
    
    /**
     * 毫秒
     */
    private int updateMillisec;

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getVolumeChange() {
        return volumeChange;
    }

    public void setVolumeChange(Integer volumeChange) {
        this.volumeChange = volumeChange;
    }

    public Double getOpenInterest() {
        return openInterest;
    }

    public void setOpenInterest(Double openInterest) {
        this.openInterest = openInterest;
    }

    public Double getOpenInterestChange() {
        return openInterestChange;
    }

    public void setOpenInterestChange(Double openInterestChange) {
        this.openInterestChange = openInterestChange;
    }

    public Double getBidPrice1() {
        return bidPrice1;
    }

    public void setBidPrice1(Double bidPrice1) {
        this.bidPrice1 = bidPrice1;
    }

    public Integer getBidVolume1() {
        return bidVolume1;
    }

    public void setBidVolume1(Integer bidVolume1) {
        this.bidVolume1 = bidVolume1;
    }

    public Double getAskPrice1() {
        return askPrice1;
    }

    public void setAskPrice1(Double askPrice1) {
        this.askPrice1 = askPrice1;
    }

    public Integer getAskVolume1() {
        return askVolume1;
    }

    public void setAskVolume1(Integer askVolume1) {
        this.askVolume1 = askVolume1;
    }

    public Double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Double getUpperLimitPrice() {
        return upperLimitPrice;
    }

    public void setUpperLimitPrice(Double upperLimitPrice) {
        this.upperLimitPrice = upperLimitPrice;
    }

    public Double getLowerLimitPrice() {
        return lowerLimitPrice;
    }

    public void setLowerLimitPrice(Double lowerLimitPrice) {
        this.lowerLimitPrice = lowerLimitPrice;
    }

    public Double getPreClosePrice() {
        return preClosePrice;
    }

    public void setPreClosePrice(Double preClosePrice) {
        this.preClosePrice = preClosePrice;
    }

    public Double getPreSettlementPrice() {
        return preSettlementPrice;
    }

    public void setPreSettlementPrice(Double preSettlementPrice) {
        this.preSettlementPrice = preSettlementPrice;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Double getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(Double settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateMillisec() {
        return updateMillisec;
    }

    public void setUpdateMillisec(int updateMillisec) {
        this.updateMillisec = updateMillisec;
    }
    

    public String getExchangeID() {
        return exchangeID;
    }

    public void setExchangeID(String exchangeID) {
        this.exchangeID = exchangeID;
    }

    public String getExchangeInstId() {
        return exchangeInstId;
    }

    public void setExchangeInstId(String exchangeInstId) {
        this.exchangeInstId = exchangeInstId;
    }

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getCurrDelta() {
        return currDelta;
    }

    public void setCurrDelta(Double currDelta) {
        this.currDelta = currDelta;
    }

    public Double getPreDelta() {
        return preDelta;
    }

    public void setPreDelta(Double preDelta) {
        this.preDelta = preDelta;
    }
    
    

    public Double getPreOpenInterest() {
        return preOpenInterest;
    }

    public void setPreOpenInterest(Double preOpenInterest) {
        this.preOpenInterest = preOpenInterest;
    }

    @Override
    public String toString() {
        return "DepthMarketData [instrumentID=" + instrumentID + ", exchangeID=" + exchangeID + ", exchangeInstId="
                + exchangeInstId + ", openPrice=" + openPrice + ", lastPrice=" + lastPrice + ", volume=" + volume
                + ", turnover=" + turnover + ", volumeChange=" + volumeChange + ", openInterest=" + openInterest
                + ", openInterestChange=" + openInterestChange + ", bidPrice1=" + bidPrice1 + ", bidVolume1="
                + bidVolume1 + ", askPrice1=" + askPrice1 + ", askVolume1=" + askVolume1 + ", highestPrice="
                + highestPrice + ", lowestPrice=" + lowestPrice + ", upperLimitPrice=" + upperLimitPrice
                + ", lowerLimitPrice=" + lowerLimitPrice + ", preClosePrice=" + preClosePrice + ", preSettlementPrice="
                + preSettlementPrice + ", preOpenInterest=" + preOpenInterest + ", closePrice=" + closePrice
                + ", settlementPrice=" + settlementPrice + ", averagePrice=" + averagePrice + ", currDelta=" + currDelta
                + ", preDelta=" + preDelta + ", tradingDate=" + tradingDate + ", updateTime=" + updateTime
                + ", updateMillisec=" + updateMillisec + "]";
    }

    
    
}
