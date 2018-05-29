/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcNotifyFutureSignInField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcNotifyFutureSignInField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcNotifyFutureSignInField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcNotifyFutureSignInField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradeCode(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradeCode_set(swigCPtr, this, value);
  }

  public String getTradeCode() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradeCode_get(swigCPtr, this);
  }

  public void setBankID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BankID_get(swigCPtr, this);
  }

  public void setBankBranchID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BankBranchID_set(swigCPtr, this, value);
  }

  public String getBankBranchID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BankBranchID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BrokerID_get(swigCPtr, this);
  }

  public void setBrokerBranchID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BrokerBranchID_set(swigCPtr, this, value);
  }

  public String getBrokerBranchID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BrokerBranchID_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradeDate_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradeTime_get(swigCPtr, this);
  }

  public void setBankSerial(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BankSerial_set(swigCPtr, this, value);
  }

  public String getBankSerial() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BankSerial_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TradingDay_get(swigCPtr, this);
  }

  public void setPlateSerial(int value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_PlateSerial_set(swigCPtr, this, value);
  }

  public int getPlateSerial() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_PlateSerial_get(swigCPtr, this);
  }

  public void setLastFragment(char value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_LastFragment_set(swigCPtr, this, value);
  }

  public char getLastFragment() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_LastFragment_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_SessionID_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_InstallID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_UserID_get(swigCPtr, this);
  }

  public void setDigest(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_Digest_set(swigCPtr, this, value);
  }

  public String getDigest() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_Digest_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_CurrencyID_get(swigCPtr, this);
  }

  public void setDeviceID(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_DeviceID_set(swigCPtr, this, value);
  }

  public String getDeviceID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_DeviceID_get(swigCPtr, this);
  }

  public void setBrokerIDByBank(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BrokerIDByBank_set(swigCPtr, this, value);
  }

  public String getBrokerIDByBank() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_BrokerIDByBank_get(swigCPtr, this);
  }

  public void setOperNo(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_OperNo_set(swigCPtr, this, value);
  }

  public String getOperNo() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_OperNo_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_RequestID_get(swigCPtr, this);
  }

  public void setTID(int value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TID_set(swigCPtr, this, value);
  }

  public int getTID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_TID_get(swigCPtr, this);
  }

  public void setErrorID(int value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_ErrorID_set(swigCPtr, this, value);
  }

  public int getErrorID() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_ErrorID_get(swigCPtr, this);
  }

  public void setErrorMsg(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_ErrorMsg_set(swigCPtr, this, value);
  }

  public String getErrorMsg() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_ErrorMsg_get(swigCPtr, this);
  }

  public void setPinKey(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_PinKey_set(swigCPtr, this, value);
  }

  public String getPinKey() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_PinKey_get(swigCPtr, this);
  }

  public void setMacKey(String value) {
    thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_MacKey_set(swigCPtr, this, value);
  }

  public String getMacKey() {
    return thosttradeapiJNI.CThostFtdcNotifyFutureSignInField_MacKey_get(swigCPtr, this);
  }

  public CThostFtdcNotifyFutureSignInField() {
    this(thosttradeapiJNI.new_CThostFtdcNotifyFutureSignInField(), true);
  }

}
