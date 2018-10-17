package com.future.quota.service.handle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.alibaba.fastjson.JSON;
import com.future.market.api.vo.DepthMarketData;
import com.future.quota.api.vo.KlineRange;
import com.future.quota.api.vo.MA;
import com.future.quota.service.dao.KlineRangeDao;

/**
 * MA指标生成线程
 * @author caojia
 */
public class MaHandle implements Runnable {
    
    private static MaHandle MA_HANDLE;
    
    static Logger logger = Logger.getLogger(MaHandle.class);
    
    private static String EXCHANGE_NAME = "com.future.quota";
    
    private static LinkedBlockingQueue<DepthMarketData> MARKET_QUEUE = new LinkedBlockingQueue<>();
    
    //缓存每分钟的收盘价
    private static Map<String,LinkedList<Double>> CLOSE_PRICE_LIST = new HashMap<String, LinkedList<Double>>();
    
    //缓存一分钟K线横坐标
    private Map<String, KlineRange> rangeMap = new HashMap<>();
    
    //缓存实时MA
    private Map<String, MA> maMap = new HashMap<>();
    
    private final KlineRangeDao klineRangeDao;
    
    private final RabbitTemplate rabbitTemplate;
    
    public MaHandle(ApplicationContext context){
        
        this.klineRangeDao = context.getBean(KlineRangeDao.class);
        this.rabbitTemplate = context.getBean(RabbitTemplate.class);
        
    }
    
    @Override
    public void run() {

        while (true) {
            
            DepthMarketData marketData = null;
            try {
                marketData = MARKET_QUEUE.take();
            } catch (InterruptedException e) {
                logger.error("获取行情失败");
                return ;
            }
            
            try {
                String instrumentId = marketData.getInstrumentID();
                String product = instrumentId.replaceAll("[^a-z^A-Z]", "");
                
                //先从缓存中找出该品种的k线横坐标
                KlineRange klineRange = rangeMap.get(product);
                if(klineRange == null){
                  //如果没有则去数据库查询
                    try {
                        klineRange = this.klineRangeDao.selectByCondition(product, "1m", marketData.getUpdateTime());
                        //把当前坐标放入缓存
                        rangeMap.put(product, klineRange);
                    } catch (EmptyResultDataAccessException e) {
                        //如果数据库查询不到，则该时间为非交易时间,不处理，等待进入交易时间
                        continue;
                    }
                    
                }else {
                    //如果k线横坐标存在，判断本次行情的更新时间是否落在该k线横坐标周期内
                    if(marketData.getUpdateTime().compareTo(klineRange.getBeginTime()) > -1 
                            && marketData.getUpdateTime().compareTo(klineRange.getEndTime()) < 1){
                        MA ma = maMap.get(instrumentId);
                        if(ma == null){
                            ma = new MA();
                            maMap.put(instrumentId, ma);
                            ma.setInstrumentId(instrumentId);
                            ma.setPersiod("1m");
                            ma.setComplete(false);
                            ma.setUpperPrice(new BigDecimal(marketData.getUpperLimitPrice()));
                            ma.setLowerPrice(new BigDecimal(marketData.getLowerLimitPrice()));
                            ma.setBidPrice1(new BigDecimal(marketData.getBidPrice1()));
                            ma.setAskPrice1(new BigDecimal(marketData.getAskPrice1()));
                            ma.setTradingDay(marketData.getTradingDate());
                        }
                        ma.setLastPrice(new BigDecimal(marketData.getLastPrice()));
                        ma.setTitle(marketData.getUpdateTime());
                        ma.setBidPrice1(new BigDecimal(marketData.getBidPrice1()));
                        ma.setAskPrice1(new BigDecimal(marketData.getAskPrice1()));
                        BigDecimal ma5 = this.calcMA(instrumentId, marketData.getLastPrice());
                        ma.setMa5(ma5);
                        //如果该跳行情是区间内最后一跳，直接保存
                        if(marketData.getUpdateTime().equals(klineRange.getEndTime()) && marketData.getUpdateMillisec() == 500){
                            ma.setComplete(true);
                            this.addClosePrice(instrumentId, marketData.getLastPrice());
                        }
                        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "quota."+instrumentId+".MA.1m", ma);
                        if(ma.isComplete()){
                            maMap.remove(instrumentId);
                        }
                        
                    }else {
                        //如果当前时间不在缓存的k先横坐标内，先保存上一周期k线，再查询新的坐标范围
                        MA ma = maMap.get(instrumentId);
                        if(ma != null) {
                            ma.setComplete(true);
                            rabbitTemplate.convertAndSend(EXCHANGE_NAME, "quota."+instrumentId+".MA.1m", ma);
                            //保存收盘价到队列
                            this.addClosePrice(instrumentId, ma.getLastPrice().doubleValue());
                            //删除缓存的MA数据
                            maMap.remove(instrumentId);
                        }
                        
                        try {
                            klineRange = this.klineRangeDao.selectByCondition(product, "1m", marketData.getUpdateTime());
                            //把当前坐标放入缓存
                            rangeMap.put(product, klineRange);
                            ma = new MA();
                            ma.setInstrumentId(instrumentId);
                            ma.setPersiod("1m");
                            ma.setComplete(false);
                            ma.setLastPrice(new BigDecimal(marketData.getLastPrice()));
                            ma.setUpperPrice(new BigDecimal(marketData.getUpperLimitPrice()));
                            ma.setLowerPrice(new BigDecimal(marketData.getLowerLimitPrice()));
                            ma.setBidPrice1(new BigDecimal(marketData.getBidPrice1()));
                            ma.setAskPrice1(new BigDecimal(marketData.getAskPrice1()));
                            ma.setTitle(marketData.getUpdateTime());
                            ma.setTradingDay(marketData.getTradingDate());
                            BigDecimal ma5 = this.calcMA(instrumentId, marketData.getLastPrice());
                            ma.setMa5(ma5);
                            rabbitTemplate.convertAndSend(EXCHANGE_NAME, "quota."+instrumentId+".MA.1m", ma);
                            maMap.put(instrumentId, ma);
                            
                        } catch (EmptyResultDataAccessException e) {
                            //如果数据库查询不到，则该时间为非交易时间
                            
                            System.out.println("非交易时间："+JSON.toJSONString(marketData));
                        }
                        
                    }
                }
            } catch (Exception e) {
                logger.error("计算MA异常:"+JSON.toJSONString(marketData),e);
            }
            
        }
        
    }
    
    /**
     * 计算平均数
     * @param instrumentId
     * @param price
     * @return
     */
    public BigDecimal calcMA(String instrumentId, double price){
        
        if(CLOSE_PRICE_LIST.get(instrumentId) == null || CLOSE_PRICE_LIST.get(instrumentId).size() < 1){
            return new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
        }
        
        double sum = 0;
        
        for (Double d : CLOSE_PRICE_LIST.get(instrumentId)) {
            sum += d;
        }
        
        double avg = (sum+price)/(CLOSE_PRICE_LIST.get(instrumentId).size()+1);
        return new BigDecimal(avg).setScale(2, RoundingMode.HALF_UP);
    }
    
    public void addClosePrice(String instrumentId, Double price){
        LinkedList<Double> list = CLOSE_PRICE_LIST.get(instrumentId);
        if(list == null){
            list = new LinkedList<Double>();
            CLOSE_PRICE_LIST.put(instrumentId, list);
        }
        
        list.push(price);
        //队列只保留前4分钟的收盘价
        if(list.size() >= 5){
            list.pollLast();
        }
    }
    
    public static void START(ApplicationContext context){
        
        if(MA_HANDLE == null){
            MA_HANDLE = new MaHandle(context);
            new Thread(MA_HANDLE).start();
        }
    }
    
    public static void OFFERMARKET(DepthMarketData marketData){
        MARKET_QUEUE.offer(marketData);
    }
    
    public static void main(String[] args) {
        
    }

}
