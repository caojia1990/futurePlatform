/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcQrySuperUserField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcQrySuperUserField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcQrySuperUserField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcQrySuperUserField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcQrySuperUserField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcQrySuperUserField_UserID_get(swigCPtr, this);
  }

  public CShfeFtdcQrySuperUserField() {
    this(riskuserapiJNI.new_CShfeFtdcQrySuperUserField(), true);
  }

}
