/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcSuperUserField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcSuperUserField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcSuperUserField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcSuperUserField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcSuperUserField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcSuperUserField_UserID_get(swigCPtr, this);
  }

  public void setUserName(String value) {
    thosttradeapiJNI.CThostFtdcSuperUserField_UserName_set(swigCPtr, this, value);
  }

  public String getUserName() {
    return thosttradeapiJNI.CThostFtdcSuperUserField_UserName_get(swigCPtr, this);
  }

  public void setPassword(String value) {
    thosttradeapiJNI.CThostFtdcSuperUserField_Password_set(swigCPtr, this, value);
  }

  public String getPassword() {
    return thosttradeapiJNI.CThostFtdcSuperUserField_Password_get(swigCPtr, this);
  }

  public void setIsActive(int value) {
    thosttradeapiJNI.CThostFtdcSuperUserField_IsActive_set(swigCPtr, this, value);
  }

  public int getIsActive() {
    return thosttradeapiJNI.CThostFtdcSuperUserField_IsActive_get(swigCPtr, this);
  }

  public CThostFtdcSuperUserField() {
    this(thosttradeapiJNI.new_CThostFtdcSuperUserField(), true);
  }

}
