package com.future.market.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    public static void main(String[] args) throws IOException {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-consumer.xml");
        
        TopicExchange topicExchange = (TopicExchange) ctx.getBean("com.future.market");
        Queue marketQ = ctx.getBean(Queue.class);
        RabbitAdmin admin = ctx.getBean(RabbitAdmin.class);
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.cu1804"));
        
        //设置监听
        
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument."+inputStr));
        }
        
        /*container.setMessageListener(listenerAdapter);
        SimpleMessageListenerContainer listenerContainer = ctx.getBean(SimpleMessageListenerContainer.class);
        listenerContainer.addQueueNames(queue.getName());
        listenerContainer.setMessageListener(new MessageListenerAdapter(new MessageHandle(), "onMarketRsp"));*/
    }
}
