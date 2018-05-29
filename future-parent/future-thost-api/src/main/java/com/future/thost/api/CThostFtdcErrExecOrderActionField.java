/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcErrExecOrderActionField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcErrExecOrderActionField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcErrExecOrderActionField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcErrExecOrderActionField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_InvestorID_get(swigCPtr, this);
  }

  public void setExecOrderActionRef(int value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExecOrderActionRef_set(swigCPtr, this, value);
  }

  public int getExecOrderActionRef() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExecOrderActionRef_get(swigCPtr, this);
  }

  public void setExecOrderRef(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExecOrderRef_set(swigCPtr, this, value);
  }

  public String getExecOrderRef() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExecOrderRef_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_RequestID_get(swigCPtr, this);
  }

  public void setFrontID(int value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_SessionID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExchangeID_get(swigCPtr, this);
  }

  public void setExecOrderSysID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExecOrderSysID_set(swigCPtr, this, value);
  }

  public String getExecOrderSysID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ExecOrderSysID_get(swigCPtr, this);
  }

  public void setActionFlag(char value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ActionFlag_set(swigCPtr, this, value);
  }

  public char getActionFlag() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ActionFlag_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_UserID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_InstrumentID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_InvestUnitID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_MacAddress_get(swigCPtr, this);
  }

  public void setErrorID(int value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ErrorID_set(swigCPtr, this, value);
  }

  public int getErrorID() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ErrorID_get(swigCPtr, this);
  }

  public void setErrorMsg(String value) {
    thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ErrorMsg_set(swigCPtr, this, value);
  }

  public String getErrorMsg() {
    return thosttradeapiJNI.CThostFtdcErrExecOrderActionField_ErrorMsg_get(swigCPtr, this);
  }

  public CThostFtdcErrExecOrderActionField() {
    this(thosttradeapiJNI.new_CThostFtdcErrExecOrderActionField(), true);
  }

}
