/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcSyncFundMortgageField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcSyncFundMortgageField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcSyncFundMortgageField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcSyncFundMortgageField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setMortgageSeqNo(String value) {
    thosttradeapiJNI.CThostFtdcSyncFundMortgageField_MortgageSeqNo_set(swigCPtr, this, value);
  }

  public String getMortgageSeqNo() {
    return thosttradeapiJNI.CThostFtdcSyncFundMortgageField_MortgageSeqNo_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcSyncFundMortgageField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcSyncFundMortgageField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcSyncFundMortgageField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcSyncFundMortgageField_InvestorID_get(swigCPtr, this);
  }

  public void setFromCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcSyncFundMortgageField_FromCurrencyID_set(swigCPtr, this, value);
  }

  public String getFromCurrencyID() {
    return thosttradeapiJNI.CThostFtdcSyncFundMortgageField_FromCurrencyID_get(swigCPtr, this);
  }

  public void setMortgageAmount(double value) {
    thosttradeapiJNI.CThostFtdcSyncFundMortgageField_MortgageAmount_set(swigCPtr, this, value);
  }

  public double getMortgageAmount() {
    return thosttradeapiJNI.CThostFtdcSyncFundMortgageField_MortgageAmount_get(swigCPtr, this);
  }

  public void setToCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcSyncFundMortgageField_ToCurrencyID_set(swigCPtr, this, value);
  }

  public String getToCurrencyID() {
    return thosttradeapiJNI.CThostFtdcSyncFundMortgageField_ToCurrencyID_get(swigCPtr, this);
  }

  public CThostFtdcSyncFundMortgageField() {
    this(thosttradeapiJNI.new_CThostFtdcSyncFundMortgageField(), true);
  }

}
