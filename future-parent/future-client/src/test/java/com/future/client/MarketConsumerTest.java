package com.future.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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

import com.future.instrument.api.service.InstrumentService;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class MarketConsumerTest extends AbstractJUnit4SpringContextTests{
    
    static Logger logger = Logger.getLogger(MarketConsumerTest.class);
    
    @Autowired
    private InstrumentService instrumentService;
    
    @Resource(name="marketQ")
    private Queue marketQ;
    
    @Resource(name="com.future.market")
    private TopicExchange topicExchange;
    
    @Autowired
    private RabbitAdmin admin;
    
    @Test
    public void consumer() throws IOException{
        
        
        admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument.*"));
        /*List<String> instrumentIDs = instrumentService.queryInstrumentName();
        for (String string : instrumentIDs) {
            admin.declareBinding(BindingBuilder.bind(marketQ).to(topicExchange).with("instrument."+string));
        }*/
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bufferedReader.readLine();
            if(str.equals("bye")){
                break;
            }
        }
        
    }
    
    
}
