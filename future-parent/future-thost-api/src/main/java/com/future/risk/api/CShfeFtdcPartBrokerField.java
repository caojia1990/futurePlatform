/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcPartBrokerField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcPartBrokerField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcPartBrokerField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcPartBrokerField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcPartBrokerField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcPartBrokerField_BrokerID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcPartBrokerField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcPartBrokerField_ExchangeID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    riskuserapiJNI.CShfeFtdcPartBrokerField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return riskuserapiJNI.CShfeFtdcPartBrokerField_ParticipantID_get(swigCPtr, this);
  }

  public void setIsActive(int value) {
    riskuserapiJNI.CShfeFtdcPartBrokerField_IsActive_set(swigCPtr, this, value);
  }

  public int getIsActive() {
    return riskuserapiJNI.CShfeFtdcPartBrokerField_IsActive_get(swigCPtr, this);
  }

  public CShfeFtdcPartBrokerField() {
    this(riskuserapiJNI.new_CShfeFtdcPartBrokerField(), true);
  }

}
