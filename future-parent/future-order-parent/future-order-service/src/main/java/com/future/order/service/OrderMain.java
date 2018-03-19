package com.future.order.service;

import java.io.IOException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderMain {
    
    
    public static void main(String[] args) throws IOException {
        
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        
        System.in.read();
    }

}
