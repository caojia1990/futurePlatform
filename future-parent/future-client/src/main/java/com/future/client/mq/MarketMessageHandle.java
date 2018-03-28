package com.future.client.mq;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.future.client.strategy.Breakthrough;
import com.future.client.strategy.FiveSecsFollow;
import com.future.client.utils.CacheMap;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.OnRtnTradeVO;

public class MarketMessageHandle implements MessageReceive{
    
    static Logger logger = Logger.getLogger(MarketMessageHandle.class);
    
    @Autowired
    private OrderService orderService;
    
    @Resource(name="redisTemplate")
    private ValueOperations<String , OnRtnTradeVO> valueOperations;
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String, OnRtnTradeVO> hashOperations;
    
    @Autowired
    private CacheMap cacheMap;
    
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        taskExecutor.execute(new Breakthrough(marketData, orderService, hashOperations, cacheMap));
        taskExecutor.execute(new FiveSecsFollow(marketData, orderService, hashOperations, cacheMap));
        
    }

    

}
