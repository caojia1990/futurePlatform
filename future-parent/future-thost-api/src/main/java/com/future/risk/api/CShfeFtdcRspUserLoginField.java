/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcRspUserLoginField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcRspUserLoginField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcRspUserLoginField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcRspUserLoginField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradingDay(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_TradingDay_get(swigCPtr, this);
  }

  public void setLoginTime(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_LoginTime_set(swigCPtr, this, value);
  }

  public String getLoginTime() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_LoginTime_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_UserID_get(swigCPtr, this);
  }

  public void setSystemName(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_SystemName_set(swigCPtr, this, value);
  }

  public String getSystemName() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_SystemName_get(swigCPtr, this);
  }

  public void setFrontID(int value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_SessionID_get(swigCPtr, this);
  }

  public void setMaxOrderRef(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_MaxOrderRef_set(swigCPtr, this, value);
  }

  public String getMaxOrderRef() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_MaxOrderRef_get(swigCPtr, this);
  }

  public void setSHFETime(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_SHFETime_set(swigCPtr, this, value);
  }

  public String getSHFETime() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_SHFETime_get(swigCPtr, this);
  }

  public void setDCETime(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_DCETime_set(swigCPtr, this, value);
  }

  public String getDCETime() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_DCETime_get(swigCPtr, this);
  }

  public void setCZCETime(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_CZCETime_set(swigCPtr, this, value);
  }

  public String getCZCETime() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_CZCETime_get(swigCPtr, this);
  }

  public void setFFEXTime(String value) {
    riskuserapiJNI.CShfeFtdcRspUserLoginField_FFEXTime_set(swigCPtr, this, value);
  }

  public String getFFEXTime() {
    return riskuserapiJNI.CShfeFtdcRspUserLoginField_FFEXTime_get(swigCPtr, this);
  }

  public CShfeFtdcRspUserLoginField() {
    this(riskuserapiJNI.new_CShfeFtdcRspUserLoginField(), true);
  }

}
