package com.future.account.api.vo;

import java.io.Serializable;

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
    private double preMortgage;
    
    /**
     * 上次信用额度
     */
    private double preCredit;
    
    /**
     * 上次存款额
     */
    private double preDeposit;
    
    /**
     * 上次结算准备金
     */
    private double preBalance;
    
    /**
     * 上次占用的保证金
     */
    private double preMargin;
    
    /**
     * 利息基数
     */
    private double interestBase;
    
    /**
     * 利息收入
     */
    private double interest;
    
    /**
     * 入金金额
     */
    private double deposit;
    
    /**
     * 出金金额
     */
    private double withdraw;
    
    /**
     * 冻结的保证金
     */
    private double frozenMargin;
    
    /**
     * 冻结的资金
     */
    private double frozenCash;
    
    /**
     * 冻结的手续费
     */
    private double frozenCommission;
    
    /**
     * 当前保证金总额
     */
    private double currMargin;
    
    /**
     * 资金差额
     */
    private double cashIn;
    
    /**
     * 手续费
     */
    private double commission;
    
    /**
     * 平仓盈亏
     */
    private double closeProfit;
    
    /**
     * 持仓盈亏
     */
    private double positionProfit;
    
    /**
     * 期货结算准备金
     */
    private double balance;
    
    /**
     * 可用资金
     */
    private double available;
    
    /**
     * 可取资金
     */
    private double withdrawQuota;
    
    /**
     * 基本准备金
     */
    private double reserve;
    
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
    private double credit;
    
    /**
     * 质押金额
     */
    private double mortgage;
    
    /**
     * 交易所保证金
     */
    private double ExchangeMargin;
    
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

    public double getPreMortgage() {
        return preMortgage;
    }

    public void setPreMortgage(double preMortgage) {
        this.preMortgage = preMortgage;
    }

    public double getPreCredit() {
        return preCredit;
    }

    public void setPreCredit(double preCredit) {
        this.preCredit = preCredit;
    }

    public double getPreDeposit() {
        return preDeposit;
    }

    public void setPreDeposit(double preDeposit) {
        this.preDeposit = preDeposit;
    }

    public double getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(double preBalance) {
        this.preBalance = preBalance;
    }

    public double getPreMargin() {
        return preMargin;
    }

    public void setPreMargin(double preMargin) {
        this.preMargin = preMargin;
    }

    public double getInterestBase() {
        return interestBase;
    }

    public void setInterestBase(double interestBase) {
        this.interestBase = interestBase;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    public double getFrozenMargin() {
        return frozenMargin;
    }

    public void setFrozenMargin(double frozenMargin) {
        this.frozenMargin = frozenMargin;
    }

    public double getFrozenCash() {
        return frozenCash;
    }

    public void setFrozenCash(double frozenCash) {
        this.frozenCash = frozenCash;
    }

    public double getFrozenCommission() {
        return frozenCommission;
    }

    public void setFrozenCommission(double frozenCommission) {
        this.frozenCommission = frozenCommission;
    }

    public double getCurrMargin() {
        return currMargin;
    }

    public void setCurrMargin(double currMargin) {
        this.currMargin = currMargin;
    }

    public double getCashIn() {
        return cashIn;
    }

    public void setCashIn(double cashIn) {
        this.cashIn = cashIn;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getCloseProfit() {
        return closeProfit;
    }

    public void setCloseProfit(double closeProfit) {
        this.closeProfit = closeProfit;
    }

    public double getPositionProfit() {
        return positionProfit;
    }

    public void setPositionProfit(double positionProfit) {
        this.positionProfit = positionProfit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getWithdrawQuota() {
        return withdrawQuota;
    }

    public void setWithdrawQuota(double withdrawQuota) {
        this.withdrawQuota = withdrawQuota;
    }

    public double getReserve() {
        return reserve;
    }

    public void setReserve(double reserve) {
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

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getMortgage() {
        return mortgage;
    }

    public void setMortgage(double mortgage) {
        this.mortgage = mortgage;
    }

    public double getExchangeMargin() {
        return ExchangeMargin;
    }

    public void setExchangeMargin(double exchangeMargin) {
        ExchangeMargin = exchangeMargin;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    
}
