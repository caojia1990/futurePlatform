package com.future.client.mq;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.future.client.dao.FutureTickDao;
import com.future.client.dao.KlineRangeDao;
import com.future.client.entity.Kline;
import com.future.client.entity.KlineRange;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;

public class EMAHandleTest implements MessageReceive{
    
    static Logger logger = Logger.getLogger(EMAHandleTest.class);
    
    @Autowired
    private FutureTickDao futureTickDao;
    
    @Autowired
    private KlineRangeDao klineRangeDao;
    
    private Map<String, KlineRange> kMap;
    
    private Map<String, Kline> fiveMinMap;
    
    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        String instrumentId = marketData.getInstrumentID();
        
        //EMAtoday=α * Pricetoday + ( 1 - α ) * EMAyesterday;
        //EMA(n)=(2/(n+1)) * Price + ( (n-1)/(n+1) ) * EMA(n-1);
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(marketData.getUpdateTime(), formatter);
        
        String product = instrumentId.replaceAll("[^a-z^A-Z]", "");
        
        //先从缓存中找出该品种的k线横坐标
        KlineRange klineRange = kMap.get(product);
        if(klineRange == null) {
            //如果没有则去数据库查询
            try {
                klineRange = this.klineRangeDao.selectByCondition(product, "5m", marketData.getUpdateTime());
            } catch (EmptyResultDataAccessException e) {
                //如果数据库查询不到，则该时间为非交易时间，把之前一个周期的k线保存
                //TODO 保存k线数据
            }
        }else {
            //如果k线横坐标存在，判断本次行情的更新时间是否落在该k线横坐标周期内
            
        }
        
        if(time.isAfter(LocalTime.parse("15:00:00")) && time.isBefore(LocalTime.parse("21:00:00"))){
        }
        
        if(time.isAfter(LocalTime.parse("01:00:00")) && time.isBefore(LocalTime.parse("09:00:00"))){
            //未开盘时间
        }
        
    }
    
    

}
