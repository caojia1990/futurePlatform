package com.future.client.strategy;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.market.api.vo.DepthMarketData;

/**
 * 大单对冲跟随
 * @author caojia
 */
public class BigVolumeFollow implements Runnable {
    
    private final DepthMarketData marketData;
    
    private final StringRedisTemplate redisTemplate;
    
    public BigVolumeFollow(DepthMarketData marketData, StringRedisTemplate redisTemplate){
        this.marketData = marketData;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
        //成交量
        int volume = this.marketData.getVolume();
        //上次成交量
        //int
        
    }

}
