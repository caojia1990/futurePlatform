package com.future.client;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EMAStarter {
    
    public static String INVESTOR_ID = "001";
    
    public static void main(String[] args) {
        
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        
        TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.quota");
        Queue quotaQ = (Queue) context.getBean("quotaQ");
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        admin.declareBinding(BindingBuilder.bind(quotaQ).to(topicExchange).with("quota.*.EMA.5m"));
        
        Queue onRtnOrderQ = (Queue) context.getBean("onRtnOrderQ");
        TopicExchange onRtnOrderExchange = (TopicExchange) context.getBean("onRtnOrderExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with(INVESTOR_ID));
        Queue onRtnTradeQ = (Queue) context.getBean("onRtnTradeQ");
        TopicExchange onRtnTradeExchange = (TopicExchange) context.getBean("onRtnTradeExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnTradeQ).to(onRtnTradeExchange).with(INVESTOR_ID));
        
    }

}
