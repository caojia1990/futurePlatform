/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcRemoveParkedOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcRemoveParkedOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcRemoveParkedOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcRemoveParkedOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setParkedOrderID(String value) {
    riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_ParkedOrderID_set(swigCPtr, this, value);
  }

  public String getParkedOrderID() {
    return riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_ParkedOrderID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return riskuserapiJNI.CShfeFtdcRemoveParkedOrderField_InvestUnitID_get(swigCPtr, this);
  }

  public CShfeFtdcRemoveParkedOrderField() {
    this(riskuserapiJNI.new_CShfeFtdcRemoveParkedOrderField(), true);
  }

}
