/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcIndexPriceField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcIndexPriceField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcIndexPriceField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcIndexPriceField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcIndexPriceField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcIndexPriceField_BrokerID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcIndexPriceField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcIndexPriceField_InstrumentID_get(swigCPtr, this);
  }

  public void setClosePrice(double value) {
    thosttradeapiJNI.CThostFtdcIndexPriceField_ClosePrice_set(swigCPtr, this, value);
  }

  public double getClosePrice() {
    return thosttradeapiJNI.CThostFtdcIndexPriceField_ClosePrice_get(swigCPtr, this);
  }

  public CThostFtdcIndexPriceField() {
    this(thosttradeapiJNI.new_CThostFtdcIndexPriceField(), true);
  }

}
