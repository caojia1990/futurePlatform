/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcProductExchRateField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcProductExchRateField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcProductExchRateField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcProductExchRateField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setProductID(String value) {
    riskuserapiJNI.CShfeFtdcProductExchRateField_ProductID_set(swigCPtr, this, value);
  }

  public String getProductID() {
    return riskuserapiJNI.CShfeFtdcProductExchRateField_ProductID_get(swigCPtr, this);
  }

  public void setQuoteCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcProductExchRateField_QuoteCurrencyID_set(swigCPtr, this, value);
  }

  public String getQuoteCurrencyID() {
    return riskuserapiJNI.CShfeFtdcProductExchRateField_QuoteCurrencyID_get(swigCPtr, this);
  }

  public void setExchangeRate(double value) {
    riskuserapiJNI.CShfeFtdcProductExchRateField_ExchangeRate_set(swigCPtr, this, value);
  }

  public double getExchangeRate() {
    return riskuserapiJNI.CShfeFtdcProductExchRateField_ExchangeRate_get(swigCPtr, this);
  }

  public CShfeFtdcProductExchRateField() {
    this(riskuserapiJNI.new_CShfeFtdcProductExchRateField(), true);
  }

}
