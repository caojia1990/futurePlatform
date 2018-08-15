package com.future.quota.service;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.quota.service.handle.MaHandle;

public class QuotaStarter {
    
    public static void main(String[] args) {
        
        
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        
        TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.market");
        Queue marketQ = (Queue) context.getBean("marketQ");
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        //admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cu1806"));
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.*"));
        
        MaHandle.START(context);
    }

}
