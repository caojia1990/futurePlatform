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
            
            return;
        }
        
        //获取上一次成交量
        int lastVolume = lastTick.getVolume();
        //本次成交量
        int newVolume = marketData.getVolume();
        //一跳成交量
        int volumeChange = newVolume - lastVolume;
        //上一次持仓量
        double position = lastTick.getOpenInterest();
        //本次持仓量
        double newPosition = marketData.getOpenInterest();
        //增仓量
        double positionChange = newPosition - position;
        //平均成交量
        int averageVolume = lastTick.getAverageVolume();
        
        
        
        
    }

}
