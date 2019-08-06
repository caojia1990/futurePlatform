/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcErrOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcErrOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcErrOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcErrOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_InstrumentID_get(swigCPtr, this);
  }

  public void setOrderRef(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_OrderRef_set(swigCPtr, this, value);
  }

  public String getOrderRef() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_OrderRef_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_UserID_get(swigCPtr, this);
  }

  public void setOrderPriceType(char value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_OrderPriceType_set(swigCPtr, this, value);
  }

  public char getOrderPriceType() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_OrderPriceType_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_Direction_get(swigCPtr, this);
  }

  public void setCombOffsetFlag(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_CombOffsetFlag_set(swigCPtr, this, value);
  }

  public String getCombOffsetFlag() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_CombOffsetFlag_get(swigCPtr, this);
  }

  public void setCombHedgeFlag(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_CombHedgeFlag_set(swigCPtr, this, value);
  }

  public String getCombHedgeFlag() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_CombHedgeFlag_get(swigCPtr, this);
  }

  public void setLimitPrice(double value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_LimitPrice_set(swigCPtr, this, value);
  }

  public double getLimitPrice() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_LimitPrice_get(swigCPtr, this);
  }

  public void setVolumeTotalOriginal(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_VolumeTotalOriginal_set(swigCPtr, this, value);
  }

  public int getVolumeTotalOriginal() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_VolumeTotalOriginal_get(swigCPtr, this);
  }

  public void setTimeCondition(char value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_TimeCondition_set(swigCPtr, this, value);
  }

  public char getTimeCondition() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_TimeCondition_get(swigCPtr, this);
  }

  public void setGTDDate(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_GTDDate_set(swigCPtr, this, value);
  }

  public String getGTDDate() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_GTDDate_get(swigCPtr, this);
  }

  public void setVolumeCondition(char value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_VolumeCondition_set(swigCPtr, this, value);
  }

  public char getVolumeCondition() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_VolumeCondition_get(swigCPtr, this);
  }

  public void setMinVolume(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_MinVolume_set(swigCPtr, this, value);
  }

  public int getMinVolume() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_MinVolume_get(swigCPtr, this);
  }

  public void setContingentCondition(char value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_ContingentCondition_set(swigCPtr, this, value);
  }

  public char getContingentCondition() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_ContingentCondition_get(swigCPtr, this);
  }

  public void setStopPrice(double value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_StopPrice_set(swigCPtr, this, value);
  }

  public double getStopPrice() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_StopPrice_get(swigCPtr, this);
  }

  public void setForceCloseReason(char value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_ForceCloseReason_set(swigCPtr, this, value);
  }

  public char getForceCloseReason() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_ForceCloseReason_get(swigCPtr, this);
  }

  public void setIsAutoSuspend(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_IsAutoSuspend_set(swigCPtr, this, value);
  }

  public int getIsAutoSuspend() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_IsAutoSuspend_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_BusinessUnit_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_RequestID_get(swigCPtr, this);
  }

  public void setUserForceClose(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_UserForceClose_set(swigCPtr, this, value);
  }

  public int getUserForceClose() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_UserForceClose_get(swigCPtr, this);
  }

  public void setErrorID(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_ErrorID_set(swigCPtr, this, value);
  }

  public int getErrorID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_ErrorID_get(swigCPtr, this);
  }

  public void setErrorMsg(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_ErrorMsg_set(swigCPtr, this, value);
  }

  public String getErrorMsg() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_ErrorMsg_get(swigCPtr, this);
  }

  public void setIsSwapOrder(int value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_IsSwapOrder_set(swigCPtr, this, value);
  }

  public int getIsSwapOrder() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_IsSwapOrder_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_InvestUnitID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_AccountID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_CurrencyID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_ClientID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    riskuserapiJNI.CShfeFtdcErrOrderField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return riskuserapiJNI.CShfeFtdcErrOrderField_MacAddress_get(swigCPtr, this);
  }

  public CShfeFtdcErrOrderField() {
    this(riskuserapiJNI.new_CShfeFtdcErrOrderField(), true);
  }

}
