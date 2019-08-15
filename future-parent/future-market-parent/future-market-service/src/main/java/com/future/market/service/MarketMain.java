package com.future.market.service;

import java.io.IOException;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.instrument.api.service.InstrumentService;
import com.future.market.service.ctp.MyMdSpi;
import com.future.thost.api.CThostFtdcMdApi;
import com.future.thost.api.CThostFtdcMdSpi;
import com.future.thost.util.LibLoader;

public class MarketMain {
    
    public static String BROKER_ID = System.getProperty("brokerId","9999");
    public static String USER_ID = System.getProperty("userId","105839");
    public static String PASSWORD = System.getProperty("password","caojiactp1");
    
  //行情地址
    public static String marketFront = System.getProperty("address","tcp://180.168.146.187:10110");
    /** 行情API **/
    public static CThostFtdcMdApi mdApi;
    static CThostFtdcMdSpi mdSpi;
    
    static{
        
        try {
            LibLoader.loadLib("thostmduserapi_se");
            LibLoader.loadLib("thosttraderapi_se");
            LibLoader.loadLib("libiconv");
            LibLoader.loadLib("thosttraderapi_se_wrap");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
            RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
            InstrumentService instrumentService = ctx.getBean(InstrumentService.class);
            
            mdApi = CThostFtdcMdApi.CreateFtdcMdApi("ctpdata/market/",false);
            
            mdSpi = new MyMdSpi(mdApi, template, instrumentService);
            //注册spi
            mdApi.RegisterSpi(mdSpi);
            //注册前置机地址
            mdApi.RegisterFront(marketFront);
            mdApi.Init();
            
            mdApi.Join();
            
            mdApi.Release();
    }

}
