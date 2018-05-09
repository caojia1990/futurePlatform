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
    
    private Map<String, KlineRange> kMap = new HashMap<>();
    
    private Map<String, Kline> fiveMinMap = new HashMap<>();
    
    private Map<String, EMA> emaMap = new HashMap<String, EMA>(){
        {
            EMA ema = new EMA();
            ema.setInstrumentId("rb1810");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("3569.21"));
            ema.setEma619(new BigDecimal("3610.37"));
            put(ema.getInstrumentId(), ema);
            
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("cu1807");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("50945.93"));
            ema.setEma619(new BigDecimal("51313.04"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("m1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("3105.67"));
            ema.setEma619(new BigDecimal("3166.54"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("RM809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("2560.62"));
            ema.setEma619(new BigDecimal("2624.97"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("y1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("5821.43"));
            ema.setEma619(new BigDecimal("5786.46"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("p1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("5034.31"));
            ema.setEma619(new BigDecimal("4991.35"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("OI809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("6608.11"));
            ema.setEma619(new BigDecimal("6521.33"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("hc1810");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("3672.74"));
            ema.setEma619(new BigDecimal("3704.47"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("i1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("470.02"));
            ema.setEma619(new BigDecimal("470.12"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("j1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("1982.73"));
            ema.setEma619(new BigDecimal("1970.80"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("jm1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("1225.37"));
            ema.setEma619(new BigDecimal("1210.18"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("ZC809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("600.20"));
            ema.setEma619(new BigDecimal("600.82"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("ni1807");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("103907.49"));
            ema.setEma619(new BigDecimal("104292.47"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("zn1807");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("23718.85"));
            ema.setEma619(new BigDecimal("23691.25"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("MA809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("2771.07"));
            ema.setEma619(new BigDecimal("2731.63"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("pp1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("9221.74"));
            ema.setEma619(new BigDecimal("9105.83"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("bu1812");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("3011.33"));
            ema.setEma619(new BigDecimal("2985.54"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("ru1809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("11600.83"));
            ema.setEma619(new BigDecimal("11592.63"));
            put(ema.getInstrumentId(), ema);
        }
        {
            EMA ema = new EMA();
            ema.setInstrumentId("CF809");
            ema.setPersiod("5m");
            ema.setTitle("14:55:00");
            ema.setEma5(new BigDecimal("15648.94"));
            ema.setEma619(new BigDecimal("15568.60"));
            put(ema.getInstrumentId(), ema);
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
