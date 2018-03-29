package com.future.client.mq;

import org.springframework.beans.factory.annotation.Autowired;

import com.future.client.dao.MarketDataDao;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;

public class MarketHandleTest implements MessageReceive{
    
    @Autowired
    private MarketDataDao marketDataDao;

    @Override
    public void handleMessage(DepthMarketData marketData) {

        this.marketDataDao.save(marketData);
        
    }
    
    

}
