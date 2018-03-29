package com.future.client;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.instrument.api.service.InstrumentService;

public class MarketConsumer {
    
    
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext-test.xml");
        
        context.start();
        
        InstrumentService instrumentService = (InstrumentService) context.getBean("instrumentService");
        TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.market");
        Queue marketQ = (Queue) context.getBean("marketQ");
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        
        List<String> instrumentIDs = instrumentService.queryInstrumentName();
        for (String string : instrumentIDs) {
            admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument."+string));
        }
        
        
    }

}
