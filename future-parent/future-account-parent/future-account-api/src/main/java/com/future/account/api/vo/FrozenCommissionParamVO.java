package com.future.account.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 冻结手续费入参
 * @author caojia
 */
public class FrozenCommissionParamVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6306833283529932152L;
    
    /**
     * 投资者账号
     */
    private String investorNo;

    /**
     * 账户编号
     */
    private String accountNo;
    
    /**
     * 冻结金额
     */
    private BigDecimal frozenAmonut;

    public String getInvestorNo() {
        return investorNo;
    }

    public void setInvestorNo(String investorNo) {
        this.investorNo = investorNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getFrozenAmonut() {
        return frozenAmonut;
    }

    public void setFrozenAmonut(BigDecimal frozenAmonut) {
        this.frozenAmonut = frozenAmonut;
    }
}
