package com.future.client;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.client.strategy.PriceFollow;

public class ClientStarter {
    
    public static String INVESTOR_ID = "001";
    
    public static void main(String[] args) {
        
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        
        TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.market");
        Queue marketQ = (Queue) context.getBean("marketQ");
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cu1808"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.rb1810"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.al1807"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ru1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.zn1807"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.j1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.jm1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.ZC809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.hc1810"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.i1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.l1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.TA809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.MA809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.bu1812"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.c1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.m1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.RM809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.y1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.OI809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.p1809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.CF810"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.SR809"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cs1809"));
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.AP810"));
        
        Queue onRtnOrderQ = (Queue) context.getBean("onRtnOrderQ");
        TopicExchange onRtnOrderExchange = (TopicExchange) context.getBean("onRtnOrderExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with(INVESTOR_ID));
        Queue onRtnTradeQ = (Queue) context.getBean("onRtnTradeQ");
        TopicExchange onRtnTradeExchange = (TopicExchange) context.getBean("onRtnTradeExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnTradeQ).to(onRtnTradeExchange).with(INVESTOR_ID));
        
        //PriceFollow.START();
    }

}
