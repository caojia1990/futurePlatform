/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcReqTransferField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcReqTransferField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcReqTransferField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcReqTransferField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setTradeCode(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TradeCode_set(swigCPtr, this, value);
  }

  public String getTradeCode() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TradeCode_get(swigCPtr, this);
  }

  public void setBankID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankID_get(swigCPtr, this);
  }

  public void setBankBranchID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankBranchID_set(swigCPtr, this, value);
  }

  public String getBankBranchID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankBranchID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BrokerID_get(swigCPtr, this);
  }

  public void setBrokerBranchID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BrokerBranchID_set(swigCPtr, this, value);
  }

  public String getBrokerBranchID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BrokerBranchID_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TradeDate_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TradeTime_get(swigCPtr, this);
  }

  public void setBankSerial(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankSerial_set(swigCPtr, this, value);
  }

  public String getBankSerial() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankSerial_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TradingDay_get(swigCPtr, this);
  }

  public void setPlateSerial(int value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_PlateSerial_set(swigCPtr, this, value);
  }

  public int getPlateSerial() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_PlateSerial_get(swigCPtr, this);
  }

  public void setLastFragment(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_LastFragment_set(swigCPtr, this, value);
  }

  public char getLastFragment() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_LastFragment_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_SessionID_get(swigCPtr, this);
  }

  public void setCustomerName(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_CustomerName_set(swigCPtr, this, value);
  }

  public String getCustomerName() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_CustomerName_get(swigCPtr, this);
  }

  public void setIdCardType(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_IdCardType_set(swigCPtr, this, value);
  }

  public char getIdCardType() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_IdCardType_get(swigCPtr, this);
  }

  public void setIdentifiedCardNo(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_IdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getIdentifiedCardNo() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_IdentifiedCardNo_get(swigCPtr, this);
  }

  public void setCustType(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_CustType_set(swigCPtr, this, value);
  }

  public char getCustType() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_CustType_get(swigCPtr, this);
  }

  public void setBankAccount(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankAccount_set(swigCPtr, this, value);
  }

  public String getBankAccount() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankAccount_get(swigCPtr, this);
  }

  public void setBankPassWord(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankPassWord_set(swigCPtr, this, value);
  }

  public String getBankPassWord() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankPassWord_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_AccountID_get(swigCPtr, this);
  }

  public void setPassword(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_Password_set(swigCPtr, this, value);
  }

  public String getPassword() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_Password_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_InstallID_get(swigCPtr, this);
  }

  public void setFutureSerial(int value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_FutureSerial_set(swigCPtr, this, value);
  }

  public int getFutureSerial() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_FutureSerial_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_UserID_get(swigCPtr, this);
  }

  public void setVerifyCertNoFlag(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_VerifyCertNoFlag_set(swigCPtr, this, value);
  }

  public char getVerifyCertNoFlag() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_VerifyCertNoFlag_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_CurrencyID_get(swigCPtr, this);
  }

  public void setTradeAmount(double value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TradeAmount_set(swigCPtr, this, value);
  }

  public double getTradeAmount() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TradeAmount_get(swigCPtr, this);
  }

  public void setFutureFetchAmount(double value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_FutureFetchAmount_set(swigCPtr, this, value);
  }

  public double getFutureFetchAmount() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_FutureFetchAmount_get(swigCPtr, this);
  }

  public void setFeePayFlag(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_FeePayFlag_set(swigCPtr, this, value);
  }

  public char getFeePayFlag() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_FeePayFlag_get(swigCPtr, this);
  }

  public void setCustFee(double value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_CustFee_set(swigCPtr, this, value);
  }

  public double getCustFee() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_CustFee_get(swigCPtr, this);
  }

  public void setBrokerFee(double value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BrokerFee_set(swigCPtr, this, value);
  }

  public double getBrokerFee() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BrokerFee_get(swigCPtr, this);
  }

  public void setMessage(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_Message_set(swigCPtr, this, value);
  }

  public String getMessage() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_Message_get(swigCPtr, this);
  }

  public void setDigest(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_Digest_set(swigCPtr, this, value);
  }

  public String getDigest() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_Digest_get(swigCPtr, this);
  }

  public void setBankAccType(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankAccType_set(swigCPtr, this, value);
  }

  public char getBankAccType() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankAccType_get(swigCPtr, this);
  }

  public void setDeviceID(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_DeviceID_set(swigCPtr, this, value);
  }

  public String getDeviceID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_DeviceID_get(swigCPtr, this);
  }

  public void setBankSecuAccType(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankSecuAccType_set(swigCPtr, this, value);
  }

  public char getBankSecuAccType() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankSecuAccType_get(swigCPtr, this);
  }

  public void setBrokerIDByBank(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BrokerIDByBank_set(swigCPtr, this, value);
  }

  public String getBrokerIDByBank() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BrokerIDByBank_get(swigCPtr, this);
  }

  public void setBankSecuAcc(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankSecuAcc_set(swigCPtr, this, value);
  }

  public String getBankSecuAcc() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankSecuAcc_get(swigCPtr, this);
  }

  public void setBankPwdFlag(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_BankPwdFlag_set(swigCPtr, this, value);
  }

  public char getBankPwdFlag() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_BankPwdFlag_get(swigCPtr, this);
  }

  public void setSecuPwdFlag(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_SecuPwdFlag_set(swigCPtr, this, value);
  }

  public char getSecuPwdFlag() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_SecuPwdFlag_get(swigCPtr, this);
  }

  public void setOperNo(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_OperNo_set(swigCPtr, this, value);
  }

  public String getOperNo() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_OperNo_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_RequestID_get(swigCPtr, this);
  }

  public void setTID(int value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TID_set(swigCPtr, this, value);
  }

  public int getTID() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TID_get(swigCPtr, this);
  }

  public void setTransferStatus(char value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_TransferStatus_set(swigCPtr, this, value);
  }

  public char getTransferStatus() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_TransferStatus_get(swigCPtr, this);
  }

  public void setLongCustomerName(String value) {
    thosttradeapiJNI.CThostFtdcReqTransferField_LongCustomerName_set(swigCPtr, this, value);
  }

  public String getLongCustomerName() {
    return thosttradeapiJNI.CThostFtdcReqTransferField_LongCustomerName_get(swigCPtr, this);
  }

  public CThostFtdcReqTransferField() {
    this(thosttradeapiJNI.new_CThostFtdcReqTransferField(), true);
  }

}
