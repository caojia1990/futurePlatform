/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcTransferQryBankReqField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcTransferQryBankReqField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcTransferQryBankReqField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcTransferQryBankReqField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFutureAccount(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankReqField_FutureAccount_set(swigCPtr, this, value);
  }

  public String getFutureAccount() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankReqField_FutureAccount_get(swigCPtr, this);
  }

  public void setFuturePwdFlag(char value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankReqField_FuturePwdFlag_set(swigCPtr, this, value);
  }

  public char getFuturePwdFlag() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankReqField_FuturePwdFlag_get(swigCPtr, this);
  }

  public void setFutureAccPwd(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankReqField_FutureAccPwd_set(swigCPtr, this, value);
  }

  public String getFutureAccPwd() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankReqField_FutureAccPwd_get(swigCPtr, this);
  }

  public void setCurrencyCode(String value) {
    riskuserapiJNI.CShfeFtdcTransferQryBankReqField_CurrencyCode_set(swigCPtr, this, value);
  }

  public String getCurrencyCode() {
    return riskuserapiJNI.CShfeFtdcTransferQryBankReqField_CurrencyCode_get(swigCPtr, this);
  }

  public CShfeFtdcTransferQryBankReqField() {
    this(riskuserapiJNI.new_CShfeFtdcTransferQryBankReqField(), true);
  }

}
