/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcTradingAccountPasswordField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcTradingAccountPasswordField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcTradingAccountPasswordField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcTradingAccountPasswordField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_BrokerID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_AccountID_get(swigCPtr, this);
  }

  public void setPassword(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_Password_set(swigCPtr, this, value);
  }

  public String getPassword() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_Password_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordField_CurrencyID_get(swigCPtr, this);
  }

  public CThostFtdcTradingAccountPasswordField() {
    this(thosttradeapiJNI.new_CThostFtdcTradingAccountPasswordField(), true);
  }

}
