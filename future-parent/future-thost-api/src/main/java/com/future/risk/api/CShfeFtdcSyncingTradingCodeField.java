/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcSyncingTradingCodeField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcSyncingTradingCodeField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcSyncingTradingCodeField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcSyncingTradingCodeField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_InvestorID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_BrokerID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_ExchangeID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_ClientID_get(swigCPtr, this);
  }

  public void setIsActive(int value) {
    riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_IsActive_set(swigCPtr, this, value);
  }

  public int getIsActive() {
    return riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_IsActive_get(swigCPtr, this);
  }

  public void setClientIDType(char value) {
    riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_ClientIDType_set(swigCPtr, this, value);
  }

  public char getClientIDType() {
    return riskuserapiJNI.CShfeFtdcSyncingTradingCodeField_ClientIDType_get(swigCPtr, this);
  }

  public CShfeFtdcSyncingTradingCodeField() {
    this(riskuserapiJNI.new_CShfeFtdcSyncingTradingCodeField(), true);
  }

}
