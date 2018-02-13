package com.future.instrument.api.vo;


/**
 * 合约信息
 * @author caojia
 */
public class InstrumentVO implements java.io.Serializable{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -2799546851155216638L;
    ///合约代码
    private String instrumentID;
    ///交易所代码
    private String exchangeID;
    ///合约名称
    private String instrumentName;
    ///合约在交易所的代码
    private String exchangeInstID;
    ///产品代码
    private String productID;
    ///产品类型
    private String productClass;
    ///交割年份
    private String deliveryYear;
    ///交割月
    private String deliveryMonth;
    ///市价单最大下单量
    private int maxMarketOrderVolume;
    ///市价单最小下单量
    private int minMarketOrderVolume;
    ///限价单最大下单量
    private int maxLimitOrderVolume;
    ///限价单最小下单量
    private int minLimitOrderVolume;
    ///合约数量乘数
    private int volumeMultiple;
    ///最小变动价位
    private double priceTick;
    ///创建日
    private String createDate;
    ///上市日
    private String openDate;
    ///到期日
    private String expireDate;
    ///开始交割日
    private String startDelivDate;
    ///结束交割日
    private String endDelivDate;
    ///合约生命周期状态
    private char instLifePhase;
    ///当前是否交易
    private int isTrading;
    ///持仓类型
    private char positionType;
    ///持仓日期类型
    private char positionDateType;
    ///多头保证金率
    private double longMarginRatio;
    ///空头保证金率
    private double shortMarginRatio;
    
    /**
     * 交易日
     */
    private String tradingDate;
    
    public String getInstrumentID() {
        return instrumentID;
    }
    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }
    public String getExchangeID() {
        return exchangeID;
    }
    public void setExchangeID(String exchangeID) {
        this.exchangeID = exchangeID;
    }
    public String getInstrumentName() {
        return instrumentName;
    }
    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }
    public String getExchangeInstID() {
        return exchangeInstID;
    }
    public void setExchangeInstID(String exchangeInstID) {
        this.exchangeInstID = exchangeInstID;
    }
    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getProductClass() {
        return productClass;
    }
    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }
    public String getDeliveryYear() {
        return deliveryYear;
    }
    public void setDeliveryYear(String deliveryYear) {
        this.deliveryYear = deliveryYear;
    }
    public String getDeliveryMonth() {
        return deliveryMonth;
    }
    public void setDeliveryMonth(String deliveryMonth) {
        this.deliveryMonth = deliveryMonth;
    }
    public int getMaxMarketOrderVolume() {
        return maxMarketOrderVolume;
    }
    public void setMaxMarketOrderVolume(int maxMarketOrderVolume) {
        this.maxMarketOrderVolume = maxMarketOrderVolume;
    }
    public int getMinMarketOrderVolume() {
        return minMarketOrderVolume;
    }
    public void setMinMarketOrderVolume(int minMarketOrderVolume) {
        this.minMarketOrderVolume = minMarketOrderVolume;
    }
    public int getMaxLimitOrderVolume() {
        return maxLimitOrderVolume;
    }
    public void setMaxLimitOrderVolume(int maxLimitOrderVolume) {
        this.maxLimitOrderVolume = maxLimitOrderVolume;
    }
    public int getMinLimitOrderVolume() {
        return minLimitOrderVolume;
    }
    public void setMinLimitOrderVolume(int minLimitOrderVolume) {
        this.minLimitOrderVolume = minLimitOrderVolume;
    }
    public int getVolumeMultiple() {
        return volumeMultiple;
    }
    public void setVolumeMultiple(int volumeMultiple) {
        this.volumeMultiple = volumeMultiple;
    }
    public double getPriceTick() {
        return priceTick;
    }
    public void setPriceTick(double priceTick) {
        this.priceTick = priceTick;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getOpenDate() {
        return openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public String getExpireDate() {
        return expireDate;
    }
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    public String getStartDelivDate() {
        return startDelivDate;
    }
    public void setStartDelivDate(String startDelivDate) {
        this.startDelivDate = startDelivDate;
    }
    public String getEndDelivDate() {
        return endDelivDate;
    }
    public void setEndDelivDate(String endDelivDate) {
        this.endDelivDate = endDelivDate;
    }
    public char getInstLifePhase() {
        return instLifePhase;
    }
    public void setInstLifePhase(char instLifePhase) {
        this.instLifePhase = instLifePhase;
    }
    public int getIsTrading() {
        return isTrading;
    }
    public void setIsTrading(int isTrading) {
        this.isTrading = isTrading;
    }
    public char getPositionType() {
        return positionType;
    }
    public void setPositionType(char positionType) {
        this.positionType = positionType;
    }
    public char getPositionDateType() {
        return positionDateType;
    }
    public void setPositionDateType(char positionDateType) {
        this.positionDateType = positionDateType;
    }
    public double getLongMarginRatio() {
        return longMarginRatio;
    }
    public void setLongMarginRatio(double longMarginRatio) {
        this.longMarginRatio = longMarginRatio;
    }
    public double getShortMarginRatio() {
        return shortMarginRatio;
    }
    public void setShortMarginRatio(double shortMarginRatio) {
        this.shortMarginRatio = shortMarginRatio;
    }
    public String getTradingDate() {
        return tradingDate;
    }
    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }
    

}
