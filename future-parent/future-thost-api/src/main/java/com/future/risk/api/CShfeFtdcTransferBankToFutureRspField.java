/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcTransferBankToFutureRspField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcTransferBankToFutureRspField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcTransferBankToFutureRspField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcTransferBankToFutureRspField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRetCode(String value) {
    riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_RetCode_set(swigCPtr, this, value);
  }

  public String getRetCode() {
    return riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_RetCode_get(swigCPtr, this);
  }

  public void setRetInfo(String value) {
    riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_RetInfo_set(swigCPtr, this, value);
  }

  public String getRetInfo() {
    return riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_RetInfo_get(swigCPtr, this);
  }

  public void setFutureAccount(String value) {
    riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_FutureAccount_set(swigCPtr, this, value);
  }

  public String getFutureAccount() {
    return riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_FutureAccount_get(swigCPtr, this);
  }

  public void setTradeAmt(double value) {
    riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_TradeAmt_set(swigCPtr, this, value);
  }

  public double getTradeAmt() {
    return riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_TradeAmt_get(swigCPtr, this);
  }

  public void setCustFee(double value) {
    riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_CustFee_set(swigCPtr, this, value);
  }

  public double getCustFee() {
    return riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_CustFee_get(swigCPtr, this);
  }

  public void setCurrencyCode(String value) {
    riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_CurrencyCode_set(swigCPtr, this, value);
  }

  public String getCurrencyCode() {
    return riskuserapiJNI.CShfeFtdcTransferBankToFutureRspField_CurrencyCode_get(swigCPtr, this);
  }

  public CShfeFtdcTransferBankToFutureRspField() {
    this(riskuserapiJNI.new_CShfeFtdcTransferBankToFutureRspField(), true);
  }

}
