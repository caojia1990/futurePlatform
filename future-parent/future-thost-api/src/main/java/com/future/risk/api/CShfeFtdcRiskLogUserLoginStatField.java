/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcRiskLogUserLoginStatField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcRiskLogUserLoginStatField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcRiskLogUserLoginStatField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcRiskLogUserLoginStatField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setStatType(char value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_StatType_set(swigCPtr, this, value);
  }

  public char getStatType() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_StatType_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_UserID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_MacAddress_get(swigCPtr, this);
  }

  public void setTotalNum(int value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_TotalNum_set(swigCPtr, this, value);
  }

  public int getTotalNum() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_TotalNum_get(swigCPtr, this);
  }

  public void setSuccessNum(int value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_SuccessNum_set(swigCPtr, this, value);
  }

  public int getSuccessNum() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_SuccessNum_get(swigCPtr, this);
  }

  public void setFailNum(int value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_FailNum_set(swigCPtr, this, value);
  }

  public int getFailNum() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_FailNum_get(swigCPtr, this);
  }

  public void setUserNumByAddress(int value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_UserNumByAddress_set(swigCPtr, this, value);
  }

  public int getUserNumByAddress() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_UserNumByAddress_get(swigCPtr, this);
  }

  public void setAddressNumByUser(int value) {
    riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_AddressNumByUser_set(swigCPtr, this, value);
  }

  public int getAddressNumByUser() {
    return riskuserapiJNI.CShfeFtdcRiskLogUserLoginStatField_AddressNumByUser_get(swigCPtr, this);
  }

  public CShfeFtdcRiskLogUserLoginStatField() {
    this(riskuserapiJNI.new_CShfeFtdcRiskLogUserLoginStatField(), true);
  }

}
