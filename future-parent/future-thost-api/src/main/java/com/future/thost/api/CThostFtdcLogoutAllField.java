/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcLogoutAllField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcLogoutAllField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcLogoutAllField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcLogoutAllField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFrontID(int value) {
    thosttradeapiJNI.CThostFtdcLogoutAllField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return thosttradeapiJNI.CThostFtdcLogoutAllField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttradeapiJNI.CThostFtdcLogoutAllField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttradeapiJNI.CThostFtdcLogoutAllField_SessionID_get(swigCPtr, this);
  }

  public void setSystemName(String value) {
    thosttradeapiJNI.CThostFtdcLogoutAllField_SystemName_set(swigCPtr, this, value);
  }

  public String getSystemName() {
    return thosttradeapiJNI.CThostFtdcLogoutAllField_SystemName_get(swigCPtr, this);
  }

  public CThostFtdcLogoutAllField() {
    this(thosttradeapiJNI.new_CThostFtdcLogoutAllField(), true);
  }

}
