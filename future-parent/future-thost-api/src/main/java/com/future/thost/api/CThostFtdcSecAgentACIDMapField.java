/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcSecAgentACIDMapField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcSecAgentACIDMapField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcSecAgentACIDMapField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcSecAgentACIDMapField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_UserID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_AccountID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_CurrencyID_get(swigCPtr, this);
  }

  public void setBrokerSecAgentID(String value) {
    thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_BrokerSecAgentID_set(swigCPtr, this, value);
  }

  public String getBrokerSecAgentID() {
    return thosttradeapiJNI.CThostFtdcSecAgentACIDMapField_BrokerSecAgentID_get(swigCPtr, this);
  }

  public CThostFtdcSecAgentACIDMapField() {
    this(thosttradeapiJNI.new_CThostFtdcSecAgentACIDMapField(), true);
  }

}
