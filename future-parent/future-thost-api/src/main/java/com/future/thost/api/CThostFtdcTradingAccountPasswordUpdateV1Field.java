/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcTradingAccountPasswordUpdateV1Field {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcTradingAccountPasswordUpdateV1Field(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcTradingAccountPasswordUpdateV1Field obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcTradingAccountPasswordUpdateV1Field(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_InvestorID_get(swigCPtr, this);
  }

  public void setOldPassword(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_OldPassword_set(swigCPtr, this, value);
  }

  public String getOldPassword() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_OldPassword_get(swigCPtr, this);
  }

  public void setNewPassword(String value) {
    thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_NewPassword_set(swigCPtr, this, value);
  }

  public String getNewPassword() {
    return thosttradeapiJNI.CThostFtdcTradingAccountPasswordUpdateV1Field_NewPassword_get(swigCPtr, this);
  }

  public CThostFtdcTradingAccountPasswordUpdateV1Field() {
    this(thosttradeapiJNI.new_CThostFtdcTradingAccountPasswordUpdateV1Field(), true);
  }

}
