package com.future.risk.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.future.market.api.vo.DepthMarketData;
import com.future.risk.websocket.MyWebSocketHandler;

@Component
@RabbitListener(queues="marketQ")
public class MarketReceiver {
    
    @Autowired
    private MyWebSocketHandler handler;

	@RabbitHandler
    public void process(DepthMarketData marketData) {
        try {
            handler.sendMessage(JSON.toJSONString(marketData));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
