package com.future.order.service.impl;

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
import org.springframework.util.StopWatch;

import com.future.common.exception.CommonFutureException;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombHedgeFlag;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.ContingentCondition;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.ForceCloseReason;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;
import com.future.order.api.vo.VolumeCondition;

@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class OrderServiceImplTest extends AbstractJUnit4SpringContextTests{
    
    static Logger logger = Logger.getLogger(OrderServiceImplTest.class);
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private RabbitAdmin admin;
    
    @Test
    public void reqOrderInsert() throws IOException{
        
        String investorID = "caojia";
        Queue onRtnOrderQ = (Queue) applicationContext.getBean("onRtnOrderQ");
        TopicExchange onRtnOrderExchange = (TopicExchange) applicationContext.getBean("onRtnOrderExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnOrderQ).to(onRtnOrderExchange).with(investorID));
        Queue onRtnTradeQ = (Queue) applicationContext.getBean("onRtnTradeQ");
        TopicExchange onRtnTradeExchange = (TopicExchange) applicationContext.getBean("onRtnTradeExchange");
        admin.declareBinding(BindingBuilder.bind(onRtnTradeQ).to(onRtnTradeExchange).with(investorID));
        
        while (true) {
            
            
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            if("bye".equals(inputStr)){
                break;
            }
            StopWatch watch = new StopWatch();
            watch.start();
            if(logger.isDebugEnabled()){
                logger.debug("开始");
            }
            
            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
            reqOrderInsertVO.setAccountNo("00001");
            reqOrderInsertVO.setInvestorId(investorID);
            reqOrderInsertVO.setInstrumentId("cu1805");
            reqOrderInsertVO.setLimitPrice(Double.valueOf(inputStr));
            reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
            reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
            reqOrderInsertVO.setDirection(Direction.SELL);
            reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
            reqOrderInsertVO.setMinVolume(1);
            reqOrderInsertVO.setVolumeTotalOriginal(1);
            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
            reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
            reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
            try {
                orderService.reqOrderInsert(reqOrderInsertVO);
            } catch (CommonFutureException e) {
                logger.error(e.getErrorMsg(), e);
            }
            
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
