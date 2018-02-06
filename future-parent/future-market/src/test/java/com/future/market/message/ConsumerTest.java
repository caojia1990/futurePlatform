package com.future.market.message;

import java.io.IOException;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    
    public static void main(String[] args) throws IOException {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-consumer.xml");
        
        System.in.read();
    }

    
}
