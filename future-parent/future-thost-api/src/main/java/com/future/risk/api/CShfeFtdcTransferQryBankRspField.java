/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcTransferQryBankRspField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcTransferQryBankRspField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcTransferQryBankRspField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcTransferQryBankRspField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setRetCode(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_RetCode_set(swigCPtr, this, value);
  }

  public String getRetCode() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_RetCode_get(swigCPtr, this);
  }

  public void setRetInfo(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_RetInfo_set(swigCPtr, this, value);
  }

  public String getRetInfo() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_RetInfo_get(swigCPtr, this);
  }

  public void setFutureAccount(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_FutureAccount_set(swigCPtr, this, value);
  }

  public String getFutureAccount() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_FutureAccount_get(swigCPtr, this);
  }

  public void setTradeAmt(double value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_TradeAmt_set(swigCPtr, this, value);
  }

  public double getTradeAmt() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_TradeAmt_get(swigCPtr, this);
  }

  public void setUseAmt(double value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_UseAmt_set(swigCPtr, this, value);
  }

  public double getUseAmt() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_UseAmt_get(swigCPtr, this);
  }

  public void setFetchAmt(double value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_FetchAmt_set(swigCPtr, this, value);
  }

  public double getFetchAmt() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_FetchAmt_get(swigCPtr, this);
  }

  public void setCurrencyCode(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankRspField_CurrencyCode_set(swigCPtr, this, value);
  }

  public String getCurrencyCode() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankRspField_CurrencyCode_get(swigCPtr, this);
  }

  public CShfeFtdcTransferQryBankRspField() {
    this(riskuserapiJNI.new_CShfeFtdcTransferQryBankRspField(), true);
  }

}
