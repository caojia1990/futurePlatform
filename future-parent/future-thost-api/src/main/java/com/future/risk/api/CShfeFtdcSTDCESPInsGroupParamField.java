/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcSTDCESPInsGroupParamField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcSTDCESPInsGroupParamField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcSTDCESPInsGroupParamField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcSTDCESPInsGroupParamField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setProductID(String value) {
    riskuserapiJNI.CShfeFtdcSTDCESPInsGroupParamField_ProductID_set(swigCPtr, this, value);
  }

  public String getProductID() {
    return riskuserapiJNI.CShfeFtdcSTDCESPInsGroupParamField_ProductID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcSTDCESPInsGroupParamField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcSTDCESPInsGroupParamField_InstrumentID_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    riskuserapiJNI.CShfeFtdcSTDCESPInsGroupParamField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return riskuserapiJNI.CShfeFtdcSTDCESPInsGroupParamField_SequenceNo_get(swigCPtr, this);
  }

  public CShfeFtdcSTDCESPInsGroupParamField() {
    this(riskuserapiJNI.new_CShfeFtdcSTDCESPInsGroupParamField(), true);
  }

}
