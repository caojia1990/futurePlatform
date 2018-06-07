package com.future.order.service;

import java.io.IOException;


public class OrderMain {
    
    
    public static void main(String[] args) throws IOException {
        
        /*AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();*/
        com.alibaba.dubbo.container.Main.main(args);
    }

}
