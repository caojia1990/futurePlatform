package com.future.quota.service.mq;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;
import com.future.quota.api.vo.EMA;
import com.future.quota.api.vo.Kline;
import com.future.quota.api.vo.KlineRange;
import com.future.quota.service.dao.KlineRangeDao;
import com.future.quota.service.handle.MaHandle;

public class QuotaHandle implements MessageReceive{
    
    static Logger logger = Logger.getLogger(QuotaHandle.class);
    
    @Autowired
    private KlineRangeDao klineRangeDao;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    private Map<String, KlineRange> kMap = new HashMap<>();
    
    private Map<String, Kline> fiveMinMap = new HashMap<>();
    
    private Map<String, EMA> emaMap;
    
    public void init(){
        
        emaMap = new HashMap<String, EMA>();
        {
        		
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "rb1901");
            	if(ema == null) {
            		ema = new EMA();
                ema.setInstrumentId("rb1901");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("4172.52"));
                ema.setEma619(new BigDecimal("4249.59"));
            	}
            	
            	emaMap.put(ema.getInstrumentId(), ema);
            
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "cu1810");
            	if(ema == null) {
            		ema = new EMA();
            		ema.setInstrumentId("cu1810");
            		ema.setPersiod("5m");
            		ema.setTitle("14:55:00");
            		ema.setEma5(new BigDecimal("48810.18"));
            		ema.setEma619(new BigDecimal("48675.99"));
            	}
            	emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "m1901");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("m1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("3066.63"));
	            ema.setEma619(new BigDecimal("3124.48"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "RM901");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("RM901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("2358.94"));
	            ema.setEma619(new BigDecimal("2416.10"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "y1901");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("y1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("5782.20"));
	            ema.setEma619(new BigDecimal("5842.61"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "p1901");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("p1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("4861.40"));
	            ema.setEma619(new BigDecimal("4902.73"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "OI901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("OI901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("6604.92"));
	            ema.setEma619(new BigDecimal("6687.66"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "i1901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("i1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("480.77"));
	            ema.setEma619(new BigDecimal("489.72"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "j1901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("j1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("2576.25"));
	            ema.setEma619(new BigDecimal("2552.07"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "jm1901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("jm1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("1246.77"));
	            ema.setEma619(new BigDecimal("1280.45"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "ZC901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("ZC901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("620.26"));
	            ema.setEma619(new BigDecimal("615.19"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "ni1811");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("ni1811");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("109964.62"));
                ema.setEma619(new BigDecimal("110169.19"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "zn1810");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("zn1810");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("21076.77"));
                ema.setEma619(new BigDecimal("20973.80"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "MA901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("MA901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("3281.43"));
	            ema.setEma619(new BigDecimal("3315.18"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "pp1901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("pp1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("9775.36"));
	            ema.setEma619(new BigDecimal("9876.21"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "l1901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("l1901");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("9502.15"));
                ema.setEma619(new BigDecimal("9611.45"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "bu1812");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("bu1812");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("3366.25"));
	            ema.setEma619(new BigDecimal("3328.60"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "ru1901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("ru1901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("12342.17"));
	            ema.setEma619(new BigDecimal("12365.62"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "CF901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("CF901");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("16823.02"));
	            ema.setEma619(new BigDecimal("16936.35"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "SR901");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("SR901");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("4994.67"));
                ema.setEma619(new BigDecimal("5040.65"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
    };
    @Override
    public void handleMessage(DepthMarketData marketData) {
        //MA线程
        MaHandle.OFFERMARKET(marketData);
        
        String instrumentId = marketData.getInstrumentID();
        
        if(emaMap.get(instrumentId) == null) {
            return;
        }
        
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
                    //路由key   quota.合约名.指标.周期
                    String routingKey = "quota."+instrumentId+".k.5m";
                    rabbitTemplate.convertAndSend("com.future.quota", routingKey, fiveMinMap.get(instrumentId));
                    //计算EMA
                    EMA ema = this.calcEMA(instrumentId, fiveMinMap.get(instrumentId).getClosePrice());
                    if(ema != null){
                        ema.setTitle(fiveMinMap.get(instrumentId).getTitle());
                        ema.setTradingDay(marketData.getTradingDate());
                        ema.setUpperPrice(new BigDecimal(marketData.getUpperLimitPrice()));
                        ema.setLowerPrice(new BigDecimal(marketData.getLowerLimitPrice()));
                        ema.setHighestPrice(fiveMinMap.get(instrumentId).getHighestPrice());
                        ema.setLowestPrice(fiveMinMap.get(instrumentId).getLowestPrice());
                        ema.setClosePrice(fiveMinMap.get(instrumentId).getClosePrice());
                        rabbitTemplate.convertAndSend("com.future.quota", "quota."+instrumentId+".EMA.5m", ema);
                        emaMap.put(instrumentId, ema);
                        redisTemplate.opsForHash().put("EMA", instrumentId, ema);
                    }
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
                    kline.setInstrumentId(instrumentId);
                    kline.setOpenPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setHighestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setLowestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setClosePrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setPeriod("5m");
                    kline.setTitle(beginTime);
                    fiveMinMap.put(instrumentId, kline);
                }
                
                if((marketData.getUpdateTime().equals("10:14:58") || marketData.getUpdateTime().equals("11:29:58") 
                        || marketData.getUpdateTime().equals("14:59:58")) 
                        && marketData.getUpdateMillisec() == 500){
                    //提前一秒计算EMA 防止收盘下不了单
                    EMA ema = this.calcEMA(instrumentId, fiveMinMap.get(instrumentId).getClosePrice());
                    if(ema != null){
                        ema.setTitle(fiveMinMap.get(instrumentId).getTitle());
                        ema.setTradingDay(marketData.getTradingDate());
                        ema.setUpperPrice(new BigDecimal(marketData.getUpperLimitPrice()));
                        ema.setLowerPrice(new BigDecimal(marketData.getLowerLimitPrice()));
                        ema.setHighestPrice(fiveMinMap.get(instrumentId).getHighestPrice());
                        ema.setLowestPrice(fiveMinMap.get(instrumentId).getLowestPrice());
                        ema.setClosePrice(fiveMinMap.get(instrumentId).getClosePrice());
                        rabbitTemplate.convertAndSend("com.future.quota", "quota."+instrumentId+".EMA.5m", ema);
                    }
                }else
                //如果该跳行情是区间内最后一跳，直接保存
                if(marketData.getUpdateTime().equals(endTime) && marketData.getUpdateMillisec() == 500){
                    //TODO
                    System.out.println(JSON.toJSONString(kline));
                    //路由key   quota.合约名.指标.周期
                    String routingKey = "quota."+instrumentId+".k.5m";
                    rabbitTemplate.convertAndSend("com.future.quota", routingKey, fiveMinMap.get(instrumentId));
                    //计算EMA
                    EMA ema = this.calcEMA(instrumentId, fiveMinMap.get(instrumentId).getClosePrice());
                    if(ema != null){
                        ema.setTitle(fiveMinMap.get(instrumentId).getTitle());
                        ema.setTradingDay(marketData.getTradingDate());
                        ema.setUpperPrice(new BigDecimal(marketData.getUpperLimitPrice()));
                        ema.setLowerPrice(new BigDecimal(marketData.getLowerLimitPrice()));
                        ema.setHighestPrice(fiveMinMap.get(instrumentId).getHighestPrice());
                        ema.setLowestPrice(fiveMinMap.get(instrumentId).getLowestPrice());
                        ema.setClosePrice(fiveMinMap.get(instrumentId).getClosePrice());
                        rabbitTemplate.convertAndSend("com.future.quota", "quota."+instrumentId+".EMA.5m", ema);
                        emaMap.put(instrumentId, ema);
                        redisTemplate.opsForHash().put("EMA", instrumentId, ema);
                    }
                    fiveMinMap.remove(instrumentId);
                }
            }else {
                //如果当前时间不在缓存的k先横坐标内，先保存上一周期k线，再查询新的坐标范围
                
                if(fiveMinMap.get(instrumentId) != null){
                    //TODO 保存k线数据
                    System.out.println(JSON.toJSONString(fiveMinMap.get(instrumentId)));
                    //路由key   quota.合约名.指标.周期
                    String routingKey = "quota."+instrumentId+".k.5m";
                    rabbitTemplate.convertAndSend("com.future.quota", routingKey, fiveMinMap.get(instrumentId));
                    //计算EMA
                    EMA ema = this.calcEMA(instrumentId, fiveMinMap.get(instrumentId).getClosePrice());
                    if(ema != null){
                        ema.setTitle(fiveMinMap.get(instrumentId).getTitle());
                        ema.setTradingDay(marketData.getTradingDate());
                        ema.setUpperPrice(new BigDecimal(marketData.getUpperLimitPrice()));
                        ema.setLowerPrice(new BigDecimal(marketData.getLowerLimitPrice()));
                        ema.setHighestPrice(fiveMinMap.get(instrumentId).getHighestPrice());
                        ema.setLowestPrice(fiveMinMap.get(instrumentId).getLowestPrice());
                        ema.setClosePrice(fiveMinMap.get(instrumentId).getClosePrice());
                        rabbitTemplate.convertAndSend("com.future.quota", "quota."+instrumentId+".EMA.5m", ema);
                        emaMap.put(instrumentId, ema);
                        redisTemplate.opsForHash().put("EMA", instrumentId, ema);
                    }
                    fiveMinMap.remove(instrumentId);
                }
                
                try {
                    klineRange = this.klineRangeDao.selectByCondition(product, "5m", marketData.getUpdateTime());
                    //把当前坐标放入缓存
                    kMap.put(product, klineRange);
                    Kline kline = new Kline();
                    kline.setInstrumentId(instrumentId);
                    kline.setOpenPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setHighestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setLowestPrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setClosePrice(new BigDecimal(marketData.getLastPrice()));
                    kline.setPeriod("5m");
                    kline.setTitle(klineRange.getBeginTime());
                    fiveMinMap.put(instrumentId, kline);
                    
                } catch (EmptyResultDataAccessException e) {
                    //如果数据库查询不到，则该时间为非交易时间，把之前一个周期的k线保存
                    
                    System.out.println("非交易时间："+JSON.toJSONString(marketData));
                }
            }
            
        }
        
    }
    
    private EMA calcEMA(String instrument, BigDecimal price){
        
        //EMAtoday=α * Pricetoday + ( 1 - α ) * EMAyesterday;
        //EMA(n)=(2/(n+1)) * Price + ( (n-1)/(n+1) ) * EMA(n-1);
        
        EMA lastEMA = emaMap.get(instrument);
        
        EMA ema = null;
        if(lastEMA != null){
            ema = new EMA();
            ema.setInstrumentId(instrument);
            ema.setPersiod("5m");
            double ema5 = 2.0/(5+1)*price.doubleValue() + (5-1.0)/(5+1)*lastEMA.getEma5().doubleValue();
            ema.setEma5(new BigDecimal(ema5).setScale(2, RoundingMode.HALF_UP));
            
            double ema619 = 2.0/(619+1)*price.doubleValue() + (619-1.0)/(619+1)*lastEMA.getEma619().doubleValue();
            ema.setEma619(new BigDecimal(ema619).setScale(2, RoundingMode.HALF_UP));
        }
        return ema;
    }
    

}
