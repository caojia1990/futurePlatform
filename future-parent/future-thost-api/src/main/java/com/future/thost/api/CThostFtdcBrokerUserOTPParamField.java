/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcBrokerUserOTPParamField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcBrokerUserOTPParamField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcBrokerUserOTPParamField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcBrokerUserOTPParamField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_UserID_get(swigCPtr, this);
  }

  public void setOTPVendorsID(String value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_OTPVendorsID_set(swigCPtr, this, value);
  }

  public String getOTPVendorsID() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_OTPVendorsID_get(swigCPtr, this);
  }

  public void setSerialNumber(String value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_SerialNumber_set(swigCPtr, this, value);
  }

  public String getSerialNumber() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_SerialNumber_get(swigCPtr, this);
  }

  public void setAuthKey(String value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_AuthKey_set(swigCPtr, this, value);
  }

  public String getAuthKey() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_AuthKey_get(swigCPtr, this);
  }

  public void setLastDrift(int value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_LastDrift_set(swigCPtr, this, value);
  }

  public int getLastDrift() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_LastDrift_get(swigCPtr, this);
  }

  public void setLastSuccess(int value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_LastSuccess_set(swigCPtr, this, value);
  }

  public int getLastSuccess() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_LastSuccess_get(swigCPtr, this);
  }

  public void setOTPType(char value) {
    thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_OTPType_set(swigCPtr, this, value);
  }

  public char getOTPType() {
    return thosttradeapiJNI.CThostFtdcBrokerUserOTPParamField_OTPType_get(swigCPtr, this);
  }

  public CThostFtdcBrokerUserOTPParamField() {
    this(thosttradeapiJNI.new_CThostFtdcBrokerUserOTPParamField(), true);
  }

}
