package com.future.client.strategy;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.client.entity.Tick;
import com.future.client.utils.CacheMap;
import com.future.market.api.vo.DepthMarketData;

/**
 * 大单对冲跟随
 * @author caojia
 */
public class BigVolumeFollow implements Runnable {
    
    private final DepthMarketData marketData;
    
    private final StringRedisTemplate redisTemplate;
    
    private final CacheMap cacheMap;
    
    public BigVolumeFollow(DepthMarketData marketData, StringRedisTemplate redisTemplate, 
            CacheMap cacheMap){
        this.marketData = marketData;
        this.redisTemplate = redisTemplate;
        this.cacheMap = cacheMap;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        String instrumentID = this.marketData.getInstrumentID();
        //成交量
        int volume = this.marketData.getVolume();
        //上一跳行情
        Tick lastTick = this.cacheMap.tickMap.get(instrumentID);
        if(lastTick == null){
            lastTick = new Tick();
            lastTick.setAskPrice(marketData.getAskPrice1());
            lastTick.setAskVolume(marketData.getAskVolume1());
            lastTick.setBidPrice(marketData.getBidPrice1());
            lastTick.setBidVoume(marketData.getBidVolume1());
            lastTick.setInstrumentId(instrumentID);
            lastTick.setLastPrice(marketData.getLastPrice());
            lastTick.setOpenInterest(marketData.getOpenInterest());
            lastTick.tickIncr();
            lastTick.setTurnover(marketData.getTurnover());
            lastTick.setVolume(marketData.getVolume());
            this.cacheMap.tickMap.put(instrumentID, lastTick);
        }else {
            //获取上一次成交量
            int lastVolume = lastTick.getVolume();
            
        }
        
    }

}
