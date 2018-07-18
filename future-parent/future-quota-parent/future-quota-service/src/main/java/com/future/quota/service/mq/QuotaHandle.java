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
        		
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "rb1810");
            	if(ema == null) {
            		ema = new EMA();
                ema.setInstrumentId("rb1810");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("3941.08"));
                ema.setEma619(new BigDecimal("3902.78"));
            	}
            	
            	emaMap.put(ema.getInstrumentId(), ema);
            
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "cu1809");
            	if(ema == null) {
            		ema = new EMA();
            		ema.setInstrumentId("cu1809");
            		ema.setPersiod("5m");
            		ema.setTitle("14:55:00");
            		ema.setEma5(new BigDecimal("48267.31"));
            		ema.setEma619(new BigDecimal("48931.39"));
            	}
            	emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "m1809");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("m1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("3087.88"));
	            ema.setEma619(new BigDecimal("3094.78"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "RM809");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("RM809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("2506.19"));
	            ema.setEma619(new BigDecimal("2522.54"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "y1809");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("y1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("5488.35"));
	            ema.setEma619(new BigDecimal("5504.59"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "p1809");
            if(ema == null) {
                ema = new EMA();
	            ema.setInstrumentId("p1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("4656.78"));
	            ema.setEma619(new BigDecimal("4676.37"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "OI809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("OI809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("6254.93"));
	            ema.setEma619(new BigDecimal("6328.81"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "i1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("i1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("465.66"));
	            ema.setEma619(new BigDecimal("463.11"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "j1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("j1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("2001.49"));
	            ema.setEma619(new BigDecimal("2021.81"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "jm1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("jm1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("1141.50"));
	            ema.setEma619(new BigDecimal("1144.55"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "ZC809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("ZC809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("611.93"));
	            ema.setEma619(new BigDecimal("622.42"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "ni1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("ni1809");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("108800.63"));
                ema.setEma619(new BigDecimal("110699.84"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "zn1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("zn1809");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("20658.19"));
                ema.setEma619(new BigDecimal("20763.93"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "MA809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("MA809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("2867.23"));
	            ema.setEma619(new BigDecimal("2879.49"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "pp1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("pp1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("9332.76"));
	            ema.setEma619(new BigDecimal("9251.32"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "l1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("l1809");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("9325.31"));
                ema.setEma619(new BigDecimal("9260.99"));
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
	            ema.setEma5(new BigDecimal("3216.74"));
	            ema.setEma619(new BigDecimal("3249.56"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "ru1809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("ru1809");
	            ema.setPersiod("5m");
	            ema.setTitle("14:55:00");
	            ema.setEma5(new BigDecimal("10397.97"));
	            ema.setEma619(new BigDecimal("10361.37"));
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
	            ema.setEma5(new BigDecimal("16672.42"));
	            ema.setEma619(new BigDecimal("16636.81"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = (EMA) redisTemplate.opsForHash().get("EMA", "SR809");
            if(ema == null) {
                ema = new EMA();
                ema.setInstrumentId("SR809");
                ema.setPersiod("5m");
                ema.setTitle("14:55:00");
                ema.setEma5(new BigDecimal("4937.36"));
                ema.setEma619(new BigDecimal("4890.36"));
            }
            emaMap.put(ema.getInstrumentId(), ema);
        }
    };
    @Override
    public void handleMessage(DepthMarketData marketData) {
        
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
