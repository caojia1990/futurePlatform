package com.future.market.service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    public static void main(String[] args) {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-consumer.xml");
    }
}
