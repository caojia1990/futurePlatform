package com.future.client.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.future.client.dao.TradeDao;
import com.future.client.strategy.FiveMinutesEMA;
import com.future.client.utils.CacheMap;
import com.future.order.api.service.OrderService;
import com.future.quota.api.vo.EMA;
import com.future.quota.api.vo.MA;

public class QuotaMessageHandle{
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Autowired
    private CacheMap cacheMap;
    
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    
    @Autowired
    private TradeDao tradeDao;

    public void handleMessage(EMA ema) {
        
        taskExecutor.execute(new FiveMinutesEMA(orderService,ema,redisTemplate,cacheMap,tradeDao));
        
    }
    
    public void handleMa(MA ma){
    }

}
