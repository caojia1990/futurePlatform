/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcReqUserLoginField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcReqUserLoginField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcReqUserLoginField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcReqUserLoginField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradingDay(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_TradingDay_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_UserID_get(swigCPtr, this);
  }

  public void setPassword(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_Password_set(swigCPtr, this, value);
  }

  public String getPassword() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_Password_get(swigCPtr, this);
  }

  public void setUserProductInfo(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_UserProductInfo_set(swigCPtr, this, value);
  }

  public String getUserProductInfo() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_UserProductInfo_get(swigCPtr, this);
  }

  public void setInterfaceProductInfo(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_InterfaceProductInfo_set(swigCPtr, this, value);
  }

  public String getInterfaceProductInfo() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_InterfaceProductInfo_get(swigCPtr, this);
  }

  public void setProtocolInfo(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_ProtocolInfo_set(swigCPtr, this, value);
  }

  public String getProtocolInfo() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_ProtocolInfo_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_MacAddress_get(swigCPtr, this);
  }

  public void setOneTimePassword(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_OneTimePassword_set(swigCPtr, this, value);
  }

  public String getOneTimePassword() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_OneTimePassword_get(swigCPtr, this);
  }

  public void setClientIPAddress(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_ClientIPAddress_set(swigCPtr, this, value);
  }

  public String getClientIPAddress() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_ClientIPAddress_get(swigCPtr, this);
  }

  public void setLoginRemark(String value) {
    thosttradeapiJNI.CThostFtdcReqUserLoginField_LoginRemark_set(swigCPtr, this, value);
  }

  public String getLoginRemark() {
    return thosttradeapiJNI.CThostFtdcReqUserLoginField_LoginRemark_get(swigCPtr, this);
  }

  public CThostFtdcReqUserLoginField() {
    this(thosttradeapiJNI.new_CThostFtdcReqUserLoginField(), true);
  }

}
