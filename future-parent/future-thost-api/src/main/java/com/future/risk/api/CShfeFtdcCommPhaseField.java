/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcCommPhaseField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcCommPhaseField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcCommPhaseField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcCommPhaseField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradingDay(String value) {
    riskuserapiJNI.CShfeFtdcCommPhaseField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return riskuserapiJNI.CShfeFtdcCommPhaseField_TradingDay_get(swigCPtr, this);
  }

  public void setCommPhaseNo(short value) {
    riskuserapiJNI.CShfeFtdcCommPhaseField_CommPhaseNo_set(swigCPtr, this, value);
  }

  public short getCommPhaseNo() {
    return riskuserapiJNI.CShfeFtdcCommPhaseField_CommPhaseNo_get(swigCPtr, this);
  }

  public void setSystemID(String value) {
    riskuserapiJNI.CShfeFtdcCommPhaseField_SystemID_set(swigCPtr, this, value);
  }

  public String getSystemID() {
    return riskuserapiJNI.CShfeFtdcCommPhaseField_SystemID_get(swigCPtr, this);
  }

  public CShfeFtdcCommPhaseField() {
    this(riskuserapiJNI.new_CShfeFtdcCommPhaseField(), true);
  }

}
