/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcQryExchangeMarginRateAdjustField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcQryExchangeMarginRateAdjustField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcQryExchangeMarginRateAdjustField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcQryExchangeMarginRateAdjustField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcQryExchangeMarginRateAdjustField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcQryExchangeMarginRateAdjustField_BrokerID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcQryExchangeMarginRateAdjustField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcQryExchangeMarginRateAdjustField_InstrumentID_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    thosttradeapiJNI.CThostFtdcQryExchangeMarginRateAdjustField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return thosttradeapiJNI.CThostFtdcQryExchangeMarginRateAdjustField_HedgeFlag_get(swigCPtr, this);
  }

  public CThostFtdcQryExchangeMarginRateAdjustField() {
    this(thosttradeapiJNI.new_CThostFtdcQryExchangeMarginRateAdjustField(), true);
  }

}
