/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcBrokerUserEventField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcBrokerUserEventField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcBrokerUserEventField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcBrokerUserEventField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_BrokerID_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_UserID_get(swigCPtr, this);
  }

  public void setUserEventType(char value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_UserEventType_set(swigCPtr, this, value);
  }

  public char getUserEventType() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_UserEventType_get(swigCPtr, this);
  }

  public void setEventSequenceNo(int value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_EventSequenceNo_set(swigCPtr, this, value);
  }

  public int getEventSequenceNo() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_EventSequenceNo_get(swigCPtr, this);
  }

  public void setEventDate(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_EventDate_set(swigCPtr, this, value);
  }

  public String getEventDate() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_EventDate_get(swigCPtr, this);
  }

  public void setEventTime(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_EventTime_set(swigCPtr, this, value);
  }

  public String getEventTime() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_EventTime_get(swigCPtr, this);
  }

  public void setUserEventInfo(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_UserEventInfo_set(swigCPtr, this, value);
  }

  public String getUserEventInfo() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_UserEventInfo_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcBrokerUserEventField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcBrokerUserEventField_InstrumentID_get(swigCPtr, this);
  }

  public CShfeFtdcBrokerUserEventField() {
    this(riskuserapiJNI.new_CShfeFtdcBrokerUserEventField(), true);
  }

}
