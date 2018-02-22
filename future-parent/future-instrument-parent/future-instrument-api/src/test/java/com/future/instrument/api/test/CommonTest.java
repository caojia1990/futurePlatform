package com.future.instrument.api.test;

import com.future.instrument.api.vo.ExchangeName;

public class CommonTest {
    
    public static void main(String[] args) {
        
        if(ExchangeName.SHFE.toString().equals("SHFE")){
            System.out.println(ExchangeName.SHFE);
        }
        
        
    }

}
