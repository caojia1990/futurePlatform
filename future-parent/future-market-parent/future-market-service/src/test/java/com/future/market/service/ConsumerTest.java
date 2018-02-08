package com.future.market.service;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.market.service.mq.MessageHandle;

public class ConsumerTest {

    public static void main(String[] args) {
        
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("rabbit-consumer.xml");
        
        CachingConnectionFactory connectionFactory = ctx.getBean(CachingConnectionFactory.class);
        TopicExchange topicExchange = (TopicExchange) ctx.getBean("com.future.market");
        RabbitAdmin admin = ctx.getBean(RabbitAdmin.class);
        Queue queue = new AnonymousQueue();
        admin.declareQueue(queue);
        admin.declareBinding(BindingBuilder.bind(queue).to(topicExchange).with("instrument.cu1804"));
        
        //设置监听
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queue.getName());
        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(new MessageHandle(),
                new Jackson2JsonMessageConverter());
        listenerAdapter.setDefaultListenerMethod("onMarketRsp");
        container.setMessageListener(listenerAdapter);
        container.start();
        /*container.setMessageListener(listenerAdapter);
        SimpleMessageListenerContainer listenerContainer = ctx.getBean(SimpleMessageListenerContainer.class);
        listenerContainer.addQueueNames(queue.getName());
        listenerContainer.setMessageListener(new MessageListenerAdapter(new MessageHandle(), "onMarketRsp"));*/
    }
}
