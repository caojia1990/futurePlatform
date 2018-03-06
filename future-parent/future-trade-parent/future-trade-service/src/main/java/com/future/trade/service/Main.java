package com.future.trade.service;

import org.hraink.futures.ctp.thostftdcuserapidatatype.ThostFtdcUserApiDataTypeLibrary.THOST_TE_RESUME_TYPE;
import org.hraink.futures.jctp.trader.JCTPTraderApi;
import org.hraink.futures.jctp.trader.JCTPTraderSpi;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.trade.api.service.TradeService;
import com.future.trade.service.ctp.MyTraderSpi;

public class Main {
    
    public static String BROKER_ID = "9999";
    public static String USER_ID = "105839";
    public static String PASSWORD = "caojiactp1";
    
    public static String tradeFront = "tcp://180.168.146.187:10001";
    static JCTPTraderApi traderApi;
    static JCTPTraderSpi traderSpi;
    
    public static void main(String[] args) {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
            RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
            
            traderApi = JCTPTraderApi.createFtdcTraderApi("ctpdata/trade/");
            
            traderSpi = new MyTraderSpi(traderApi,template);
            
            //注册traderpi
            traderApi.registerSpi(traderSpi);
            //注册公有流
            traderApi.subscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
            //注册私有流
            traderApi.subscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
            //注册前置机地址
            traderApi.registerFront(tradeFront);
            
            traderApi.init();
            traderApi.join();
            //回收api和JCTP
            traderApi.release();
    }

}
