/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.future.risk.api;

public class CShfeFtdcInvestorLinkManField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CShfeFtdcInvestorLinkManField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CShfeFtdcInvestorLinkManField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        riskuserapiJNI.delete_CShfeFtdcInvestorLinkManField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInvestorID(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorGroupID(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorGroupID_set(swigCPtr, this, value);
  }

  public String getInvestorGroupID() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorGroupID_get(swigCPtr, this);
  }

  public void setInvestorName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorName_set(swigCPtr, this, value);
  }

  public String getInvestorName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorName_get(swigCPtr, this);
  }

  public void setIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_IdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_IdentifiedCardType_get(swigCPtr, this);
  }

  public void setIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_IdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_IdentifiedCardNo_get(swigCPtr, this);
  }

  public void setIsActive(int value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_IsActive_set(swigCPtr, this, value);
  }

  public int getIsActive() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_IsActive_get(swigCPtr, this);
  }

  public void setTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_Telephone_set(swigCPtr, this, value);
  }

  public String getTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_Telephone_get(swigCPtr, this);
  }

  public void setAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_Address_set(swigCPtr, this, value);
  }

  public String getAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_Address_get(swigCPtr, this);
  }

  public void setOrderManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getOrderManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setOrderManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getOrderManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setOrderManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManPersonName_set(swigCPtr, this, value);
  }

  public String getOrderManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManPersonName_get(swigCPtr, this);
  }

  public void setOrderManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManTelephone_set(swigCPtr, this, value);
  }

  public String getOrderManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManTelephone_get(swigCPtr, this);
  }

  public void setOrderManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManAddress_set(swigCPtr, this, value);
  }

  public String getOrderManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManAddress_get(swigCPtr, this);
  }

  public void setOrderManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManZipCode_set(swigCPtr, this, value);
  }

  public String getOrderManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderManZipCode_get(swigCPtr, this);
  }

  public void setFundManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getFundManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setFundManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getFundManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setFundManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManPersonName_set(swigCPtr, this, value);
  }

  public String getFundManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManPersonName_get(swigCPtr, this);
  }

  public void setFundManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManTelephone_set(swigCPtr, this, value);
  }

  public String getFundManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManTelephone_get(swigCPtr, this);
  }

  public void setFundManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManAddress_set(swigCPtr, this, value);
  }

  public String getFundManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManAddress_get(swigCPtr, this);
  }

  public void setFundManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManZipCode_set(swigCPtr, this, value);
  }

  public String getFundManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundManZipCode_get(swigCPtr, this);
  }

  public void setOpenManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getOpenManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setOpenManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getOpenManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setOpenManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManPersonName_set(swigCPtr, this, value);
  }

  public String getOpenManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManPersonName_get(swigCPtr, this);
  }

  public void setOpenManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManTelephone_set(swigCPtr, this, value);
  }

  public String getOpenManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManTelephone_get(swigCPtr, this);
  }

  public void setOpenManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManAddress_set(swigCPtr, this, value);
  }

  public String getOpenManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManAddress_get(swigCPtr, this);
  }

  public void setOpenManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManZipCode_set(swigCPtr, this, value);
  }

  public String getOpenManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenManZipCode_get(swigCPtr, this);
  }

  public void setSettlementManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getSettlementManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setSettlementManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getSettlementManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setSettlementManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManPersonName_set(swigCPtr, this, value);
  }

  public String getSettlementManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManPersonName_get(swigCPtr, this);
  }

  public void setSettlementManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManTelephone_set(swigCPtr, this, value);
  }

  public String getSettlementManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManTelephone_get(swigCPtr, this);
  }

  public void setSettlementManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManAddress_set(swigCPtr, this, value);
  }

  public String getSettlementManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManAddress_get(swigCPtr, this);
  }

  public void setSettlementManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManZipCode_set(swigCPtr, this, value);
  }

  public String getSettlementManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlementManZipCode_get(swigCPtr, this);
  }

  public void setOpenDate(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenDate_set(swigCPtr, this, value);
  }

  public String getOpenDate() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenDate_get(swigCPtr, this);
  }

  public void setMobile(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_Mobile_set(swigCPtr, this, value);
  }

  public String getMobile() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_Mobile_get(swigCPtr, this);
  }

  public void setEMail(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_EMail_set(swigCPtr, this, value);
  }

  public String getEMail() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_EMail_get(swigCPtr, this);
  }

  public void setInvestorType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorType_set(swigCPtr, this, value);
  }

  public char getInvestorType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_InvestorType_get(swigCPtr, this);
  }

  public void setPhoneCountryCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_PhoneCountryCode_set(swigCPtr, this, value);
  }

  public String getPhoneCountryCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_PhoneCountryCode_get(swigCPtr, this);
  }

  public void setPhoneAreaCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_PhoneAreaCode_set(swigCPtr, this, value);
  }

  public String getPhoneAreaCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_PhoneAreaCode_get(swigCPtr, this);
  }

  public void setOpenPhoneCountryCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenPhoneCountryCode_set(swigCPtr, this, value);
  }

  public String getOpenPhoneCountryCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenPhoneCountryCode_get(swigCPtr, this);
  }

  public void setOpenPhoneAreaCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenPhoneAreaCode_set(swigCPtr, this, value);
  }

  public String getOpenPhoneAreaCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OpenPhoneAreaCode_get(swigCPtr, this);
  }

  public void setOrderPhoneCountryCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderPhoneCountryCode_set(swigCPtr, this, value);
  }

  public String getOrderPhoneCountryCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderPhoneCountryCode_get(swigCPtr, this);
  }

  public void setOrderPhoneAreaCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderPhoneAreaCode_set(swigCPtr, this, value);
  }

  public String getOrderPhoneAreaCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_OrderPhoneAreaCode_get(swigCPtr, this);
  }

  public void setFundPhoneCountryCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundPhoneCountryCode_set(swigCPtr, this, value);
  }

  public String getFundPhoneCountryCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundPhoneCountryCode_get(swigCPtr, this);
  }

  public void setFundPhoneAreaCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundPhoneAreaCode_set(swigCPtr, this, value);
  }

  public String getFundPhoneAreaCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_FundPhoneAreaCode_get(swigCPtr, this);
  }

  public void setSettlePhoneCountryCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlePhoneCountryCode_set(swigCPtr, this, value);
  }

  public String getSettlePhoneCountryCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlePhoneCountryCode_get(swigCPtr, this);
  }

  public void setSettlePhoneAreaCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlePhoneAreaCode_set(swigCPtr, this, value);
  }

  public String getSettlePhoneAreaCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_SettlePhoneAreaCode_get(swigCPtr, this);
  }

  public void setCompanyManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getCompanyManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setCompanyManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getCompanyManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setCompanyManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManPersonName_set(swigCPtr, this, value);
  }

  public String getCompanyManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManPersonName_get(swigCPtr, this);
  }

  public void setCompanyManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManTelephone_set(swigCPtr, this, value);
  }

  public String getCompanyManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManTelephone_get(swigCPtr, this);
  }

  public void setCompanyManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManAddress_set(swigCPtr, this, value);
  }

  public String getCompanyManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManAddress_get(swigCPtr, this);
  }

  public void setCompanyManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManZipCode_set(swigCPtr, this, value);
  }

  public String getCompanyManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CompanyManZipCode_get(swigCPtr, this);
  }

  public void setCorporationManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getCorporationManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setCorporationManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getCorporationManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setCorporationManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManPersonName_set(swigCPtr, this, value);
  }

  public String getCorporationManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManPersonName_get(swigCPtr, this);
  }

  public void setCorporationManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManTelephone_set(swigCPtr, this, value);
  }

  public String getCorporationManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManTelephone_get(swigCPtr, this);
  }

  public void setCorporationManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManAddress_set(swigCPtr, this, value);
  }

  public String getCorporationManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManAddress_get(swigCPtr, this);
  }

  public void setCorporationManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManZipCode_set(swigCPtr, this, value);
  }

  public String getCorporationManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_CorporationManZipCode_get(swigCPtr, this);
  }

  public void setLinkManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getLinkManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setLinkManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getLinkManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setLinkManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManPersonName_set(swigCPtr, this, value);
  }

  public String getLinkManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManPersonName_get(swigCPtr, this);
  }

  public void setLinkManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManTelephone_set(swigCPtr, this, value);
  }

  public String getLinkManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManTelephone_get(swigCPtr, this);
  }

  public void setLinkManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManAddress_set(swigCPtr, this, value);
  }

  public String getLinkManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManAddress_get(swigCPtr, this);
  }

  public void setLinkManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManZipCode_set(swigCPtr, this, value);
  }

  public String getLinkManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LinkManZipCode_get(swigCPtr, this);
  }

  public void setLedgerIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getLedgerIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerIdentifiedCardType_get(swigCPtr, this);
  }

  public void setLedgerIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getLedgerIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setLedgerPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerPersonName_set(swigCPtr, this, value);
  }

  public String getLedgerPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerPersonName_get(swigCPtr, this);
  }

  public void setLedgerTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerTelephone_set(swigCPtr, this, value);
  }

  public String getLedgerTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerTelephone_get(swigCPtr, this);
  }

  public void setLedgerAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerAddress_set(swigCPtr, this, value);
  }

  public String getLedgerAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerAddress_get(swigCPtr, this);
  }

  public void setLedgerZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerZipCode_set(swigCPtr, this, value);
  }

  public String getLedgerZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_LedgerZipCode_get(swigCPtr, this);
  }

  public void setTrusteeIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getTrusteeIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeIdentifiedCardType_get(swigCPtr, this);
  }

  public void setTrusteeIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getTrusteeIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setTrusteePersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteePersonName_set(swigCPtr, this, value);
  }

  public String getTrusteePersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteePersonName_get(swigCPtr, this);
  }

  public void setTrusteeTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeTelephone_set(swigCPtr, this, value);
  }

  public String getTrusteeTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeTelephone_get(swigCPtr, this);
  }

  public void setTrusteeAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeAddress_set(swigCPtr, this, value);
  }

  public String getTrusteeAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeAddress_get(swigCPtr, this);
  }

  public void setTrusteeZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeZipCode_set(swigCPtr, this, value);
  }

  public String getTrusteeZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeZipCode_get(swigCPtr, this);
  }

  public void setTrusteeCorporationManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getTrusteeCorporationManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setTrusteeCorporationManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getTrusteeCorporationManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setTrusteeCorporationManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManPersonName_set(swigCPtr, this, value);
  }

  public String getTrusteeCorporationManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManPersonName_get(swigCPtr, this);
  }

  public void setTrusteeCorporationManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManTelephone_set(swigCPtr, this, value);
  }

  public String getTrusteeCorporationManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManTelephone_get(swigCPtr, this);
  }

  public void setTrusteeCorporationManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManAddress_set(swigCPtr, this, value);
  }

  public String getTrusteeCorporationManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManAddress_get(swigCPtr, this);
  }

  public void setTrusteeCorporationManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManZipCode_set(swigCPtr, this, value);
  }

  public String getTrusteeCorporationManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeCorporationManZipCode_get(swigCPtr, this);
  }

  public void setTrusteeOpenManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getTrusteeOpenManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setTrusteeOpenManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getTrusteeOpenManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setTrusteeOpenManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManPersonName_set(swigCPtr, this, value);
  }

  public String getTrusteeOpenManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManPersonName_get(swigCPtr, this);
  }

  public void setTrusteeOpenManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManTelephone_set(swigCPtr, this, value);
  }

  public String getTrusteeOpenManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManTelephone_get(swigCPtr, this);
  }

  public void setTrusteeOpenManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManAddress_set(swigCPtr, this, value);
  }

  public String getTrusteeOpenManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManAddress_get(swigCPtr, this);
  }

  public void setTrusteeOpenManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManZipCode_set(swigCPtr, this, value);
  }

  public String getTrusteeOpenManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeOpenManZipCode_get(swigCPtr, this);
  }

  public void setTrusteeContactManIdentifiedCardType(char value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManIdentifiedCardType_set(swigCPtr, this, value);
  }

  public char getTrusteeContactManIdentifiedCardType() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManIdentifiedCardType_get(swigCPtr, this);
  }

  public void setTrusteeContactManIdentifiedCardNo(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManIdentifiedCardNo_set(swigCPtr, this, value);
  }

  public String getTrusteeContactManIdentifiedCardNo() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManIdentifiedCardNo_get(swigCPtr, this);
  }

  public void setTrusteeContactManPersonName(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManPersonName_set(swigCPtr, this, value);
  }

  public String getTrusteeContactManPersonName() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManPersonName_get(swigCPtr, this);
  }

  public void setTrusteeContactManTelephone(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManTelephone_set(swigCPtr, this, value);
  }

  public String getTrusteeContactManTelephone() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManTelephone_get(swigCPtr, this);
  }

  public void setTrusteeContactManAddress(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManAddress_set(swigCPtr, this, value);
  }

  public String getTrusteeContactManAddress() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManAddress_get(swigCPtr, this);
  }

  public void setTrusteeContactManZipCode(String value) {
    riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManZipCode_set(swigCPtr, this, value);
  }

  public String getTrusteeContactManZipCode() {
    return riskuserapiJNI.CShfeFtdcInvestorLinkManField_TrusteeContactManZipCode_get(swigCPtr, this);
  }

  public CShfeFtdcInvestorLinkManField() {
    this(riskuserapiJNI.new_CShfeFtdcInvestorLinkManField(), true);
  }

}
