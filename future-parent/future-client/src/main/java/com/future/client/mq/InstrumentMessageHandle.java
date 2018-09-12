package com.future.client.mq;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alibaba.fastjson.JSON;
import com.future.client.utils.CacheMap;
import com.future.instrument.api.vo.InstrumentMessage;

public class InstrumentMessageHandle {

    static Logger logger = Logger.getLogger(InstrumentMessageHandle.class);
    
    @Autowired
    private RabbitAdmin rabbitAdmin;
    
    @Resource(name="com.future.market")
    private TopicExchange topicExchange;
    
    @Autowired
    @Qualifier("marketQ")
    private Queue queue;
    
    
    public void handleMessage(InstrumentMessage message){
        
        String instrumentId = message.getMessage().getInstrumentId();
        if("0".equals(message.getMessageType())){
            if(logger.isDebugEnabled()){
                logger.debug("接收到新合约"+JSON.toJSONString(message));
                rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(topicExchange).with("instrument."+instrumentId));
                CacheMap.INVESTOR_INSTRUMENT.put(instrumentId, message.getMessage());
            }
        }else if ("1".equals(message.getMessageType())) {
            if(logger.isDebugEnabled()){
                logger.debug("接收到合约变化"+JSON.toJSONString(message));
                CacheMap.INVESTOR_INSTRUMENT.put(instrumentId, message.getMessage());
            }
        }else if ("2".equals(message.getMessageType())) {
            if(logger.isDebugEnabled()){
                logger.debug("接收到删除合约"+JSON.toJSONString(message));
                rabbitAdmin.removeBinding(BindingBuilder.bind(queue).to(topicExchange).with("instrument."+instrumentId));
                CacheMap.INVESTOR_INSTRUMENT.remove(instrumentId);
            }
        }
    }
}
