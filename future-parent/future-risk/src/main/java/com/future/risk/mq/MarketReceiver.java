package com.future.risk.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.future.market.api.vo.DepthMarketData;

@Component
@RabbitListener(queues="marketQ")
public class MarketReceiver {

	@RabbitHandler
    public void process(DepthMarketData marketData) {
        System.out.println("Receiver1  : " + marketData.getInstrumentID());
    }
}
