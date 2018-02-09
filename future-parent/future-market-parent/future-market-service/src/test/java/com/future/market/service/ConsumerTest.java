package com.future.market.service;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    public static void main(String[] args) {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-consumer.xml");
        
        TopicExchange topicExchange = (TopicExchange) ctx.getBean("com.future.market");
        RabbitAdmin admin = ctx.getBean(RabbitAdmin.class);
        Queue queue = new AnonymousQueue();
        admin.declareQueue(queue);
        admin.declareBinding(BindingBuilder.bind(queue).to(topicExchange).with("instrument.cu1804"));
        
        //设置监听
        SimpleMessageListenerContainer container = ctx.getBean(SimpleMessageListenerContainer.class);
        container.addQueueNames(queue.getName());
        
        /*container.setMessageListener(listenerAdapter);
        SimpleMessageListenerContainer listenerContainer = ctx.getBean(SimpleMessageListenerContainer.class);
        listenerContainer.addQueueNames(queue.getName());
        listenerContainer.setMessageListener(new MessageListenerAdapter(new MessageHandle(), "onMarketRsp"));*/
    }
}
