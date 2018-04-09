package com.future.client;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientStarter {
    
    public static String INVESTOR_ID = "001";
    
    public static void main(String[] args) {
        
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        
        TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.market");
        Queue marketQ = (Queue) context.getBean("marketQ");
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cu1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.rb1810"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.al1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ru1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.zn1806"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.au1806"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ag1806"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.pb1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ni1807"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.sn1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.j1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.jm1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ZC805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.hc1810"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.i1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SF805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SM805"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.FG805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.sc1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.l1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.TA809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.MA805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.bu1806"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.a1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.c1809"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.WH805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.m1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.RM809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.y1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.OI809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.p1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.CF809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SR809"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.CY809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.jd1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cs1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.AP805"));
        
        Queue onRtnOrderQ = (Queue) context.getBean("onRtnOrderQ");
        TopicExchange onRtnOrderExchange = (TopicExchange) context.getBean("onRtnOrderExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with(INVESTOR_ID));
        Queue onRtnTradeQ = (Queue) context.getBean("onRtnTradeQ");
        TopicExchange onRtnTradeExchange = (TopicExchange) context.getBean("onRtnTradeExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnTradeQ).to(onRtnTradeExchange).with(INVESTOR_ID));
        
    }

}
