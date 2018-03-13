package com.future.account.api.service;

import java.math.BigDecimal;

import com.future.account.api.exception.AccountException;

/**
 * 账户接口
 * @author caojia
 *
 */
public interface AccountService {
    
    /**
     * 创建账户
     * @param investorNo
     */
    public String createAccount(String investorNo);
    
    /**
     * 冻结手续费
     * @param paramVO
     */
    public void frozenCommission(String investorNo, String accountNo, BigDecimal amount);
    
    /**
     * 解冻手续费
     * @param investorNo
     * @param accountNo
     * @param amount
     */
    public void thawCommission(String investorNo, String accountNo, BigDecimal amount);
    
    /**
     * 冻结资金
     * @param investorNo 投资者编号
     * @param accountNo 账户编号
     * @param commision 应冻结手续费
     * @param margin 应冻结保证金
     * @throws AccountException if there’s no more momey left or other reason 
     */
    public void frozenCapital(String investorNo, String accountNo, BigDecimal commision,
    				BigDecimal margin) throws AccountException;
    
    /**
     * 扣除手续费
     * @param investorNo 投资者编号
     * @param accountNo 账户编号
     * @param amount 扣除金额
     */
    public void deductCommission(String investorNo, String accountNo, BigDecimal amount);
    
    /**
     * 冻结保证金
     * @param paramVO
     */
    public void frozenMargin(String investorNo, String accountNo, BigDecimal amount);
    
    /**
     * 解冻保证金
     * @param investorNo
     * @param accountNo
     * @param amount
     */
    public void thawMargin(String investorNo, String accountNo, BigDecimal amount);
    
    /**
     * 占用保证金
     * @param investorNo
     * @param accountNo
     * @param amount
     */
    public void occupyMargin(String investorNo, String accountNo, BigDecimal amount);
    
    /**
     * 释放保证金
     * @param investorNo
     * @param accountNo
     * @param amount
     */
    public void releaseMargin(String investorNo, String accountNo, BigDecimal amount);

}
