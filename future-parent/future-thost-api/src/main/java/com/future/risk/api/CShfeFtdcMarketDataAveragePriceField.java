/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcMarketDataAveragePriceField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcMarketDataAveragePriceField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcMarketDataAveragePriceField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcMarketDataAveragePriceField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setAveragePrice(double value) {
    riskuserapiJNI.CShfeFtdcMarketDataAveragePriceField_AveragePrice_set(swigCPtr, this, value);
  }

  public double getAveragePrice() {
    return riskuserapiJNI.CShfeFtdcMarketDataAveragePriceField_AveragePrice_get(swigCPtr, this);
  }

  public CShfeFtdcMarketDataAveragePriceField() {
    this(riskuserapiJNI.new_CShfeFtdcMarketDataAveragePriceField(), true);
  }

}
