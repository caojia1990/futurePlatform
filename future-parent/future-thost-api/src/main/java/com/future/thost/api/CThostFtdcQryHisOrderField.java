/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcQryHisOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcQryHisOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcQryHisOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcQryHisOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_InstrumentID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setOrderSysID(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_OrderSysID_set(swigCPtr, this, value);
  }

  public String getOrderSysID() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_OrderSysID_get(swigCPtr, this);
  }

  public void setInsertTimeStart(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_InsertTimeStart_set(swigCPtr, this, value);
  }

  public String getInsertTimeStart() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_InsertTimeStart_get(swigCPtr, this);
  }

  public void setInsertTimeEnd(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_InsertTimeEnd_set(swigCPtr, this, value);
  }

  public String getInsertTimeEnd() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_InsertTimeEnd_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    thosttradeapiJNI.CThostFtdcQryHisOrderField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return thosttradeapiJNI.CThostFtdcQryHisOrderField_SettlementID_get(swigCPtr, this);
  }

  public CThostFtdcQryHisOrderField() {
    this(thosttradeapiJNI.new_CThostFtdcQryHisOrderField(), true);
  }

}
