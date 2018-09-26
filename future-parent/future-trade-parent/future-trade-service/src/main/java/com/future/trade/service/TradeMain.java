package com.future.trade.service;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.instrument.api.service.InstrumentService;
import com.future.thost.api.CThostFtdcTraderApi;
import com.future.thost.api.CThostFtdcTraderSpi;
import com.future.thost.api.THOST_TE_RESUME_TYPE;
import com.future.thost.util.LibLoader;
import com.future.trade.service.ctp.MyTraderSpi;

public class TradeMain {
    
    public static String BROKER_ID = System.getProperty("brokerId","9999");
    public static String USER_ID = System.getProperty("userId","105839");
    public static String PASSWORD = System.getProperty("password","caojiactp1");
    
    public static String tradeFront = System.getProperty("address","tcp://180.168.146.187:10001");
    public static CThostFtdcTraderApi traderApi;
    static CThostFtdcTraderSpi traderSpi;
    
    static{
        
        try {
            LibLoader.loadLib("thostmduserapi");
            LibLoader.loadLib("thosttraderapi");
            LibLoader.loadLib("thosttraderapi_wrap");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
            RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
            InstrumentService instrumentService = (InstrumentService) ctx.getBean("instrumentService");
            
            traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi("ctpdata/trade/");
            
            traderSpi = new MyTraderSpi(traderApi,template,instrumentService);
            
            //注册traderpi
            traderApi.RegisterSpi(traderSpi);
            //注册前置机地址
            traderApi.RegisterFront(tradeFront);
            //注册公有流
            traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
            //注册私有流
            traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
            
            traderApi.Init();
            traderApi.Join();
            //回收api和JCTP
            return;
            //traderApi.Release();
    }

}
