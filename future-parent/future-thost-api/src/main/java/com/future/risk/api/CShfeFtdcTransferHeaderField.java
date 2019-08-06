/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcTransferHeaderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcTransferHeaderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcTransferHeaderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcTransferHeaderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setVersion(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_Version_set(swigCPtr, this, value);
  }

  public String getVersion() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_Version_get(swigCPtr, this);
  }

  public void setTradeCode(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeCode_set(swigCPtr, this, value);
  }

  public String getTradeCode() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeCode_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeDate_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeTime_get(swigCPtr, this);
  }

  public void setTradeSerial(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeSerial_set(swigCPtr, this, value);
  }

  public String getTradeSerial() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_TradeSerial_get(swigCPtr, this);
  }

  public void setFutureID(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_FutureID_set(swigCPtr, this, value);
  }

  public String getFutureID() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_FutureID_get(swigCPtr, this);
  }

  public void setBankID(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_BankID_get(swigCPtr, this);
  }

  public void setBankBrchID(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_BankBrchID_set(swigCPtr, this, value);
  }

  public String getBankBrchID() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_BankBrchID_get(swigCPtr, this);
  }

  public void setOperNo(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_OperNo_set(swigCPtr, this, value);
  }

  public String getOperNo() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_OperNo_get(swigCPtr, this);
  }

  public void setDeviceID(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_DeviceID_set(swigCPtr, this, value);
  }

  public String getDeviceID() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_DeviceID_get(swigCPtr, this);
  }

  public void setRecordNum(String value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_RecordNum_set(swigCPtr, this, value);
  }

  public String getRecordNum() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_RecordNum_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_SessionID_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    riskuserapiJNI.CShfeFtdcTransferHeaderField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return riskuserapiJNI.CShfeFtdcTransferHeaderField_RequestID_get(swigCPtr, this);
  }

  public CShfeFtdcTransferHeaderField() {
    this(riskuserapiJNI.new_CShfeFtdcTransferHeaderField(), true);
  }

}
