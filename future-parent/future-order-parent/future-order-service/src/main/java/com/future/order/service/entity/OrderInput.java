package com.future.order.service.entity;

import java.math.BigDecimal;

public class OrderInput {
    
    private String clientRequestId;
    
    private String orderRef;
    
    private String investorId;
    
    private String accountNo;
    
    private int volumeTotalOriginal;
    
    private int tradeVolume;
    
    private BigDecimal frozenCommission;
    
    private BigDecimal frozenMargin;
    
    private BigDecimal commissionEachHand;
    
    private BigDecimal marginEachHand;
    

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getVolumeTotalOriginal() {
        return volumeTotalOriginal;
    }

    public void setVolumeTotalOriginal(int volumeTotalOriginal) {
        this.volumeTotalOriginal = volumeTotalOriginal;
    }

    public int getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(int tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public BigDecimal getFrozenCommission() {
        return frozenCommission;
    }

    public void setFrozenCommission(BigDecimal frozenCommission) {
        this.frozenCommission = frozenCommission;
    }

    public BigDecimal getFrozenMargin() {
        return frozenMargin;
    }

    public void setFrozenMargin(BigDecimal frozenMargin) {
        this.frozenMargin = frozenMargin;
    }

    public BigDecimal getCommissionEachHand() {
        return commissionEachHand;
    }

    public void setCommissionEachHand(BigDecimal commissionEachHand) {
        this.commissionEachHand = commissionEachHand;
    }

    public BigDecimal getMarginEachHand() {
        return marginEachHand;
    }

    public void setMarginEachHand(BigDecimal marginEachHand) {
        this.marginEachHand = marginEachHand;
    }


}
