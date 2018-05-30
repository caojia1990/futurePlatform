package com.future.trade.service.test;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

public class CommonTest {

    public static void main(String[] args) {
        
        Properties properties = System.getProperties();  
        Iterator it =  properties.entrySet().iterator();  
        while(it.hasNext())  
        {  
            Entry entry = (Entry)it.next();  
            System.out.print(entry.getKey()+"=");  
            System.out.println(entry.getValue());  
        }
        
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
