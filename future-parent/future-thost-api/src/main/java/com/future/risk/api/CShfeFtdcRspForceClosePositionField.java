/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcRspForceClosePositionField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcRspForceClosePositionField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcRspForceClosePositionField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcRspForceClosePositionField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_InstrumentID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_InvestorID_get(swigCPtr, this);
  }

  public void setPosiDirection(char value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PosiDirection_set(swigCPtr, this, value);
  }

  public char getPosiDirection() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PosiDirection_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_HedgeFlag_get(swigCPtr, this);
  }

  public void setPositionDate(char value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PositionDate_set(swigCPtr, this, value);
  }

  public char getPositionDate() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PositionDate_get(swigCPtr, this);
  }

  public void setPosition(int value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_Position_set(swigCPtr, this, value);
  }

  public int getPosition() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_Position_get(swigCPtr, this);
  }

  public void setFCPosition(int value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCPosition_set(swigCPtr, this, value);
  }

  public int getFCPosition() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCPosition_get(swigCPtr, this);
  }

  public void setFCPriceType(char value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCPriceType_set(swigCPtr, this, value);
  }

  public char getFCPriceType() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCPriceType_get(swigCPtr, this);
  }

  public void setPriceTick(int value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PriceTick_set(swigCPtr, this, value);
  }

  public int getPriceTick() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PriceTick_get(swigCPtr, this);
  }

  public void setFCPrice(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCPrice_set(swigCPtr, this, value);
  }

  public double getFCPrice() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCPrice_get(swigCPtr, this);
  }

  public void setReleaseMargin(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_ReleaseMargin_set(swigCPtr, this, value);
  }

  public double getReleaseMargin() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_ReleaseMargin_get(swigCPtr, this);
  }

  public void setCloseProfit(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_CloseProfit_set(swigCPtr, this, value);
  }

  public double getCloseProfit() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_CloseProfit_get(swigCPtr, this);
  }

  public void setFCID(String value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCID_set(swigCPtr, this, value);
  }

  public String getFCID() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_FCID_get(swigCPtr, this);
  }

  public void setTime(String value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_Time_set(swigCPtr, this, value);
  }

  public String getTime() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_Time_get(swigCPtr, this);
  }

  public void setCurrMillisec(int value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_CurrMillisec_set(swigCPtr, this, value);
  }

  public int getCurrMillisec() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_CurrMillisec_get(swigCPtr, this);
  }

  public void setExchReleaseMargin(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_ExchReleaseMargin_set(swigCPtr, this, value);
  }

  public double getExchReleaseMargin() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_ExchReleaseMargin_get(swigCPtr, this);
  }

  public void setPosiProfit(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PosiProfit_set(swigCPtr, this, value);
  }

  public double getPosiProfit() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_PosiProfit_get(swigCPtr, this);
  }

  public void setCashIn(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_CashIn_set(swigCPtr, this, value);
  }

  public double getCashIn() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_CashIn_get(swigCPtr, this);
  }

  public void setOptionValue(double value) {
    riskuserapiJNI.CShfeFtdcRspForceClosePositionField_OptionValue_set(swigCPtr, this, value);
  }

  public double getOptionValue() {
    return riskuserapiJNI.CShfeFtdcRspForceClosePositionField_OptionValue_get(swigCPtr, this);
  }

  public CShfeFtdcRspForceClosePositionField() {
    this(riskuserapiJNI.new_CShfeFtdcRspForceClosePositionField(), true);
  }

}
