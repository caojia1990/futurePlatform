/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcNormalRiskQueryField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcNormalRiskQueryField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcNormalRiskQueryField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcNormalRiskQueryField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcNormalRiskQueryField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcNormalRiskQueryField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcNormalRiskQueryField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcNormalRiskQueryField_UserID_get(swigCPtr, this);
  }

  public CShfeFtdcNormalRiskQueryField() {
    this(riskuserapiJNI.new_CShfeFtdcNormalRiskQueryField(), true);
  }

}
