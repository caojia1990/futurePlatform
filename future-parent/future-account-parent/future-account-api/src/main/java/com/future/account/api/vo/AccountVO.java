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
     * 账户别名
     */
    private String alias;
    
    /**
     * 投资者账号
     */
    private String investorNo;
    
    /**
     * 上次质押金额
     */
    private BigDecimal preMortgage = BigDecimal.ZERO;
    
    /**
     * 上次信用额度
     */
    private BigDecimal preCredit = BigDecimal.ZERO;
    
    /**
     * 上次存款额
     */
    private BigDecimal preDeposit = BigDecimal.ZERO;
    
    /**
     * 上次结算准备金
     */
    private BigDecimal preBalance = BigDecimal.ZERO;
    
    /**
     * 上次占用的保证金
     */
    private BigDecimal preMargin = BigDecimal.ZERO;
    
    /**
     * 利息基数
     */
    private BigDecimal interestBase = BigDecimal.ZERO;
    
    /**
     * 利息收入
     */
    private BigDecimal interest = BigDecimal.ZERO;
    
    /**
     * 入金金额
     */
    private BigDecimal deposit = BigDecimal.ZERO;
    
    /**
     * 出金金额
     */
    private BigDecimal withdraw = BigDecimal.ZERO;
    
    /**
     * 冻结的保证金
     */
    private BigDecimal frozenMargin = BigDecimal.ZERO;
    
    /**
     * 冻结的资金
     */
    private BigDecimal frozenCash = BigDecimal.ZERO;
    
    /**
     * 冻结的手续费
     */
    private BigDecimal frozenCommission = BigDecimal.ZERO;
    
    /**
     * 当前保证金总额
     */
    private BigDecimal currMargin = BigDecimal.ZERO;
    
    /**
     * 资金差额
     */
    private BigDecimal cashIn = BigDecimal.ZERO;
    
    /**
     * 手续费
     */
    private BigDecimal commission = BigDecimal.ZERO;
    
    /**
     * 平仓盈亏
     */
    private BigDecimal closeProfit = BigDecimal.ZERO;
    
    /**
     * 持仓盈亏
     */
    private BigDecimal positionProfit = BigDecimal.ZERO;
    
    /**
     * 期货结算准备金
     */
    private BigDecimal balance = BigDecimal.ZERO;
    
    /**
     * 可用资金
     */
    private BigDecimal available = BigDecimal.ZERO;
    
    /**
     * 可取资金
     */
    private BigDecimal withdrawQuota = BigDecimal.ZERO;
    
    /**
     * 基本准备金
     */
    private BigDecimal reserve = BigDecimal.ZERO;
    
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
    private BigDecimal credit = BigDecimal.ZERO;
    
    /**
     * 质押金额
     */
    private BigDecimal mortgage = BigDecimal.ZERO;
    
    /**
     * 交易所保证金
     */
    private BigDecimal ExchangeMargin = BigDecimal.ZERO;
    
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

    /**
     * 冻结资金 = 冻结保证金+冻结手续费+冻结权利金
     * @return
     */
    public BigDecimal getFrozenCash() {
        //TODO
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

    /**
     * 静态权益 = 上次结算准备金+入金金额-出金金额
     * @return
     */
    public BigDecimal getBalance() {
        return this.preBalance.add(this.deposit).subtract(this.withdraw);
    }
    
    /**
     * 动态权益 = 静态权益+平仓盈亏+持仓盈亏-手续费
     * @return
     */
    public BigDecimal getDynamicRights() {
        return this.getBalance().add(this.closeProfit).add(this.positionProfit).subtract(this.commission);
    }


    /**
     * 可用资金 = 动态权益 - 占用保证金 - 冻结保证金 - 冻结手续费
     * @return
     */
    public BigDecimal getAvailable() {
        return this.getDynamicRights().subtract(this.currMargin).subtract(this.frozenMargin).subtract(this.frozenCommission);
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
