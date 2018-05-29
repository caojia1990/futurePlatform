/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.thost.api;

public class CThostFtdcInvestorPositionField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcInvestorPositionField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcInvestorPositionField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcInvestorPositionField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_InstrumentID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_InvestorID_get(swigCPtr, this);
  }

  public void setPosiDirection(char value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_PosiDirection_set(swigCPtr, this, value);
  }

  public char getPosiDirection() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_PosiDirection_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_HedgeFlag_get(swigCPtr, this);
  }

  public void setPositionDate(char value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_PositionDate_set(swigCPtr, this, value);
  }

  public char getPositionDate() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_PositionDate_get(swigCPtr, this);
  }

  public void setYdPosition(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_YdPosition_set(swigCPtr, this, value);
  }

  public int getYdPosition() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_YdPosition_get(swigCPtr, this);
  }

  public void setPosition(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_Position_set(swigCPtr, this, value);
  }

  public int getPosition() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_Position_get(swigCPtr, this);
  }

  public void setLongFrozen(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_LongFrozen_set(swigCPtr, this, value);
  }

  public int getLongFrozen() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_LongFrozen_get(swigCPtr, this);
  }

  public void setShortFrozen(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_ShortFrozen_set(swigCPtr, this, value);
  }

  public int getShortFrozen() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_ShortFrozen_get(swigCPtr, this);
  }

  public void setLongFrozenAmount(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_LongFrozenAmount_set(swigCPtr, this, value);
  }

  public double getLongFrozenAmount() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_LongFrozenAmount_get(swigCPtr, this);
  }

  public void setShortFrozenAmount(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_ShortFrozenAmount_set(swigCPtr, this, value);
  }

  public double getShortFrozenAmount() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_ShortFrozenAmount_get(swigCPtr, this);
  }

  public void setOpenVolume(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_OpenVolume_set(swigCPtr, this, value);
  }

  public int getOpenVolume() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_OpenVolume_get(swigCPtr, this);
  }

  public void setCloseVolume(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseVolume_set(swigCPtr, this, value);
  }

  public int getCloseVolume() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseVolume_get(swigCPtr, this);
  }

  public void setOpenAmount(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_OpenAmount_set(swigCPtr, this, value);
  }

  public double getOpenAmount() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_OpenAmount_get(swigCPtr, this);
  }

  public void setCloseAmount(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseAmount_set(swigCPtr, this, value);
  }

  public double getCloseAmount() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseAmount_get(swigCPtr, this);
  }

  public void setPositionCost(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_PositionCost_set(swigCPtr, this, value);
  }

  public double getPositionCost() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_PositionCost_get(swigCPtr, this);
  }

  public void setPreMargin(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_PreMargin_set(swigCPtr, this, value);
  }

  public double getPreMargin() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_PreMargin_get(swigCPtr, this);
  }

  public void setUseMargin(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_UseMargin_set(swigCPtr, this, value);
  }

  public double getUseMargin() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_UseMargin_get(swigCPtr, this);
  }

  public void setFrozenMargin(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_FrozenMargin_set(swigCPtr, this, value);
  }

  public double getFrozenMargin() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_FrozenMargin_get(swigCPtr, this);
  }

  public void setFrozenCash(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_FrozenCash_set(swigCPtr, this, value);
  }

  public double getFrozenCash() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_FrozenCash_get(swigCPtr, this);
  }

  public void setFrozenCommission(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_FrozenCommission_set(swigCPtr, this, value);
  }

  public double getFrozenCommission() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_FrozenCommission_get(swigCPtr, this);
  }

  public void setCashIn(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CashIn_set(swigCPtr, this, value);
  }

  public double getCashIn() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CashIn_get(swigCPtr, this);
  }

  public void setCommission(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_Commission_set(swigCPtr, this, value);
  }

  public double getCommission() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_Commission_get(swigCPtr, this);
  }

  public void setCloseProfit(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseProfit_set(swigCPtr, this, value);
  }

  public double getCloseProfit() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseProfit_get(swigCPtr, this);
  }

  public void setPositionProfit(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_PositionProfit_set(swigCPtr, this, value);
  }

  public double getPositionProfit() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_PositionProfit_get(swigCPtr, this);
  }

  public void setPreSettlementPrice(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_PreSettlementPrice_set(swigCPtr, this, value);
  }

  public double getPreSettlementPrice() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_PreSettlementPrice_get(swigCPtr, this);
  }

  public void setSettlementPrice(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_SettlementPrice_set(swigCPtr, this, value);
  }

  public double getSettlementPrice() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_SettlementPrice_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_SettlementID_get(swigCPtr, this);
  }

  public void setOpenCost(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_OpenCost_set(swigCPtr, this, value);
  }

  public double getOpenCost() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_OpenCost_get(swigCPtr, this);
  }

  public void setExchangeMargin(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_ExchangeMargin_set(swigCPtr, this, value);
  }

  public double getExchangeMargin() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_ExchangeMargin_get(swigCPtr, this);
  }

  public void setCombPosition(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CombPosition_set(swigCPtr, this, value);
  }

  public int getCombPosition() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CombPosition_get(swigCPtr, this);
  }

  public void setCombLongFrozen(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CombLongFrozen_set(swigCPtr, this, value);
  }

  public int getCombLongFrozen() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CombLongFrozen_get(swigCPtr, this);
  }

  public void setCombShortFrozen(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CombShortFrozen_set(swigCPtr, this, value);
  }

  public int getCombShortFrozen() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CombShortFrozen_get(swigCPtr, this);
  }

  public void setCloseProfitByDate(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseProfitByDate_set(swigCPtr, this, value);
  }

  public double getCloseProfitByDate() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseProfitByDate_get(swigCPtr, this);
  }

  public void setCloseProfitByTrade(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseProfitByTrade_set(swigCPtr, this, value);
  }

  public double getCloseProfitByTrade() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_CloseProfitByTrade_get(swigCPtr, this);
  }

  public void setTodayPosition(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_TodayPosition_set(swigCPtr, this, value);
  }

  public int getTodayPosition() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_TodayPosition_get(swigCPtr, this);
  }

  public void setMarginRateByMoney(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_MarginRateByMoney_set(swigCPtr, this, value);
  }

  public double getMarginRateByMoney() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_MarginRateByMoney_get(swigCPtr, this);
  }

  public void setMarginRateByVolume(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_MarginRateByVolume_set(swigCPtr, this, value);
  }

  public double getMarginRateByVolume() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_MarginRateByVolume_get(swigCPtr, this);
  }

  public void setStrikeFrozen(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_StrikeFrozen_set(swigCPtr, this, value);
  }

  public int getStrikeFrozen() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_StrikeFrozen_get(swigCPtr, this);
  }

  public void setStrikeFrozenAmount(double value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_StrikeFrozenAmount_set(swigCPtr, this, value);
  }

  public double getStrikeFrozenAmount() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_StrikeFrozenAmount_get(swigCPtr, this);
  }

  public void setAbandonFrozen(int value) {
    thosttradeapiJNI.CThostFtdcInvestorPositionField_AbandonFrozen_set(swigCPtr, this, value);
  }

  public int getAbandonFrozen() {
    return thosttradeapiJNI.CThostFtdcInvestorPositionField_AbandonFrozen_get(swigCPtr, this);
  }

  public CThostFtdcInvestorPositionField() {
    this(thosttradeapiJNI.new_CThostFtdcInvestorPositionField(), true);
  }

}
