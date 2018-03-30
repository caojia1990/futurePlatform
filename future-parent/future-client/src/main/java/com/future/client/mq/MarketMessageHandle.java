package com.future.client.mq;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.future.client.dao.QuotaDao;
import com.future.client.strategy.Breakthrough;
import com.future.client.strategy.FiveSecsFollow;
import com.future.client.utils.CacheMap;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.service.OrderService;

public class MarketMessageHandle implements MessageReceive{
    
    static Logger logger = Logger.getLogger(MarketMessageHandle.class);
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private CacheMap cacheMap;
    
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    
    @Autowired
    private QuotaDao quotaDao;

    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        taskExecutor.execute(new Breakthrough(marketData, orderService, redisTemplate, cacheMap,quotaDao));
        taskExecutor.execute(new FiveSecsFollow(marketData, orderService, redisTemplate, cacheMap,quotaDao));
        
    }

    

}
