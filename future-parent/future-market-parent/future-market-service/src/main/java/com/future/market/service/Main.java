package com.future.market.service;

import org.hraink.futures.jctp.md.JCTPMdApi;
import org.hraink.futures.jctp.md.JCTPMdSpi;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    public static String BROKER_ID = "9999";
    public static String USER_ID = "105839";
    public static String PASSWORD = "caojiactp1";
    
  //行情地址
    public static String marketFront = "tcp://180.168.146.187:10010";
    /** 行情API **/
    public static JCTPMdApi mdApi;
    static JCTPMdSpi mdSpi;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-product.xml");
            RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
            
            while(true){
                try {
                    Thread.sleep(10);
                    template.convertAndSend("hello world!");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
    }

}
