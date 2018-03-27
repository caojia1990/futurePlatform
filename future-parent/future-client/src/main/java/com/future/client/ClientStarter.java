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
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.rb1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.m1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.al1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ru1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.zn1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.au1806"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ag1806"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.pb1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ni1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.sn1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.j1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.jm1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ZC805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.hc1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.i1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SF805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SM805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.FG805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.sc1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ru1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.l1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.MA805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.bu1806"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.a1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.c1807"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.WH805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.m1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.c1807"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.RM805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.y1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.OI805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.p1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.CF805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SR805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.CY805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.jd1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cs1805"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.AP805"));
        
        Queue onRtnOrderQ = (Queue) context.getBean("onRtnOrderQ");
        TopicExchange onRtnOrderExchange = (TopicExchange) context.getBean("onRtnOrderExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with(INVESTOR_ID));
        Queue onRtnTradeQ = (Queue) context.getBean("onRtnTradeQ");
        TopicExchange onRtnTradeExchange = (TopicExchange) context.getBean("onRtnTradeExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnTradeQ).to(onRtnTradeExchange).with(INVESTOR_ID));
        
    }

}
