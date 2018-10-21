package com.future.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;

public class Test {

    int i;
    
    public static void main(String[] args) throws ParseException {
        
       
    	
    	BigDecimal diff = new BigDecimal("12720")
        .subtract(new BigDecimal("12720").subtract(new BigDecimal("12235"))
                        .multiply(new BigDecimal("0.4"))).setScale(2, RoundingMode.HALF_UP);
        
        System.out.println(diff);
    }
}
