/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcRiskForceCloseOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcRiskForceCloseOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcRiskForceCloseOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcRiskForceCloseOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFCType(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_FCType_set(swigCPtr, this, value);
  }

  public char getFCType() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_FCType_get(swigCPtr, this);
  }

  public void setTime1(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Time1_set(swigCPtr, this, value);
  }

  public String getTime1() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Time1_get(swigCPtr, this);
  }

  public void setMillisec1(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Millisec1_set(swigCPtr, this, value);
  }

  public int getMillisec1() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Millisec1_get(swigCPtr, this);
  }

  public void setTime2(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Time2_set(swigCPtr, this, value);
  }

  public String getTime2() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Time2_get(swigCPtr, this);
  }

  public void setMillisec2(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Millisec2_set(swigCPtr, this, value);
  }

  public int getMillisec2() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Millisec2_get(swigCPtr, this);
  }

  public void setFCSceneId(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_FCSceneId_set(swigCPtr, this, value);
  }

  public String getFCSceneId() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_FCSceneId_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_InstrumentID_get(swigCPtr, this);
  }

  public void setOrderRef(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_OrderRef_set(swigCPtr, this, value);
  }

  public String getOrderRef() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_OrderRef_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_UserID_get(swigCPtr, this);
  }

  public void setOrderPriceType(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_OrderPriceType_set(swigCPtr, this, value);
  }

  public char getOrderPriceType() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_OrderPriceType_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_Direction_get(swigCPtr, this);
  }

  public void setCombOffsetFlag(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_CombOffsetFlag_set(swigCPtr, this, value);
  }

  public String getCombOffsetFlag() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_CombOffsetFlag_get(swigCPtr, this);
  }

  public void setCombHedgeFlag(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_CombHedgeFlag_set(swigCPtr, this, value);
  }

  public String getCombHedgeFlag() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_CombHedgeFlag_get(swigCPtr, this);
  }

  public void setLimitPrice(double value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_LimitPrice_set(swigCPtr, this, value);
  }

  public double getLimitPrice() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_LimitPrice_get(swigCPtr, this);
  }

  public void setVolumeTotalOriginal(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_VolumeTotalOriginal_set(swigCPtr, this, value);
  }

  public int getVolumeTotalOriginal() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_VolumeTotalOriginal_get(swigCPtr, this);
  }

  public void setTimeCondition(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_TimeCondition_set(swigCPtr, this, value);
  }

  public char getTimeCondition() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_TimeCondition_get(swigCPtr, this);
  }

  public void setGTDDate(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_GTDDate_set(swigCPtr, this, value);
  }

  public String getGTDDate() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_GTDDate_get(swigCPtr, this);
  }

  public void setVolumeCondition(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_VolumeCondition_set(swigCPtr, this, value);
  }

  public char getVolumeCondition() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_VolumeCondition_get(swigCPtr, this);
  }

  public void setMinVolume(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_MinVolume_set(swigCPtr, this, value);
  }

  public int getMinVolume() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_MinVolume_get(swigCPtr, this);
  }

  public void setContingentCondition(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ContingentCondition_set(swigCPtr, this, value);
  }

  public char getContingentCondition() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ContingentCondition_get(swigCPtr, this);
  }

  public void setStopPrice(double value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_StopPrice_set(swigCPtr, this, value);
  }

  public double getStopPrice() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_StopPrice_get(swigCPtr, this);
  }

  public void setForceCloseReason(char value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ForceCloseReason_set(swigCPtr, this, value);
  }

  public char getForceCloseReason() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ForceCloseReason_get(swigCPtr, this);
  }

  public void setIsAutoSuspend(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_IsAutoSuspend_set(swigCPtr, this, value);
  }

  public int getIsAutoSuspend() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_IsAutoSuspend_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_BusinessUnit_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_RequestID_get(swigCPtr, this);
  }

  public void setUserForceClose(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_UserForceClose_set(swigCPtr, this, value);
  }

  public int getUserForceClose() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_UserForceClose_get(swigCPtr, this);
  }

  public void setFrontID(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_SessionID_get(swigCPtr, this);
  }

  public void setIsSwapOrder(int value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_IsSwapOrder_set(swigCPtr, this, value);
  }

  public int getIsSwapOrder() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_IsSwapOrder_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_InvestUnitID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_AccountID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_CurrencyID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_ClientID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return riskuserapiJNI.CShfeFtdcRiskForceCloseOrderField_MacAddress_get(swigCPtr, this);
  }

  public CShfeFtdcRiskForceCloseOrderField() {
    this(riskuserapiJNI.new_CShfeFtdcRiskForceCloseOrderField(), true);
  }

}
