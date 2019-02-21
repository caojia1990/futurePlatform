package com.future.client;

import java.util.List;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.client.strategy.Manual;
import com.future.client.strategy.OneMinutesMA;
import com.future.client.utils.CacheMap;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InvestorInstrumentService;
import com.future.instrument.api.vo.InvestorInstrumentVO;

public class EMAStarter {
    
    public static String INVESTOR_ID = "001";
    
    public static void main(String[] args) throws InstrumentException {
        
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        context.start();
        RabbitAdmin admin = context.getBean(RabbitAdmin.class);
        /*{
            //订阅EMA指标
            TopicExchange topicExchange = (TopicExchange) context.getBean("com.future.quota");
            Queue quotaQ = (Queue) context.getBean("quotaQ");
            admin.declareBinding(BindingBuilder.bind(quotaQ).to(topicExchange).with("quota.*.EMA.5m"));
            //订阅MA指标
            Queue maQuotaQ = (Queue) context.getBean("maQuotaQ");
            admin.declareBinding(BindingBuilder.bind(maQuotaQ).to(topicExchange).with("quota.*.MA.1m"));
        }*/
        
        {
            //订阅行情
            TopicExchange marketExchange = (TopicExchange) context.getBean("com.future.market");
            Queue marketQ = (Queue) context.getBean("marketQ");
            
            
            InvestorInstrumentService investorInstrumentService = context.getBean(InvestorInstrumentService.class);
            List<InvestorInstrumentVO> list = investorInstrumentService.queryInvestorInstrumentList(INVESTOR_ID);
            if(list != null){
                for (InvestorInstrumentVO investorInstrumentVO : list) {
                    CacheMap.INVESTOR_INSTRUMENT.put(investorInstrumentVO.getInstrumentId(), investorInstrumentVO);
                    admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument."+investorInstrumentVO.getInstrumentId()));
                }
            }
            
            /*
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.j1901"));//焦炭
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.jm1901"));//焦煤
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ZC901"));//动力煤（主力）
            
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.rb1901"));//螺纹
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.cu1810"));//铜（主力）
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ni1811"));//镍（主力）
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.zn1810"));//锌（主力）
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.ru1901"));//橡胶（主力）
            
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.MA901"));//甲醇
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.l1901"));//塑料（主力）
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.bu1812"));//沥青

            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.CF901"));//棉花
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.SR901"));//白糖
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.m1901"));//豆粕
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.RM901"));//菜粕（主力）
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.y1901"));//豆油
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.p1901"));//棕榈油
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.OI901"));//菜油
            admin.declareBinding(BindingBuilder.bind(marketQ).to(marketExchange).with("instrument.pp1901"));//（主力）
            */
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
        
        {
            Queue queue = (Queue) context.getBean("instrumentQ");
            TopicExchange exchange = (TopicExchange) context.getBean("com.future.instrument");
            admin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(INVESTOR_ID));
        }
        //启动对冲策略
        //OneMinutesMA.START(context);
        //启动一跳止赢线程
        Manual.START(context);
        
    }

}
