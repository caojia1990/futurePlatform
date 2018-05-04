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

public class EMAHandleTest implements MessageReceive{
    
    static Logger logger = Logger.getLogger(EMAHandleTest.class);
    
    @Autowired
    private FutureTickDao futureTickDao;
    
    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        String instrumentId = marketData.getInstrumentID();
        
        //EMAtoday=α * Pricetoday + ( 1 - α ) * EMAyesterday;
        //EMA(n)=(2/(n+1)) * Price + ( (n-1)/(n+1) ) * EMA(n-1);
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(marketData.getUpdateTime(), formatter);
        
        //日盘
        
        
        if(time.isAfter(LocalTime.parse("15:00:00")) && time.isBefore(LocalTime.parse("21:00:00"))){
        }
        
        if(time.isAfter(LocalTime.parse("01:00:00")) && time.isBefore(LocalTime.parse("09:00:00"))){
            //未开盘时间
        }
        
    }
    
    

}
