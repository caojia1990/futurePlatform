/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcQryHisOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcQryHisOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcQryHisOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcQryHisOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_InstrumentID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setOrderSysID(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_OrderSysID_set(swigCPtr, this, value);
  }

  public String getOrderSysID() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_OrderSysID_get(swigCPtr, this);
  }

  public void setInsertTimeStart(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_InsertTimeStart_set(swigCPtr, this, value);
  }

  public String getInsertTimeStart() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_InsertTimeStart_get(swigCPtr, this);
  }

  public void setInsertTimeEnd(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_InsertTimeEnd_set(swigCPtr, this, value);
  }

  public String getInsertTimeEnd() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_InsertTimeEnd_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    riskuserapiJNI.CShfeFtdcQryHisOrderField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return riskuserapiJNI.CShfeFtdcQryHisOrderField_SettlementID_get(swigCPtr, this);
  }

  public CShfeFtdcQryHisOrderField() {
    this(riskuserapiJNI.new_CShfeFtdcQryHisOrderField(), true);
  }

}
