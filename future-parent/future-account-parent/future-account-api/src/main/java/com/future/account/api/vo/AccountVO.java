package com.future.account.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 投资者账户信息
 * @author caojia
 *
 */
public class AccountVO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -2579950607441834831L;

    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 投资者账号
     */
    private String investorNo;
    
    /**
     * 上次质押金额
     */
    private BigDecimal preMortgage;
    
    /**
     * 上次信用额度
     */
    private BigDecimal preCredit;
    
    /**
     * 上次存款额
     */
    private BigDecimal preDeposit;
    
    /**
     * 上次结算准备金
     */
    private BigDecimal preBalance;
    
    /**
     * 上次占用的保证金
     */
    private BigDecimal preMargin;
    
    /**
     * 利息基数
     */
    private BigDecimal interestBase;
    
    /**
     * 利息收入
     */
    private BigDecimal interest;
    
    /**
     * 入金金额
     */
    private BigDecimal deposit;
    
    /**
     * 出金金额
     */
    private BigDecimal withdraw;
    
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
     * 当前保证金总额
     */
    private BigDecimal currMargin;
    
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
     * 期货结算准备金
     */
    private BigDecimal balance;
    
    /**
     * 可用资金
     */
    private BigDecimal available;
    
    /**
     * 可取资金
     */
    private BigDecimal withdrawQuota;
    
    /**
     * 基本准备金
     */
    private BigDecimal reserve;
    
    /**
     * 交易日
     */
    private String tradingDay;
    
    /**
     * 结算编号
     */
    private String settlementID;
    
    /**
     * 信用额度
     */
    private BigDecimal credit;
    
    /**
     * 质押金额
     */
    private BigDecimal mortgage;
    
    /**
     * 交易所保证金
     */
    private BigDecimal ExchangeMargin;
    
    /**
     * 是否为默认账户 0：否 1：是
     */
    private String isDefault;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getInvestorNo() {
        return investorNo;
    }

    public void setInvestorNo(String investorNo) {
        this.investorNo = investorNo;
    }

    public BigDecimal getPreMortgage() {
        return preMortgage;
    }

    public void setPreMortgage(BigDecimal preMortgage) {
        this.preMortgage = preMortgage;
    }

    public BigDecimal getPreCredit() {
        return preCredit;
    }

    public void setPreCredit(BigDecimal preCredit) {
        this.preCredit = preCredit;
    }

    public BigDecimal getPreDeposit() {
        return preDeposit;
    }

    public void setPreDeposit(BigDecimal preDeposit) {
        this.preDeposit = preDeposit;
    }

    public BigDecimal getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(BigDecimal preBalance) {
        this.preBalance = preBalance;
    }

    public BigDecimal getPreMargin() {
        return preMargin;
    }

    public void setPreMargin(BigDecimal preMargin) {
        this.preMargin = preMargin;
    }

    public BigDecimal getInterestBase() {
        return interestBase;
    }

    public void setInterestBase(BigDecimal interestBase) {
        this.interestBase = interestBase;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
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

    public BigDecimal getCurrMargin() {
        return currMargin;
    }

    public void setCurrMargin(BigDecimal currMargin) {
        this.currMargin = currMargin;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public BigDecimal getWithdrawQuota() {
        return withdrawQuota;
    }

    public void setWithdrawQuota(BigDecimal withdrawQuota) {
        this.withdrawQuota = withdrawQuota;
    }

    public BigDecimal getReserve() {
        return reserve;
    }

    public void setReserve(BigDecimal reserve) {
        this.reserve = reserve;
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

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getMortgage() {
        return mortgage;
    }

    public void setMortgage(BigDecimal mortgage) {
        this.mortgage = mortgage;
    }

    public BigDecimal getExchangeMargin() {
        return ExchangeMargin;
    }

    public void setExchangeMargin(BigDecimal exchangeMargin) {
        ExchangeMargin = exchangeMargin;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    
}
