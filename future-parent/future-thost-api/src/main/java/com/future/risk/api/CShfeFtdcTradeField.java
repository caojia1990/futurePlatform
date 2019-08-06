/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcTradeField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcTradeField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcTradeField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcTradeField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcTradeField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcTradeField_InvestorID_get(swigCPtr, this);
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcTradeField_InstrumentID_get(swigCPtr, this);
  }

  public void setOrderRef(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_OrderRef_set(swigCPtr, this, value);
  }

  public String getOrderRef() {
    return riskuserapiJNI.CShfeFtdcTradeField_OrderRef_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return riskuserapiJNI.CShfeFtdcTradeField_UserID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return riskuserapiJNI.CShfeFtdcTradeField_ExchangeID_get(swigCPtr, this);
  }

  public void setTradeID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradeID_set(swigCPtr, this, value);
  }

  public String getTradeID() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradeID_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return riskuserapiJNI.CShfeFtdcTradeField_Direction_get(swigCPtr, this);
  }

  public void setOrderSysID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_OrderSysID_set(swigCPtr, this, value);
  }

  public String getOrderSysID() {
    return riskuserapiJNI.CShfeFtdcTradeField_OrderSysID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return riskuserapiJNI.CShfeFtdcTradeField_ParticipantID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return riskuserapiJNI.CShfeFtdcTradeField_ClientID_get(swigCPtr, this);
  }

  public void setTradingRole(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradingRole_set(swigCPtr, this, value);
  }

  public char getTradingRole() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradingRole_get(swigCPtr, this);
  }

  public void setExchangeInstID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_ExchangeInstID_set(swigCPtr, this, value);
  }

  public String getExchangeInstID() {
    return riskuserapiJNI.CShfeFtdcTradeField_ExchangeInstID_get(swigCPtr, this);
  }

  public void setOffsetFlag(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_OffsetFlag_set(swigCPtr, this, value);
  }

  public char getOffsetFlag() {
    return riskuserapiJNI.CShfeFtdcTradeField_OffsetFlag_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return riskuserapiJNI.CShfeFtdcTradeField_HedgeFlag_get(swigCPtr, this);
  }

  public void setPrice(double value) {
    riskuserapiJNI.CShfeFtdcTradeField_Price_set(swigCPtr, this, value);
  }

  public double getPrice() {
    return riskuserapiJNI.CShfeFtdcTradeField_Price_get(swigCPtr, this);
  }

  public void setVolume(int value) {
    riskuserapiJNI.CShfeFtdcTradeField_Volume_set(swigCPtr, this, value);
  }

  public int getVolume() {
    return riskuserapiJNI.CShfeFtdcTradeField_Volume_get(swigCPtr, this);
  }

  public void setTradeDate(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradeDate_set(swigCPtr, this, value);
  }

  public String getTradeDate() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradeDate_get(swigCPtr, this);
  }

  public void setTradeTime(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradeTime_set(swigCPtr, this, value);
  }

  public String getTradeTime() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradeTime_get(swigCPtr, this);
  }

  public void setTradeType(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradeType_set(swigCPtr, this, value);
  }

  public char getTradeType() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradeType_get(swigCPtr, this);
  }

  public void setPriceSource(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_PriceSource_set(swigCPtr, this, value);
  }

  public char getPriceSource() {
    return riskuserapiJNI.CShfeFtdcTradeField_PriceSource_get(swigCPtr, this);
  }

  public void setTraderID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_TraderID_set(swigCPtr, this, value);
  }

  public String getTraderID() {
    return riskuserapiJNI.CShfeFtdcTradeField_TraderID_get(swigCPtr, this);
  }

  public void setOrderLocalID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_OrderLocalID_set(swigCPtr, this, value);
  }

  public String getOrderLocalID() {
    return riskuserapiJNI.CShfeFtdcTradeField_OrderLocalID_get(swigCPtr, this);
  }

  public void setClearingPartID(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_ClearingPartID_set(swigCPtr, this, value);
  }

  public String getClearingPartID() {
    return riskuserapiJNI.CShfeFtdcTradeField_ClearingPartID_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return riskuserapiJNI.CShfeFtdcTradeField_BusinessUnit_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    riskuserapiJNI.CShfeFtdcTradeField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return riskuserapiJNI.CShfeFtdcTradeField_SequenceNo_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    riskuserapiJNI.CShfeFtdcTradeField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return riskuserapiJNI.CShfeFtdcTradeField_SettlementID_get(swigCPtr, this);
  }

  public void setBrokerOrderSeq(int value) {
    riskuserapiJNI.CShfeFtdcTradeField_BrokerOrderSeq_set(swigCPtr, this, value);
  }

  public int getBrokerOrderSeq() {
    return riskuserapiJNI.CShfeFtdcTradeField_BrokerOrderSeq_get(swigCPtr, this);
  }

  public void setTradeSource(char value) {
    riskuserapiJNI.CShfeFtdcTradeField_TradeSource_set(swigCPtr, this, value);
  }

  public char getTradeSource() {
    return riskuserapiJNI.CShfeFtdcTradeField_TradeSource_get(swigCPtr, this);
  }

  public CShfeFtdcTradeField() {
    this(riskuserapiJNI.new_CShfeFtdcTradeField(), true);
  }

}
