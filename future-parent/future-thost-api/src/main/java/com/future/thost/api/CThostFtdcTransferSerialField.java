/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcTransferSerialField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcTransferSerialField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcTransferSerialField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcTransferSerialField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPlateSerial(int value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_PlateSerial_set(swigCPtr, this, value);
  }

  public int getPlateSerial() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_PlateSerial_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_TradeDate_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_TradingDay_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_TradeTime_get(swigCPtr, this);
  }

  public void setTradeCode(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_TradeCode_set(swigCPtr, this, value);
  }

  public String getTradeCode() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_TradeCode_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_SessionID_get(swigCPtr, this);
  }

  public void setBankID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BankID_get(swigCPtr, this);
  }

  public void setBankBranchID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BankBranchID_set(swigCPtr, this, value);
  }

  public String getBankBranchID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BankBranchID_get(swigCPtr, this);
  }

  public void setBankAccType(char value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BankAccType_set(swigCPtr, this, value);
  }

  public char getBankAccType() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BankAccType_get(swigCPtr, this);
  }

  public void setBankAccount(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BankAccount_set(swigCPtr, this, value);
  }

  public String getBankAccount() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BankAccount_get(swigCPtr, this);
  }

  public void setBankSerial(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BankSerial_set(swigCPtr, this, value);
  }

  public String getBankSerial() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BankSerial_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BrokerID_get(swigCPtr, this);
  }

  public void setBrokerBranchID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BrokerBranchID_set(swigCPtr, this, value);
  }

  public String getBrokerBranchID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BrokerBranchID_get(swigCPtr, this);
  }

  public void setFutureAccType(char value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_FutureAccType_set(swigCPtr, this, value);
  }

  public char getFutureAccType() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_FutureAccType_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_AccountID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_InvestorID_get(swigCPtr, this);
  }

  public void setFutureSerial(int value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_FutureSerial_set(swigCPtr, this, value);
  }

  public int getFutureSerial() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_FutureSerial_get(swigCPtr, this);
  }

  public void setIdCardType(char value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_IdCardType_set(swigCPtr, this, value);
  }

  public char getIdCardType() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_IdCardType_get(swigCPtr, this);
  }

  public void setIdentifiedCardNo(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_IdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getIdentifiedCardNo() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_IdentifiedCardNo_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_CurrencyID_get(swigCPtr, this);
  }

  public void setTradeAmount(double value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_TradeAmount_set(swigCPtr, this, value);
  }

  public double getTradeAmount() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_TradeAmount_get(swigCPtr, this);
  }

  public void setCustFee(double value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_CustFee_set(swigCPtr, this, value);
  }

  public double getCustFee() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_CustFee_get(swigCPtr, this);
  }

  public void setBrokerFee(double value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BrokerFee_set(swigCPtr, this, value);
  }

  public double getBrokerFee() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BrokerFee_get(swigCPtr, this);
  }

  public void setAvailabilityFlag(char value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_AvailabilityFlag_set(swigCPtr, this, value);
  }

  public char getAvailabilityFlag() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_AvailabilityFlag_get(swigCPtr, this);
  }

  public void setOperatorCode(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_OperatorCode_set(swigCPtr, this, value);
  }

  public String getOperatorCode() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_OperatorCode_get(swigCPtr, this);
  }

  public void setBankNewAccount(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_BankNewAccount_set(swigCPtr, this, value);
  }

  public String getBankNewAccount() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_BankNewAccount_get(swigCPtr, this);
  }

  public void setErrorID(int value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_ErrorID_set(swigCPtr, this, value);
  }

  public int getErrorID() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_ErrorID_get(swigCPtr, this);
  }

  public void setErrorMsg(String value) {
    thosttradeapiJNI.CThostFtdcTransferSerialField_ErrorMsg_set(swigCPtr, this, value);
  }

  public String getErrorMsg() {
    return thosttradeapiJNI.CThostFtdcTransferSerialField_ErrorMsg_get(swigCPtr, this);
  }

  public CThostFtdcTransferSerialField() {
    this(thosttradeapiJNI.new_CThostFtdcTransferSerialField(), true);
  }

}
