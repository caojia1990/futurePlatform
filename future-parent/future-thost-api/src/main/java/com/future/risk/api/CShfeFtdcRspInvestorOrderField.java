/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcRspInvestorOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcRspInvestorOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcRspInvestorOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcRspInvestorOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InstrumentID_get(swigCPtr, this);
  }

  public void setOrderRef(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderRef_set(swigCPtr, this, value);
  }

  public String getOrderRef() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderRef_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UserID_get(swigCPtr, this);
  }

  public void setOrderPriceType(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderPriceType_set(swigCPtr, this, value);
  }

  public char getOrderPriceType() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderPriceType_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_Direction_get(swigCPtr, this);
  }

  public void setCombOffsetFlag(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CombOffsetFlag_set(swigCPtr, this, value);
  }

  public String getCombOffsetFlag() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CombOffsetFlag_get(swigCPtr, this);
  }

  public void setCombHedgeFlag(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CombHedgeFlag_set(swigCPtr, this, value);
  }

  public String getCombHedgeFlag() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CombHedgeFlag_get(swigCPtr, this);
  }

  public void setLimitPrice(double value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_LimitPrice_set(swigCPtr, this, value);
  }

  public double getLimitPrice() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_LimitPrice_get(swigCPtr, this);
  }

  public void setVolumeTotalOriginal(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeTotalOriginal_set(swigCPtr, this, value);
  }

  public int getVolumeTotalOriginal() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeTotalOriginal_get(swigCPtr, this);
  }

  public void setTimeCondition(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_TimeCondition_set(swigCPtr, this, value);
  }

  public char getTimeCondition() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_TimeCondition_get(swigCPtr, this);
  }

  public void setGTDDate(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_GTDDate_set(swigCPtr, this, value);
  }

  public String getGTDDate() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_GTDDate_get(swigCPtr, this);
  }

  public void setVolumeCondition(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeCondition_set(swigCPtr, this, value);
  }

  public char getVolumeCondition() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeCondition_get(swigCPtr, this);
  }

  public void setMinVolume(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_MinVolume_set(swigCPtr, this, value);
  }

  public int getMinVolume() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_MinVolume_get(swigCPtr, this);
  }

  public void setContingentCondition(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ContingentCondition_set(swigCPtr, this, value);
  }

  public char getContingentCondition() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ContingentCondition_get(swigCPtr, this);
  }

  public void setStopPrice(double value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_StopPrice_set(swigCPtr, this, value);
  }

  public double getStopPrice() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_StopPrice_get(swigCPtr, this);
  }

  public void setForceCloseReason(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ForceCloseReason_set(swigCPtr, this, value);
  }

  public char getForceCloseReason() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ForceCloseReason_get(swigCPtr, this);
  }

  public void setIsAutoSuspend(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_IsAutoSuspend_set(swigCPtr, this, value);
  }

  public int getIsAutoSuspend() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_IsAutoSuspend_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BusinessUnit_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_RequestID_get(swigCPtr, this);
  }

  public void setOrderLocalID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderLocalID_set(swigCPtr, this, value);
  }

  public String getOrderLocalID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderLocalID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ParticipantID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ClientID_get(swigCPtr, this);
  }

  public void setExchangeInstID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ExchangeInstID_set(swigCPtr, this, value);
  }

  public String getExchangeInstID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ExchangeInstID_get(swigCPtr, this);
  }

  public void setTraderID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_TraderID_set(swigCPtr, this, value);
  }

  public String getTraderID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_TraderID_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InstallID_get(swigCPtr, this);
  }

  public void setOrderSubmitStatus(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderSubmitStatus_set(swigCPtr, this, value);
  }

  public char getOrderSubmitStatus() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderSubmitStatus_get(swigCPtr, this);
  }

  public void setNotifySequence(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_NotifySequence_set(swigCPtr, this, value);
  }

  public int getNotifySequence() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_NotifySequence_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SettlementID_get(swigCPtr, this);
  }

  public void setOrderSysID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderSysID_set(swigCPtr, this, value);
  }

  public String getOrderSysID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderSysID_get(swigCPtr, this);
  }

  public void setOrderSource(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderSource_set(swigCPtr, this, value);
  }

  public char getOrderSource() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderSource_get(swigCPtr, this);
  }

  public void setOrderStatus(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderStatus_set(swigCPtr, this, value);
  }

  public char getOrderStatus() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderStatus_get(swigCPtr, this);
  }

  public void setOrderType(char value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderType_set(swigCPtr, this, value);
  }

  public char getOrderType() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_OrderType_get(swigCPtr, this);
  }

  public void setVolumeTraded(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeTraded_set(swigCPtr, this, value);
  }

  public int getVolumeTraded() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeTraded_get(swigCPtr, this);
  }

  public void setVolumeTotal(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeTotal_set(swigCPtr, this, value);
  }

  public int getVolumeTotal() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_VolumeTotal_get(swigCPtr, this);
  }

  public void setInsertDate(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InsertDate_set(swigCPtr, this, value);
  }

  public String getInsertDate() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InsertDate_get(swigCPtr, this);
  }

  public void setInsertTime(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InsertTime_set(swigCPtr, this, value);
  }

  public String getInsertTime() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InsertTime_get(swigCPtr, this);
  }

  public void setActiveTime(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ActiveTime_set(swigCPtr, this, value);
  }

  public String getActiveTime() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ActiveTime_get(swigCPtr, this);
  }

  public void setSuspendTime(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SuspendTime_set(swigCPtr, this, value);
  }

  public String getSuspendTime() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SuspendTime_get(swigCPtr, this);
  }

  public void setUpdateTime(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UpdateTime_set(swigCPtr, this, value);
  }

  public String getUpdateTime() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UpdateTime_get(swigCPtr, this);
  }

  public void setCancelTime(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CancelTime_set(swigCPtr, this, value);
  }

  public String getCancelTime() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CancelTime_get(swigCPtr, this);
  }

  public void setActiveTraderID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ActiveTraderID_set(swigCPtr, this, value);
  }

  public String getActiveTraderID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ActiveTraderID_get(swigCPtr, this);
  }

  public void setClearingPartID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ClearingPartID_set(swigCPtr, this, value);
  }

  public String getClearingPartID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ClearingPartID_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SequenceNo_get(swigCPtr, this);
  }

  public void setFrontID(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_FrontID_set(swigCPtr, this, value);
  }

  public int getFrontID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_FrontID_get(swigCPtr, this);
  }

  public void setSessionID(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SessionID_set(swigCPtr, this, value);
  }

  public int getSessionID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_SessionID_get(swigCPtr, this);
  }

  public void setUserProductInfo(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UserProductInfo_set(swigCPtr, this, value);
  }

  public String getUserProductInfo() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UserProductInfo_get(swigCPtr, this);
  }

  public void setStatusMsg(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_StatusMsg_set(swigCPtr, this, value);
  }

  public String getStatusMsg() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_StatusMsg_get(swigCPtr, this);
  }

  public void setUserForceClose(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UserForceClose_set(swigCPtr, this, value);
  }

  public int getUserForceClose() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_UserForceClose_get(swigCPtr, this);
  }

  public void setActiveUserID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ActiveUserID_set(swigCPtr, this, value);
  }

  public String getActiveUserID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ActiveUserID_get(swigCPtr, this);
  }

  public void setBrokerOrderSeq(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BrokerOrderSeq_set(swigCPtr, this, value);
  }

  public int getBrokerOrderSeq() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BrokerOrderSeq_get(swigCPtr, this);
  }

  public void setRelativeOrderSysID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_RelativeOrderSysID_set(swigCPtr, this, value);
  }

  public String getRelativeOrderSysID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_RelativeOrderSysID_get(swigCPtr, this);
  }

  public void setZCETotalTradedVolume(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ZCETotalTradedVolume_set(swigCPtr, this, value);
  }

  public int getZCETotalTradedVolume() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_ZCETotalTradedVolume_get(swigCPtr, this);
  }

  public void setIsSwapOrder(int value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_IsSwapOrder_set(swigCPtr, this, value);
  }

  public int getIsSwapOrder() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_IsSwapOrder_get(swigCPtr, this);
  }

  public void setBranchID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BranchID_set(swigCPtr, this, value);
  }

  public String getBranchID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_BranchID_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_InvestUnitID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_AccountID_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_CurrencyID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    riskuserapiJNI.CShfeFtdcRspInvestorOrderField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return riskuserapiJNI.CShfeFtdcRspInvestorOrderField_MacAddress_get(swigCPtr, this);
  }

  public CShfeFtdcRspInvestorOrderField() {
    this(riskuserapiJNI.new_CShfeFtdcRspInvestorOrderField(), true);
  }

}
