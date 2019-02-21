package com.future.client.mq;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.future.client.dao.QuotaDao;
import com.future.client.dao.TradeDao;
import com.future.client.strategy.FiveMinutesEMA.StopProfit;
import com.future.client.strategy.Manual;
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
    
    @Autowired
    private TradeDao tradeDao;

    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        //taskExecutor.execute(new StopProfit(orderService, cacheMap, tradeDao, marketData, redisTemplate));
        //手动下单  1跳止损
        Manual.offerQuota(marketData);
        
        /*taskExecutor.execute(new FiveSecsFollow(marketData, orderService, redisTemplate, cacheMap,quotaDao));
        if(taskExecutor.getActiveCount() > 50) {
            logger.info("当前活跃线程数："+taskExecutor.getActiveCount());
        }*/
        //taskExecutor.execute(new Breakthrough(marketData, orderService, redisTemplate, cacheMap,quotaDao));
        //对冲保护策略
        //taskExecutor.execute(new Hedging(marketData, orderService, redisTemplate, cacheMap));
        
        //taskExecutor.execute(new PriceFollow(marketData, cacheMap, orderService));
        /*PriceFollow.offerMarket(marketData);
        taskExecutor.execute(new StopProfit(marketData, cacheMap, orderService, tradeDao));*/
    }

}
