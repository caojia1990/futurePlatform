package com.future.client.mq;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.alibaba.fastjson.JSON;
import com.future.client.dao.KlineRangeDao;
import com.future.client.entity.Kline;
import com.future.client.entity.KlineRange;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;

public class EMAHandleTest implements MessageReceive{
    
    static Logger logger = Logger.getLogger(EMAHandleTest.class);
    
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
                //把当前坐标放入缓存
                kMap.put(product, klineRange);
            } catch (EmptyResultDataAccessException e) {
                //如果数据库查询不到，则该时间为非交易时间，把之前一个周期的k线保存
                //TODO 保存k线数据
                if(fiveMinMap.get(instrumentId) != null){
                    System.out.println(JSON.toJSONString(fiveMinMap.get(instrumentId)));
                    fiveMinMap.remove(instrumentId);
                }
            }
        }else {
            //如果k线横坐标存在，判断本次行情的更新时间是否落在该k线横坐标周期内
            String beginTime = klineRange.getBeginTime();
            String endTime = klineRange.getEndTime();
            
            if(marketData.getUpdateTime().compareTo(beginTime) > -1 && marketData.getUpdateTime().compareTo(endTime) < 1){
                //如果在区间内,先和缓存中的k线比较价格更新最高最低价
                Kline kline = fiveMinMap.get(instrumentId);
                if(kline != null){
                    if(new BigDecimal(marketData.getLastPrice()).compareTo(kline.getHighestPrice()) > 0){
                        kline.setHighestPrice(new BigDecimal(marketData.getLastPrice()));
                    }
                    if(new BigDecimal(marketData.getLastPrice()).compareTo(kline.getLowestPrice()) < 0){
                        kline.setLowestPrice(new BigDecimal(marketData.getLastPrice()));
                    }
                    kline.setClosePrice(new BigDecimal(marketData.getLastPrice()));
                    fiveMinMap.put(instrumentId, kline);
                    
                }else {
                    //如果k线为空，则初始化一根k线
                    kline = new Kline();
                    kline.setOpenPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setHighestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setLowestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setClosePrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setPeriod("5m");
                    kline.setTitle(beginTime);
                    fiveMinMap.put(instrumentId, kline);
                }
                
                //如果该跳行情时区间内最后一跳，直接保存
                if(marketData.getUpdateTime().equals(endTime) && marketData.getUpdateMillisec() == 500){
                    //TODO
                    System.out.println(JSON.toJSONString(kline));
                    fiveMinMap.remove(instrumentId);
                }
            }else {
                //如果当前时间不在缓存的k先横坐标内，先保存上一周期k线，再查询新的坐标范围
                
                if(fiveMinMap.get(instrumentId) != null){
                    //TODO 保存k线数据
                    System.out.println(JSON.toJSONString(fiveMinMap.get(instrumentId)));
                    fiveMinMap.remove(instrumentId);
                }
                
                try {
                    klineRange = this.klineRangeDao.selectByCondition(product, "5m", marketData.getUpdateTime());
                    //把当前坐标放入缓存
                    kMap.put(product, klineRange);
                    Kline kline = new Kline();
                    kline.setOpenPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setHighestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setLowestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setClosePrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setPeriod("5m");
                    kline.setTitle(beginTime);
                    fiveMinMap.put(instrumentId, kline);
                    
                } catch (EmptyResultDataAccessException e) {
                    //如果数据库查询不到，则该时间为非交易时间，把之前一个周期的k线保存
                    
                    System.out.println("非交易时间："+JSON.toJSONString(marketData));
                }
            }
            
        }
        
    }
    

}
