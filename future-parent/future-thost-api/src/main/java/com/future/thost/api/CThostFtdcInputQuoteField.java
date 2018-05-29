/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcInputQuoteField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcInputQuoteField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcInputQuoteField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcInputQuoteField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_InstrumentID_get(swigCPtr, this);
  }

  public void setQuoteRef(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_QuoteRef_set(swigCPtr, this, value);
  }

  public String getQuoteRef() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_QuoteRef_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_UserID_get(swigCPtr, this);
  }

  public void setAskPrice(double value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_AskPrice_set(swigCPtr, this, value);
  }

  public double getAskPrice() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_AskPrice_get(swigCPtr, this);
  }

  public void setBidPrice(double value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BidPrice_set(swigCPtr, this, value);
  }

  public double getBidPrice() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BidPrice_get(swigCPtr, this);
  }

  public void setAskVolume(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_AskVolume_set(swigCPtr, this, value);
  }

  public int getAskVolume() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_AskVolume_get(swigCPtr, this);
  }

  public void setBidVolume(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BidVolume_set(swigCPtr, this, value);
  }

  public int getBidVolume() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BidVolume_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_RequestID_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BusinessUnit_get(swigCPtr, this);
  }

  public void setAskOffsetFlag(char value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_AskOffsetFlag_set(swigCPtr, this, value);
  }

  public char getAskOffsetFlag() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_AskOffsetFlag_get(swigCPtr, this);
  }

  public void setBidOffsetFlag(char value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BidOffsetFlag_set(swigCPtr, this, value);
  }

  public char getBidOffsetFlag() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BidOffsetFlag_get(swigCPtr, this);
  }

  public void setAskHedgeFlag(char value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_AskHedgeFlag_set(swigCPtr, this, value);
  }

  public char getAskHedgeFlag() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_AskHedgeFlag_get(swigCPtr, this);
  }

  public void setBidHedgeFlag(char value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BidHedgeFlag_set(swigCPtr, this, value);
  }

  public char getBidHedgeFlag() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BidHedgeFlag_get(swigCPtr, this);
  }

  public void setAskOrderRef(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_AskOrderRef_set(swigCPtr, this, value);
  }

  public String getAskOrderRef() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_AskOrderRef_get(swigCPtr, this);
  }

  public void setBidOrderRef(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_BidOrderRef_set(swigCPtr, this, value);
  }

  public String getBidOrderRef() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_BidOrderRef_get(swigCPtr, this);
  }

  public void setForQuoteSysID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_ForQuoteSysID_set(swigCPtr, this, value);
  }

  public String getForQuoteSysID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_ForQuoteSysID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_ExchangeID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_InvestUnitID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_ClientID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    thosttradeapiJNI.CThostFtdcInputQuoteField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return thosttradeapiJNI.CThostFtdcInputQuoteField_MacAddress_get(swigCPtr, this);
  }

  public CThostFtdcInputQuoteField() {
    this(thosttradeapiJNI.new_CThostFtdcInputQuoteField(), true);
  }

}
