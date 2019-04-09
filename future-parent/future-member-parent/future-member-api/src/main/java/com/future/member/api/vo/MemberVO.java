package com.future.member.api.vo;

import java.util.Date;

/**
 * 投资者实体类
 * @author caojia
 *
 */
public class MemberVO {

    /**
     * 客户编号
     */
    private String investorNo;
    
    /**
     * 客户名称
     */
    private String investorName;
    
    
    /**
     * 凭证
     */
    private String passwd;
    
    /**
     * 手机号
     */
    private String mobilePhone;
    
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Date birthday;
    
    /**
     * 身份证号
     */
    private String idCard;

    /**
     * @return 客户编号
     */
    public String getInvestorNo() {
        return investorNo;
    }

    public void setInvestorNo(String investorNo) {
        this.investorNo = investorNo;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
