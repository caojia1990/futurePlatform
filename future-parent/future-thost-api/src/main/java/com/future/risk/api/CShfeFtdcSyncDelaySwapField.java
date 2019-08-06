/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcSyncDelaySwapField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcSyncDelaySwapField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcSyncDelaySwapField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcSyncDelaySwapField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setDelaySwapSeqNo(String value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_DelaySwapSeqNo_set(swigCPtr, this, value);
  }

  public String getDelaySwapSeqNo() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_DelaySwapSeqNo_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_InvestorID_get(swigCPtr, this);
  }

  public void setFromCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromCurrencyID_set(swigCPtr, this, value);
  }

  public String getFromCurrencyID() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromCurrencyID_get(swigCPtr, this);
  }

  public void setFromAmount(double value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromAmount_set(swigCPtr, this, value);
  }

  public double getFromAmount() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromAmount_get(swigCPtr, this);
  }

  public void setFromFrozenSwap(double value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromFrozenSwap_set(swigCPtr, this, value);
  }

  public double getFromFrozenSwap() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromFrozenSwap_get(swigCPtr, this);
  }

  public void setFromRemainSwap(double value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromRemainSwap_set(swigCPtr, this, value);
  }

  public double getFromRemainSwap() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_FromRemainSwap_get(swigCPtr, this);
  }

  public void setToCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_ToCurrencyID_set(swigCPtr, this, value);
  }

  public String getToCurrencyID() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_ToCurrencyID_get(swigCPtr, this);
  }

  public void setToAmount(double value) {
    riskuserapiJNI.CShfeFtdcSyncDelaySwapField_ToAmount_set(swigCPtr, this, value);
  }

  public double getToAmount() {
    return riskuserapiJNI.CShfeFtdcSyncDelaySwapField_ToAmount_get(swigCPtr, this);
  }

  public CShfeFtdcSyncDelaySwapField() {
    this(riskuserapiJNI.new_CShfeFtdcSyncDelaySwapField(), true);
  }

}
