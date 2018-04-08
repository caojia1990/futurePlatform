package com.future.client.strategy;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.vo.OnRtnOrderVO;

public class Hedging implements Runnable {
    
    private final DepthMarketData marketData;
    
    private final StringRedisTemplate redisTemplate;
    
    public Hedging(DepthMarketData marketData, StringRedisTemplate redisTemplate) {
        this.marketData = marketData;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        String instrumentID = this.marketData.getInstrumentID();

        
        OnRtnOrderVO onRtnOrderVO = (OnRtnOrderVO) this.redisTemplate.opsForHash().get(FiveSecsFollow.ACCOUNT_NO, instrumentID);
        
    }

}
