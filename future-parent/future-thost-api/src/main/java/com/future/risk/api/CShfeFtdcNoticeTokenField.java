/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcNoticeTokenField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcNoticeTokenField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcNoticeTokenField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcNoticeTokenField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setToken(String value) {
    riskuserapiJNI.CShfeFtdcNoticeTokenField_Token_set(swigCPtr, this, value);
  }

  public String getToken() {
    return riskuserapiJNI.CShfeFtdcNoticeTokenField_Token_get(swigCPtr, this);
  }

  public void setDescription(String value) {
    riskuserapiJNI.CShfeFtdcNoticeTokenField_Description_set(swigCPtr, this, value);
  }

  public String getDescription() {
    return riskuserapiJNI.CShfeFtdcNoticeTokenField_Description_get(swigCPtr, this);
  }

  public CShfeFtdcNoticeTokenField() {
    this(riskuserapiJNI.new_CShfeFtdcNoticeTokenField(), true);
  }

}
