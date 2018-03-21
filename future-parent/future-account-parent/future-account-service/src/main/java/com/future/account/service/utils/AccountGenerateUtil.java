package com.future.account.service.utils;

import java.text.NumberFormat;
import java.time.LocalDate;

public class AccountGenerateUtil {
    
    /**
     * 客户号取模
     */
    private final static int ACCOUNT_MOD = 1024;
    
    /**
     * 年取模
     */
    private final static int YEAR_MOD = 16;
	
    /**
     * 生成16位账户编号   5位客户号取余+3位年份取模+2位年份取余+3位天数+3位序列
     * @param investorID 投资者编号
     * @param suffix 3位后缀
     * @return
     */
    public static String generateAccountNo(String investorID, Long suffix){
		StringBuilder sb = new StringBuilder();
		
		
		//8位客户号
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setGroupingUsed(false);
        //5位客户余数
        formatter.setMinimumIntegerDigits(5);
        sb.append(formatter.format(Integer.parseInt(investorID)%ACCOUNT_MOD));
        
        LocalDate now = LocalDate.now();
        //3位年份余数
        formatter.setMinimumIntegerDigits(3);
        sb.append(formatter.format(now.getYear()/YEAR_MOD));
        //2位年份余数
        formatter.setMinimumIntegerDigits(2);
        sb.append(formatter.format(now.getYear()%YEAR_MOD));
        //3位天数
        formatter.setMinimumIntegerDigits(3);
        sb.append(formatter.format(now.getDayOfYear()));
        //3位序列号
        sb.append(formatter.format(suffix));
        
		return sb.toString();
	}
    
    public static void main(String[] args) {
        System.out.println(AccountGenerateUtil.generateAccountNo("34080001", 001L));
    }

}
