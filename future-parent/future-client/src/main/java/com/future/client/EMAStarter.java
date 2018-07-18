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
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        {
            //订阅EMA指标
            TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.quota");
            Queue quotaQ = (Queue) context.getBean("quotaQ");
            admin.declareBinding(BindingBuilder.bind(quotaQ).to(topicExchange).with("quota.*.EMA.5m"));
        }
        
        {
            //订阅行情
            TopicExchange marketExchange = (TopicExchange) context.getBean("com.future.market");
            Queue marketQ = (Queue) context.getBean("marketQ");
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.i1809"));//铁矿石
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.j1809"));//焦炭
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.jm1809"));//焦煤
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ZC809"));//动力煤
            
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.rb1810"));//螺纹
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.cu1809"));//铜
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ni1809"));//镍
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.zn1809"));//锌
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ru1809"));//橡胶
            
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.MA809"));//甲醇
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.l1809"));//塑料
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.bu1812"));//沥青

            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.CF901"));//棉花
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.SR901"));//白糖
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.m1809"));//豆粕
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.RM809"));//菜粕
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.y1809"));//豆油
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.p1809"));//棕榈油
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.OI809"));//菜油
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.pp1809"));
        }
        
        {
            //订阅报单回报
            Queue onRtnOrderQ = (Queue) context.getBean("onRtnOrderQ");
            TopicExchange onRtnOrderExchange = (TopicExchange) context.getBean("onRtnOrderExchange");
            admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with(INVESTOR_ID));
        }
        
        {
            //订阅成交回报
            Queue onRtnTradeQ = (Queue) context.getBean("onRtnTradeQ");
            TopicExchange onRtnTradeExchange = (TopicExchange) context.getBean("onRtnTradeExchange");
            admin.declareBinding(BindingBuilder.bind(onRtnTradeQ).to(onRtnTradeExchange).with(INVESTOR_ID));
        }
        
    }

}
