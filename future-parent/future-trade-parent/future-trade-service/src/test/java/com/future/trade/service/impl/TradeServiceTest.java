package com.future.trade.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import com.future.trade.api.service.TradeService;
import com.future.trade.api.vo.CombHedgeFlag;
import com.future.trade.api.vo.CombOffsetFlag;
import com.future.trade.api.vo.ContingentCondition;
import com.future.trade.api.vo.Direction;
import com.future.trade.api.vo.ForceCloseReason;
import com.future.trade.api.vo.OrderPriceType;
import com.future.trade.api.vo.ReqOrderInsertVO;
import com.future.trade.api.vo.TimeCondition;
import com.future.trade.api.vo.VolumeCondition;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-consumer.xml")
public class TradeServiceTest extends AbstractJUnit4SpringContextTests{
    
    static Logger logger = Logger.getLogger(TradeServiceTest.class);
    
    @Autowired
    private TradeService tradeService;
    
    @Autowired
    private RabbitAdmin admin;
    
    @Test
    public void reqOrderInsert() throws IOException{
        
        Queue onRtnOrderQ = (Queue) applicationContext.getBean("onRtnOrderQ");
        TopicExchange onRtnOrderExchange = (TopicExchange) applicationContext.getBean("onRtnOrder");
        admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with("investorNo.onRtnOrder"));
        
        
        while (true) {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            StopWatch watch = new StopWatch();
            watch.start();
            if(logger.isDebugEnabled()){
                logger.debug("开始");
            }
            
            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
            reqOrderInsertVO.setInstrumentID("cu1805");
            reqOrderInsertVO.setLimitPrice(Double.valueOf(inputStr));
            reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
            reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
            reqOrderInsertVO.setDirection(Direction.BUY);
            reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
            reqOrderInsertVO.setMinVolume(1);
            reqOrderInsertVO.setVolumeTotalOriginal(1);
            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
            reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
            reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
            tradeService.reqOrderInsert(reqOrderInsertVO);
            
            //套利单
            
            /*ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
            reqOrderInsertVO.setInstrumentID("m1805");
            reqOrderInsertVO.setLimitPrice(Double.valueOf(inputStr));
            reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
            reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
            reqOrderInsertVO.setDirection(Direction.BUY);
            reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
            reqOrderInsertVO.setMinVolume(1);
            reqOrderInsertVO.setVolumeTotalOriginal(1);
            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
            reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
            reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
            tradeService.reqOrderInsert(reqOrderInsertVO);*/
            
            watch.stop();
            if(logger.isDebugEnabled()){
                logger.debug("耗时:"+watch.getTotalTimeMillis());
            }
        }
    }

}
