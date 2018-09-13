package com.future.quota.service.mq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:rabbit-consumer-test.xml")
public class MATest extends AbstractJUnit4SpringContextTests{
    
    static Logger logger = Logger.getLogger(MATest.class);
    
    @Resource(name="quotaQ")
    private Queue quotaQ;
    
    @Resource(name="com.future.quota")
    private TopicExchange topicExchange;
    
    @Autowired
    private RabbitAdmin admin;
    
    @Test
    public void consumer() throws IOException{
        
        
        admin.declareBinding(BindingBuilder.bind(quotaQ).to(topicExchange).with("quota.cu1811.MA.1m"));
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bufferedReader.readLine();
            if(str.equals("bye")){
                break;
            }
        }
        
    }
    
    
}
