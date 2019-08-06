/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcSTPriceField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcSTPriceField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcSTPriceField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcSTPriceField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcSTPriceField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcSTPriceField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorRange(char value) {
    riskuserapiJNI.CShfeFtdcSTPriceField_InvestorRange_set(swigCPtr, this, value);
  }

  public char getInvestorRange() {
    return riskuserapiJNI.CShfeFtdcSTPriceField_InvestorRange_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcSTPriceField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcSTPriceField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcSTPriceField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcSTPriceField_InstrumentID_get(swigCPtr, this);
  }

  public void setPriceType(char value) {
    riskuserapiJNI.CShfeFtdcSTPriceField_PriceType_set(swigCPtr, this, value);
  }

  public char getPriceType() {
    return riskuserapiJNI.CShfeFtdcSTPriceField_PriceType_get(swigCPtr, this);
  }

  public void setPrice(double value) {
    riskuserapiJNI.CShfeFtdcSTPriceField_Price_set(swigCPtr, this, value);
  }

  public double getPrice() {
    return riskuserapiJNI.CShfeFtdcSTPriceField_Price_get(swigCPtr, this);
  }

  public CShfeFtdcSTPriceField() {
    this(riskuserapiJNI.new_CShfeFtdcSTPriceField(), true);
  }

}
