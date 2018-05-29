/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcInputQuoteActionField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcInputQuoteActionField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcInputQuoteActionField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcInputQuoteActionField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_InvestorID_get(swigCPtr, this);
  }

  public void setQuoteActionRef(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_QuoteActionRef_set(swigCPtr, this, value);
  }

  public int getQuoteActionRef() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_QuoteActionRef_get(swigCPtr, this);
  }

  public void setQuoteRef(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_QuoteRef_set(swigCPtr, this, value);
  }

  public String getQuoteRef() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_QuoteRef_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_RequestID_get(swigCPtr, this);
  }

  public void setFrontID(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_SessionID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_ExchangeID_get(swigCPtr, this);
  }

  public void setQuoteSysID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_QuoteSysID_set(swigCPtr, this, value);
  }

  public String getQuoteSysID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_QuoteSysID_get(swigCPtr, this);
  }

  public void setActionFlag(char value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_ActionFlag_set(swigCPtr, this, value);
  }

  public char getActionFlag() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_ActionFlag_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_UserID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_InstrumentID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_InvestUnitID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_ClientID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteActionField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return thosttradeapiJNI.CThostFtdcInputQuoteActionField_MacAddress_get(swigCPtr, this);
  }

  public CThostFtdcInputQuoteActionField() {
    this(thosttradeapiJNI.new_CThostFtdcInputQuoteActionField(), true);
  }

}
