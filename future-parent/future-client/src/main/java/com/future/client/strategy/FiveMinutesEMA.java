package com.future.client.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;
import com.future.client.ClientStarter;
import com.future.client.EMAStarter;
import com.future.client.dao.TradeDao;
import com.future.client.entity.TargetProfit;
import com.future.client.utils.CacheMap;
import com.future.client.utils.SpringContextUtil;
import com.future.common.exception.CommonFutureException;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;
import com.future.quota.api.vo.EMA;

/**
 * 5分钟EMA交叉策略
 * @author caojia
 *
 */
public class FiveMinutesEMA implements Runnable {
    
    static Logger logger = Logger.getLogger(FiveMinutesEMA.class);
    
    static final String ACCOUNT_NO = "00009";
    
    final private OrderService orderService;
    
    final private EMA ema;
    
    final private StringRedisTemplate redisTemplate;
    
    final private CacheMap cacheMap;
    
    final private TradeDao tradeDao;
    
    private static final Map<String, TargetProfit> targetMap = new HashMap<String, TargetProfit>(){
        {
            TargetProfit targetProfit = new TargetProfit();
            targetProfit.setProduct("m");
            targetProfit.setStopLessTick(20);
            targetProfit.setTigger(new BigDecimal("0.02"));
            targetProfit.setBack(new BigDecimal("0.33"));
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("RM");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("y");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("p");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("OI");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("rb");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("hc");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("SR");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("i");
            targetProfit.setTigger(new BigDecimal("0.03"));
            targetProfit.setBack(new BigDecimal("0.4"));
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("j");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("jm");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("ZC");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("ni");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("cu");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("zn");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("MA");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("pp");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("l");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("bu");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("ru");
            put(targetProfit.getProduct(), targetProfit);
            
            targetProfit.setProduct("CF");
            targetProfit.setTigger(new BigDecimal("0.02"));
            targetProfit.setBack(new BigDecimal("0.4"));
            put(targetProfit.getProduct(), targetProfit);
        }
    };
    
    public FiveMinutesEMA(OrderService orderService, EMA ema, StringRedisTemplate redisTemplate, CacheMap cacheMap,TradeDao tradeDao) {
        this.orderService = orderService;
        this.ema = ema;
        this.redisTemplate = redisTemplate;
        this.cacheMap = cacheMap;
        this.tradeDao = tradeDao;
    }

    @Override
    public void run() {
        
        logger.info("收到指标信息："+JSON.toJSONString(ema));
        
        try {
            //先获取缓存中的指标信息
            String instrumentId = ema.getInstrumentId();
            EMA oldEma = (EMA) this.redisTemplate.opsForHash().get(instrumentId, "EMA5");
            if(oldEma == null) {
                this.redisTemplate.opsForHash().put(instrumentId, "EMA5", ema);
                return;
            }
            
            //获取合约详情
            InstrumentVO instrumentVO = cacheMap.getInstrument(instrumentId);
            //计算开一手的金额    每个品种拿20万做
            double turnover = instrumentVO.getVolumeMultiple() * ema.getClosePrice().doubleValue();
            long volume = Math.round(200000/turnover);
            volume = volume == 0 ? 1:volume;
            
            int oldflag = oldEma.getEma5().compareTo(oldEma.getEma619());
            int newflag = ema.getEma5().compareTo(ema.getEma619());
            
            //更新最高价和最低价
            if(oldEma.getHighestPrice().compareTo(ema.getHighestPrice()) > 0){
                ema.setHighestPrice(oldEma.getHighestPrice());
            }
            if(oldEma.getLowestPrice().compareTo(ema.getLowestPrice()) < 0){
                ema.setLowestPrice(oldEma.getLowestPrice());
            }
            
            //金叉
            if(oldflag < 0 && newflag >= 0) {
                if(newflag == 0){
                    //刚好金叉
                    ema.setEma5(ema.getEma5().add(new BigDecimal("0.01")));
                }
                ema.setHighestPrice(ema.getClosePrice());
                ema.setLowestPrice(ema.getClosePrice());
                //下多单
                {
                    
                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                    reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                    reqOrderInsertVO.setInstrumentId(instrumentId);
                    reqOrderInsertVO.setLimitPrice(ema.getUpperPrice().doubleValue());
                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                    reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                    reqOrderInsertVO.setDirection(Direction.BUY);
                    reqOrderInsertVO.setMinVolume(1);
                    reqOrderInsertVO.setVolumeTotalOriginal((int)volume);
                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                    orderService.reqOrderInsert(reqOrderInsertVO);
                    logger.info(instrumentId+"出现金叉，下多单");
                }
                
                
                //查询是否有空单
                List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId, "1");
                if(list != null && list.size() > 0){
                    //将空单平仓
                    for (OnRtnTradeVO onRtnTradeVO : list) {
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentId(instrumentId);
                        reqOrderInsertVO.setLimitPrice(ema.getUpperPrice().doubleValue());
                        if(onRtnTradeVO.getTradingDay().equals(ema.getTradingDay())) {
                            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                        }else {
                            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                        }
                        reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                        reqOrderInsertVO.setDirection(Direction.BUY);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(onRtnTradeVO.getVolume());
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        orderService.reqOrderInsert(reqOrderInsertVO);
                        logger.info(instrumentId+"出现金叉，平空单");
                    }
                }
            }
            
            //死叉
            if(oldflag >0 && newflag <=0){
                if(newflag == 0){
                    //刚好死叉
                    ema.setEma5(ema.getEma5().subtract(new BigDecimal("0.01")));
                }
                ema.setHighestPrice(ema.getClosePrice());
                ema.setLowestPrice(ema.getClosePrice());
                //下空单
                {
                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                    reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                    reqOrderInsertVO.setInstrumentId(instrumentId);
                    reqOrderInsertVO.setLimitPrice(ema.getLowerPrice().doubleValue());
                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                    reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                    reqOrderInsertVO.setDirection(Direction.SELL);
                    reqOrderInsertVO.setMinVolume(1);
                    reqOrderInsertVO.setVolumeTotalOriginal((int)volume);
                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                    orderService.reqOrderInsert(reqOrderInsertVO);
                    logger.info(instrumentId+"出现死叉，下空单");
                }
                
                //查询是否有多单
                List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId, "0");
                if(list != null && list.size() > 0){
                    //将多单平仓
                    for (OnRtnTradeVO onRtnTradeVO : list) {
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentId(instrumentId);
                        reqOrderInsertVO.setLimitPrice(ema.getLowerPrice().doubleValue());
                        if(onRtnTradeVO.getTradingDay().equals(ema.getTradingDay())) {
                            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                        }else {
                            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                        }
                        reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                        reqOrderInsertVO.setDirection(Direction.SELL);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(onRtnTradeVO.getVolume());
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        orderService.reqOrderInsert(reqOrderInsertVO);
                        logger.info(instrumentId+"出现金叉，平多单");
                    }
                }
                
            }
            
            //缓存本次EMA
            this.redisTemplate.opsForHash().put(instrumentId, "EMA5", ema);
            
          /*//先判断是否有持仓
            List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId);
            if(list != null && list.size() > 0){
                for (OnRtnTradeVO tradeVO : list) {
                  //判断是否需要止损  20点止损
                    String product = instrumentId.replaceAll("[^a-z^A-Z]", "");
                    //止盈止损参数
                    TargetProfit targetProfit = targetMap.get(product);
                    
                    double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                    if(tradeVO.getDirection() == Direction.BUY) {
                        //买开
                        if(tradeVO.getPrice() - tickPrice*targetProfit.getStopLessTick() >= ema.getClosePrice().doubleValue()) {
                            //止损
                            logger.info("触发止损"+instrumentId);
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                            reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                            reqOrderInsertVO.setInstrumentID(instrumentId);
                            reqOrderInsertVO.setLimitPrice(ema.getLowerPrice().doubleValue());
                            if(tradeVO.getTradingDay().equals(ema.getTradingDay())) {
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                            }else {
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                            }
                            reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                            reqOrderInsertVO.setDirection(Direction.SELL);
                            reqOrderInsertVO.setMinVolume(1);
                            reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                            orderService.reqOrderInsert(reqOrderInsertVO);
                        }
                        
                        //判断是否触发止盈
                        BigDecimal touch = (ema.getHighestPrice().subtract(ema.getLowestPrice())).divide(ema.getLowestPrice(), 2, RoundingMode.HALF_UP);
                        if(touch.compareTo(targetProfit.getTigger()) >= 0){
                            //判断回撤是否到位
                            //止盈价位 = 最高价-（最高价-最低价）*回撤比例
                            BigDecimal diff = ema.getHighestPrice()
                                    .subtract(ema.getHighestPrice().subtract(ema.getLowestPrice())
                                            .multiply(targetProfit.getBack())).setScale(2, RoundingMode.HALF_UP);
                            
                            if(ema.getClosePrice().compareTo(diff) <= 0){
                                //止盈
                                logger.info("触发止盈"+instrumentId);
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentID(instrumentId);
                                reqOrderInsertVO.setLimitPrice(ema.getLowerPrice().doubleValue());
                                if(tradeVO.getTradingDay().equals(ema.getTradingDay())) {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                }else {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                }
                                reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                reqOrderInsertVO.setDirection(Direction.SELL);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                orderService.reqOrderInsert(reqOrderInsertVO);
                            }
                        }
                        
                    }else {
                        //卖开
                        if(tradeVO.getPrice() + tickPrice*targetProfit.getStopLessTick() <= ema.getClosePrice().doubleValue()) {
                          //止损
                            logger.info("触发止损"+instrumentId);
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                            reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                            reqOrderInsertVO.setInstrumentID(instrumentId);
                            reqOrderInsertVO.setLimitPrice(ema.getUpperPrice().doubleValue());
                            if(tradeVO.getTradingDay().equals(ema.getTradingDay())) {
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                            }else {
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                            }
                            reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                            reqOrderInsertVO.setDirection(Direction.BUY);
                            reqOrderInsertVO.setMinVolume(1);
                            reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                            orderService.reqOrderInsert(reqOrderInsertVO);
                        }
                        
                        //判断是否触发止盈
                        BigDecimal touch = (ema.getHighestPrice().subtract(ema.getLowestPrice())).divide(ema.getHighestPrice(), 2, RoundingMode.HALF_UP);
                        if(touch.compareTo(targetProfit.getTigger()) >= 0){
                            //判断回撤是否到位
                            //止盈价位 = 最低价 +（最高价-最低价）*回撤比例
                            BigDecimal diff = ema.getLowestPrice()
                                    .add(ema.getHighestPrice().subtract(ema.getLowestPrice())
                                            .multiply(targetProfit.getBack())).setScale(2, RoundingMode.HALF_UP);
                            if(ema.getClosePrice().compareTo(diff) >= 0){
                                //止盈
                                logger.info("触发止盈"+instrumentId);
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentID(instrumentId);
                                reqOrderInsertVO.setLimitPrice(ema.getUpperPrice().doubleValue());
                                if(tradeVO.getTradingDay().equals(ema.getTradingDay())) {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                }else {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                }
                                reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                reqOrderInsertVO.setDirection(Direction.BUY);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                orderService.reqOrderInsert(reqOrderInsertVO);
                            }
                        }
                    }
                }
            }*/
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    

    /**
     * 止盈止损策略
     * @author BHQH-CXYWB
     *
     */
    public static class StopProfit implements Runnable{
        
        static Logger logger = Logger.getLogger(StopProfit.class);
        
        static final String ACCOUNT_NO = "00009";
        
        final private DepthMarketData marketData;
        
        final private OrderService orderService;
        
        final private CacheMap cacheMap;
        
        final private TradeDao tradeDao;
        
        final private StringRedisTemplate redisTemplate;
        
        public StopProfit(OrderService orderService, CacheMap cacheMap, TradeDao tradeDao, 
                DepthMarketData marketData, StringRedisTemplate redisTemplate) {
            this.orderService = orderService;
            this.cacheMap = cacheMap;
            this.tradeDao = tradeDao;
            this.marketData = marketData;
            this.redisTemplate = redisTemplate;
        }

        @Override
        public void run() {
            
            
            try {
                //先获取缓存中的指标信息
                String instrumentId = marketData.getInstrumentID();
                EMA oldEma = (EMA) this.redisTemplate.opsForHash().get(instrumentId, "EMA5");
                if(oldEma == null) {
                    return;
                }
                
                //更新最高价和最低价
                if(new BigDecimal(marketData.getLastPrice()).compareTo(oldEma.getHighestPrice()) > 0){
                    oldEma.setHighestPrice(new BigDecimal(marketData.getLastPrice()));
                    //缓存EMA
                    this.redisTemplate.opsForHash().put(instrumentId, "EMA5", oldEma);
                }
                if(new BigDecimal(marketData.getLastPrice()).compareTo(oldEma.getLowestPrice()) < 0){
                    oldEma.setLowestPrice(new BigDecimal(marketData.getLastPrice()));
                    //缓存EMA
                    this.redisTemplate.opsForHash().put(instrumentId, "EMA5", oldEma);
                }
                
                //先判断是否有持仓
                List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId);
                if(list != null && list.size() > 0){
                    for (OnRtnTradeVO tradeVO : list) {
                      //判断是否需要止损  20点止损
                        String product = instrumentId.replaceAll("[^a-z^A-Z]", "");
                        //止盈止损参数
                        TargetProfit targetProfit = targetMap.get(product);
                        
                        double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                        if(tradeVO.getDirection() == Direction.BUY) {
                            //买开
                            if(tradeVO.getPrice() - tickPrice*targetProfit.getStopLessTick() >= marketData.getLastPrice().doubleValue()) {
                                //止损
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentId(instrumentId);
                                reqOrderInsertVO.setLimitPrice(marketData.getLowerLimitPrice().doubleValue());
                                if(tradeVO.getTradingDay().equals(marketData.getTradingDate())) {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                }else {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                }
                                reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                reqOrderInsertVO.setDirection(Direction.SELL);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                orderService.reqOrderInsert(reqOrderInsertVO);
                                logger.info("触发止损"+instrumentId);
                            }
                            
                            //判断是否触发止盈
                            BigDecimal touch = (oldEma.getHighestPrice().subtract(oldEma.getLowestPrice())).divide(oldEma.getLowestPrice(), 3, RoundingMode.HALF_UP);
                            if(touch.compareTo(targetProfit.getTigger()) >= 0){
                                //判断回撤是否到位
                                //止盈价位 = 最高价-（最高价-最低价）*回撤比例
                                BigDecimal diff = oldEma.getHighestPrice()
                                        .subtract(oldEma.getHighestPrice().subtract(oldEma.getLowestPrice())
                                                .multiply(targetProfit.getBack())).setScale(2, RoundingMode.HALF_UP);
                                
                                if(new BigDecimal(marketData.getLastPrice()).compareTo(diff) <= 0){
                                    //止盈
                                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                    reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                    reqOrderInsertVO.setInstrumentId(instrumentId);
                                    reqOrderInsertVO.setLimitPrice(marketData.getLowerLimitPrice().doubleValue());
                                    if(tradeVO.getTradingDay().equals(marketData.getTradingDate())) {
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                    }else {
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                    }
                                    reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                    reqOrderInsertVO.setDirection(Direction.SELL);
                                    reqOrderInsertVO.setMinVolume(1);
                                    reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                    logger.info("触发止盈"+instrumentId);
                                }
                            }
                            
                        }else {
                            //卖开
                            if(tradeVO.getPrice() + tickPrice*targetProfit.getStopLessTick() <= marketData.getLastPrice().doubleValue()) {
                              //止损
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentId(instrumentId);
                                reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice().doubleValue());
                                if(tradeVO.getTradingDay().equals(marketData.getTradingDate())) {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                }else {
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                }
                                reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                reqOrderInsertVO.setDirection(Direction.BUY);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                orderService.reqOrderInsert(reqOrderInsertVO);
                                logger.info("触发止损"+instrumentId);
                            }
                            
                            //判断是否触发止盈
                            BigDecimal touch = (oldEma.getHighestPrice().subtract(oldEma.getLowestPrice())).divide(oldEma.getHighestPrice(), 3, RoundingMode.HALF_UP);
                            if(touch.compareTo(targetProfit.getTigger()) >= 0){
                                //判断回撤是否到位
                                //止盈价位 = 最低价 +（最高价-最低价）*回撤比例
                                BigDecimal diff = oldEma.getLowestPrice()
                                        .add(oldEma.getHighestPrice().subtract(oldEma.getLowestPrice())
                                                .multiply(targetProfit.getBack())).setScale(2, RoundingMode.HALF_UP);
                                if(new BigDecimal(marketData.getLastPrice()).compareTo(diff) >= 0){
                                    //止盈
                                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                    reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                    reqOrderInsertVO.setInstrumentId(instrumentId);
                                    reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice().doubleValue());
                                    if(tradeVO.getTradingDay().equals(marketData.getTradingDate())) {
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                    }else {
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                    }
                                    reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                    reqOrderInsertVO.setDirection(Direction.BUY);
                                    reqOrderInsertVO.setMinVolume(1);
                                    reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                    logger.info("触发止盈"+instrumentId);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }
    
}
