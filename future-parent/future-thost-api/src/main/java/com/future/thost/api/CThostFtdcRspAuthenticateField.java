/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcRspAuthenticateField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcRspAuthenticateField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcRspAuthenticateField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcRspAuthenticateField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcRspAuthenticateField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcRspAuthenticateField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcRspAuthenticateField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcRspAuthenticateField_UserID_get(swigCPtr, this);
  }

  public void setUserProductInfo(String value) {
    thosttradeapiJNI.CThostFtdcRspAuthenticateField_UserProductInfo_set(swigCPtr, this, value);
  }

  public String getUserProductInfo() {
    return thosttradeapiJNI.CThostFtdcRspAuthenticateField_UserProductInfo_get(swigCPtr, this);
  }

  public CThostFtdcRspAuthenticateField() {
    this(thosttradeapiJNI.new_CThostFtdcRspAuthenticateField(), true);
  }

}
