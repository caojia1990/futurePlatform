package com.future.market.service.mq;

import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;

public class MessageHandle implements MessageReceive{

    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        System.out.println(marketData);
        
    }

    

}
