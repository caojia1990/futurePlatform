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

import com.future.client.dao.FutureTickDao;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;

public class MarketHandleTest implements MessageReceive{
    
    static Logger logger = Logger.getLogger(MarketHandleTest.class);
    
    @Autowired
    private FutureTickDao futureTickDao;
    
    private Map<String, List<DepthMarketData>> marketDataMap = new HashMap<>();
    
    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        String instrumentId = marketData.getInstrumentID();
        
        List<DepthMarketData> list = marketDataMap.get(instrumentId);
        if(list == null){
            list = new ArrayList<>();
            marketDataMap.put(instrumentId, list);
        }
        list.add(marketData);
        
        if(list.size() >= 120){
            StopWatch stopWatch = StopWatch.createStarted();
            
            int r = this.futureTickDao.batchInsert(instrumentId, list);
            
            stopWatch.stop();
            logger.info("插入数据"+r+"条，执行时间：" + stopWatch.getTime());
            
            list.clear();
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(marketData.getUpdateTime(), formatter);
        
        if(list.size() > 0 && time.isAfter(LocalTime.parse("15:00:00")) && time.isBefore(LocalTime.parse("21:00:00"))){
            //未开盘时间
            StopWatch stopWatch = StopWatch.createStarted();
            int r = this.futureTickDao.batchInsert(instrumentId, list);
            logger.info("日盘收盘插入数据"+r+"条，执行时间：" + stopWatch.getTime());
            list.clear();
        }
        
        if(list.size() > 0 && time.isAfter(LocalTime.parse("01:00:00")) && time.isBefore(LocalTime.parse("09:00:00"))){
            //未开盘时间
            StopWatch stopWatch = StopWatch.createStarted();
            int r = this.futureTickDao.batchInsert(instrumentId, list);
            logger.info("夜盘收盘插入数据"+r+"条，执行时间：" + stopWatch.getTime());
            list.clear();
        }
        
    }
    
    

}
