package com.future.market.service;

import org.hraink.futures.jctp.md.JCTPMdApi;
import org.hraink.futures.jctp.md.JCTPMdSpi;
import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.instrument.api.service.InstrumentService;
import com.future.market.service.ctp.MyMdSpi;

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
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
            RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
            InstrumentService instrumentService = ctx.getBean(InstrumentService.class);
            
            mdApi = JCTPMdApi.createFtdcTraderApi("ctpdata/market/",false);
            
            mdSpi = new MyMdSpi(mdApi, template, instrumentService);
            //注册spi
            mdApi.registerSpi(mdSpi);
            //注册前置机地址
            mdApi.registerFront(marketFront);
            mdApi.Init();
            
            mdApi.Join();
            
            mdApi.Release();
    }

}
