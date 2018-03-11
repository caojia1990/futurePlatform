package com.future.instrument.service;

import java.io.IOException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstrumentMain {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        
        System.in.read();
    }

}
