package com.future.order.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 投资者持仓
 * @author caojia
 *
 */
public class InvestorPositionVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 807079164594930957L;
    
    /**
     * 合约代码
     */
    private String instrumentID;
    
    /**
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 持仓多空方向
     */
    private Direction posiDirection;
    
    /**
     * 投机套保标志
     */
    private HedgeFlag hedgeFlag;
    
    /**
     * 持仓日期
     */
    private String positionDate;
    
    /**
     * 上日持仓
     */
    private int ydPosition;
    
    /**
     * 今日持仓
     */
    private int position;
    
    /**
     * 多头冻结
     */
    private int longFrozen;
    
    /**
     * 空头冻结
     */
    private int shortFrozen;
    
    /**
     * 开仓冻结金额
     */
    private BigDecimal longFrozenAmount;
    
    /**
     * 开仓冻结金额
     */
    private BigDecimal shortFrozenAmount;
    
    /**
     * 开仓量
     */
    private int openVolume;
    
    /**
     * 平仓量
     */
    private int closeVolume;
    
    /**
     * 开仓金额
     */
    private BigDecimal openAmount;
    
    /**
     * 平仓金额
     */
    private BigDecimal closeAmount;
    
    /**
     * 持仓成本
     */
    private BigDecimal positionCost;
    
    /**
     * 上次占用的保证金
     */
    private BigDecimal preMargin;
    
    /**
     * 占用的保证金
     */
    private BigDecimal useMargin;
    
    /**
     * 冻结的保证金
     */
    private BigDecimal frozenMargin;
    
    /**
     * 冻结的资金
     */
    private BigDecimal frozenCash;
    
    /**
     * 冻结的手续费
     */
    private BigDecimal frozenCommission;
    
    /**
     * 资金差额
     */
    private BigDecimal cashIn;
    
    /**
     * 手续费
     */
    private BigDecimal commission;
    
    /**
     * 平仓盈亏
     */
    private BigDecimal closeProfit;
    
    /**
     * 持仓盈亏
     */
    private BigDecimal positionProfit;
    
    /**
     * 上次结算价
     */
    private BigDecimal preSettlementPrice;
    
    /**
     * 本次结算价
     */
    private BigDecimal settlementPrice;
    
    /**
     * 交易日
     */
    private String tradingDay;
    
    /**
     * 结算编号
     */
    private String settlementID;

    public String getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(String instrumentID) {
        this.instrumentID = instrumentID;
    }

    public String getInvestorID() {
        return investorID;
    }

    public void setInvestorID(String investorID) {
        this.investorID = investorID;
    }

    public Direction getPosiDirection() {
        return posiDirection;
    }

    public void setPosiDirection(Direction posiDirection) {
        this.posiDirection = posiDirection;
    }

    public HedgeFlag getHedgeFlag() {
        return hedgeFlag;
    }

    public void setHedgeFlag(HedgeFlag hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    public String getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(String positionDate) {
        this.positionDate = positionDate;
    }

    public int getYdPosition() {
        return ydPosition;
    }

    public void setYdPosition(int ydPosition) {
        this.ydPosition = ydPosition;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLongFrozen() {
        return longFrozen;
    }

    public void setLongFrozen(int longFrozen) {
        this.longFrozen = longFrozen;
    }

    public int getShortFrozen() {
        return shortFrozen;
    }

    public void setShortFrozen(int shortFrozen) {
        this.shortFrozen = shortFrozen;
    }

    public BigDecimal getLongFrozenAmount() {
        return longFrozenAmount;
    }

    public void setLongFrozenAmount(BigDecimal longFrozenAmount) {
        this.longFrozenAmount = longFrozenAmount;
    }

    public BigDecimal getShortFrozenAmount() {
        return shortFrozenAmount;
    }

    public void setShortFrozenAmount(BigDecimal shortFrozenAmount) {
        this.shortFrozenAmount = shortFrozenAmount;
    }

    public int getOpenVolume() {
        return openVolume;
    }

    public void setOpenVolume(int openVolume) {
        this.openVolume = openVolume;
    }

    public int getCloseVolume() {
        return closeVolume;
    }

    public void setCloseVolume(int closeVolume) {
        this.closeVolume = closeVolume;
    }

    public BigDecimal getOpenAmount() {
        return openAmount;
    }

    public void setOpenAmount(BigDecimal openAmount) {
        this.openAmount = openAmount;
    }

    public BigDecimal getCloseAmount() {
        return closeAmount;
    }

    public void setCloseAmount(BigDecimal closeAmount) {
        this.closeAmount = closeAmount;
    }

    public BigDecimal getPositionCost() {
        return positionCost;
    }

    public void setPositionCost(BigDecimal positionCost) {
        this.positionCost = positionCost;
    }

    public BigDecimal getPreMargin() {
        return preMargin;
    }

    public void setPreMargin(BigDecimal preMargin) {
        this.preMargin = preMargin;
    }

    public BigDecimal getUseMargin() {
        return useMargin;
    }

    public void setUseMargin(BigDecimal useMargin) {
        this.useMargin = useMargin;
    }

    public BigDecimal getFrozenMargin() {
        return frozenMargin;
    }

    public void setFrozenMargin(BigDecimal frozenMargin) {
        this.frozenMargin = frozenMargin;
    }

    public BigDecimal getFrozenCash() {
        return frozenCash;
    }

    public void setFrozenCash(BigDecimal frozenCash) {
        this.frozenCash = frozenCash;
    }

    public BigDecimal getFrozenCommission() {
        return frozenCommission;
    }

    public void setFrozenCommission(BigDecimal frozenCommission) {
        this.frozenCommission = frozenCommission;
    }

    public BigDecimal getCashIn() {
        return cashIn;
    }

    public void setCashIn(BigDecimal cashIn) {
        this.cashIn = cashIn;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getCloseProfit() {
        return closeProfit;
    }

    public void setCloseProfit(BigDecimal closeProfit) {
        this.closeProfit = closeProfit;
    }

    public BigDecimal getPositionProfit() {
        return positionProfit;
    }

    public void setPositionProfit(BigDecimal positionProfit) {
        this.positionProfit = positionProfit;
    }

    public BigDecimal getPreSettlementPrice() {
        return preSettlementPrice;
    }

    public void setPreSettlementPrice(BigDecimal preSettlementPrice) {
        this.preSettlementPrice = preSettlementPrice;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public String getTradingDay() {
        return tradingDay;
    }

    public void setTradingDay(String tradingDay) {
        this.tradingDay = tradingDay;
    }

    public String getSettlementID() {
        return settlementID;
    }

    public void setSettlementID(String settlementID) {
        this.settlementID = settlementID;
    }
    
    

}
