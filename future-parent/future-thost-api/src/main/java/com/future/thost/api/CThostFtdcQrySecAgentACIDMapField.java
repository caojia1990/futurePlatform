/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcQrySecAgentACIDMapField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcQrySecAgentACIDMapField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcQrySecAgentACIDMapField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcQrySecAgentACIDMapField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_UserID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_AccountID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return thosttradeapiJNI.CThostFtdcQrySecAgentACIDMapField_CurrencyID_get(swigCPtr, this);
  }

  public CThostFtdcQrySecAgentACIDMapField() {
    this(thosttradeapiJNI.new_CThostFtdcQrySecAgentACIDMapField(), true);
  }

}
