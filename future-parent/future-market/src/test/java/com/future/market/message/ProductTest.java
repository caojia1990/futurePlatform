package com.future.market.message;

import java.util.Scanner;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductTest {
    
    public static void main(String[] args) {
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-product.xml");
            RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
            template.convertAndSend("Hello, world!");
            
            while(true) {
                Scanner sc=new Scanner(System.in);  
                String s=sc.next();
                if (s.equals("bye")) {
                    break;
                }
                template.convertAndSend(s);
            }
    }

}
