/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcQryTransferBankField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcQryTransferBankField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcQryTransferBankField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcQryTransferBankField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBankID(String value) {
    riskuserapiJNI.CShfeFtdcQryTransferBankField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return riskuserapiJNI.CShfeFtdcQryTransferBankField_BankID_get(swigCPtr, this);
  }

  public void setBankBrchID(String value) {
    riskuserapiJNI.CShfeFtdcQryTransferBankField_BankBrchID_set(swigCPtr, this, value);
  }

  public String getBankBrchID() {
    return riskuserapiJNI.CShfeFtdcQryTransferBankField_BankBrchID_get(swigCPtr, this);
  }

  public CShfeFtdcQryTransferBankField() {
    this(riskuserapiJNI.new_CShfeFtdcQryTransferBankField(), true);
  }

}
