package com.future.account.service;

import java.text.NumberFormat;
import java.time.LocalDate;

public class CommonTest {
    
    public static void main(String[] args) {
        
        
        LocalDate date = LocalDate.now();
        
        
        System.out.println(date.getYear()/64);
        System.out.println(date.getYear()%64);
        
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setGroupingUsed(false);
        
        StringBuffer sb = new StringBuffer();
        formatter.setMinimumIntegerDigits(2);
        sb.append(formatter.format(date.getYear()%64));
        formatter.setMinimumIntegerDigits(3);
        sb.append(formatter.format(date.getDayOfYear()));
        
        System.out.println(sb.toString());
        
    }

}
