/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcSecAgentCheckModeField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcSecAgentCheckModeField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcSecAgentCheckModeField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcSecAgentCheckModeField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_InvestorID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_BrokerID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_CurrencyID_get(swigCPtr, this);
  }

  public void setBrokerSecAgentID(String value) {
    riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_BrokerSecAgentID_set(swigCPtr, this, value);
  }

  public String getBrokerSecAgentID() {
    return riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_BrokerSecAgentID_get(swigCPtr, this);
  }

  public void setCheckSelfAccount(int value) {
    riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_CheckSelfAccount_set(swigCPtr, this, value);
  }

  public int getCheckSelfAccount() {
    return riskuserapiJNI.CShfeFtdcSecAgentCheckModeField_CheckSelfAccount_get(swigCPtr, this);
  }

  public CShfeFtdcSecAgentCheckModeField() {
    this(riskuserapiJNI.new_CShfeFtdcSecAgentCheckModeField(), true);
  }

}
