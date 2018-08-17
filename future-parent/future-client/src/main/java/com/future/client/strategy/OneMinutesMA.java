package com.future.client.strategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.client.ClientStarter;
import com.future.client.EMAStarter;
import com.future.client.dao.TradeDao;
import com.future.client.utils.CacheMap;
import com.future.client.utils.SpringContextUtil;
import com.future.common.exception.CommonFutureException;
import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;
import com.future.quota.api.vo.MA;

public class OneMinutesMA implements Runnable {
    
    //对冲子账号
    static final String ACCOUNT_NO = "00010";
    
    //被对冲的账号
    static final String ORIG_ACCOUNT_NO = "00009";
    
    private static OneMinutesMA oneMinutesMA;
    
    private static LinkedBlockingQueue<MA> maQueue = new LinkedBlockingQueue<>();
    
    private Map<String, MA> maMap = new HashMap<>();
    
    private TradeDao tradeDao;
    
    private OrderService orderService;
    
    
    @Override
    public void run() {

        while (true) {
            
            MA ma = null;
            try {
                ma = maQueue.take();
            } catch (InterruptedException e) {
                continue;
            }
            
            String instrumentId = ma.getInstrumentId();
            
            MA oldMA = maMap.get(instrumentId);
            if(oldMA == null && ma.getLastPrice().compareTo(ma.getMa5())!=0){
                maMap.put(instrumentId, ma);
                continue;
            }
            
            //查询需要对冲账户的持仓信息
            List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ORIG_ACCOUNT_NO, instrumentId);
            if(list == null||list.size() < 1){
                //TODO 清对冲仓位
                continue;
            }
            
            for (OnRtnTradeVO onRtnTradeVO : list) {
                if(onRtnTradeVO.getDirection() == Direction.BUY){
                    //买开 涨幅超过3% 一手对冲
                    double touch = (ma.getLastPrice().doubleValue()-onRtnTradeVO.getPrice())/onRtnTradeVO.getPrice();
                    if(touch > 0.03){
                        //查询对冲账户是否有对冲持仓
                        List<OnRtnTradeVO> hedgingList = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"1");
                        if(hedgingList == null || hedgingList.size() < 1 ){
                            //判断是否死叉
                            BigDecimal o = oldMA.getLastPrice().subtract(oldMA.getMa5());
                            BigDecimal n = ma.getLastPrice().subtract(ma.getMa5());
                            //死叉 对冲一手
                            if(o.compareTo(BigDecimal.ZERO) > 0 && n.compareTo(BigDecimal.ZERO) < 0){
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentId(instrumentId);
                                reqOrderInsertVO.setLimitPrice(ma.getLowerPrice().doubleValue());
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                reqOrderInsertVO.setDirection(Direction.SELL);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(1);
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                try {
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                } catch (CommonFutureException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            
        }

    }
    
    public static void START(){
        if(oneMinutesMA == null){
            Thread thread = new Thread(oneMinutesMA);
            thread.start();
        }
    }
    
    /**
     * 对冲策略
     * @author caojia
     *
     */
    public static class Hedging implements Runnable {
        
        
        //止盈跳数
        private static final int STOP_TICK = 1;
        
        public static final LinkedBlockingQueue<DepthMarketData> MARKET_QUEUE = new LinkedBlockingQueue<>();

        final private OrderService orderService;
        
        final private CacheMap cacheMap;
        
        final private TradeDao tradeDao;
        
        final private StringRedisTemplate redisTemplate;
        
        private static Hedging hedging;
        
        public Hedging(OrderService orderService, CacheMap cacheMap, 
                TradeDao tradeDao, StringRedisTemplate redisTemplate) {
            this.orderService = orderService;
            this.cacheMap = cacheMap;
            this.tradeDao = tradeDao;
            this.redisTemplate = redisTemplate;
        }
        
        @Override
        public void run() {

            while (true) {
                try {
                    DepthMarketData marketData = MARKET_QUEUE.take();
                
                
                    String instrumentId = marketData.getInstrumentID();
                    double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                    List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId);
                    if(list != null && list.size() > 0) {
                        for (OnRtnTradeVO tradeVO : list) {
                            
                            if(tradeVO.getDirection() == Direction.BUY) {
                                //买开
                                if(tradeVO.getPrice() + tickPrice*STOP_TICK <= marketData.getBidPrice1().doubleValue()) {
                                    
                                    //止赢
                                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                    reqOrderInsertVO.setInvestorId(EMAStarter.INVESTOR_ID);
                                    reqOrderInsertVO.setInstrumentId(instrumentId);
                                    reqOrderInsertVO.setLimitPrice(marketData.getBidPrice1().doubleValue());
                                    if(tradeVO.getTradingDay().equals(marketData.getTradingDate())) {
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                    }else {
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                    }
                                    reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                    reqOrderInsertVO.setDirection(Direction.SELL);
                                    reqOrderInsertVO.setMinVolume(1);
                                    reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                }
                            }else {
                                //卖开
                                if(tradeVO.getPrice() - tickPrice*STOP_TICK >= marketData.getAskPrice1().doubleValue()) {
                                    
                                    //止赢
                                      ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                      reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                      reqOrderInsertVO.setInvestorId(EMAStarter.INVESTOR_ID);
                                      reqOrderInsertVO.setInstrumentId(instrumentId);
                                      reqOrderInsertVO.setLimitPrice(marketData.getAskPrice1().doubleValue());
                                      if(tradeVO.getTradingDay().equals(marketData.getTradingDate())) {
                                          reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                                      }else {
                                          reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CLOSE);
                                      }
                                      reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                      reqOrderInsertVO.setDirection(Direction.BUY);
                                      reqOrderInsertVO.setMinVolume(1);
                                      reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                                      reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                      orderService.reqOrderInsert(reqOrderInsertVO);
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
        
        private Hedging(){
            this.cacheMap = (CacheMap) SpringContextUtil.getBean("cacheMap");
            this.orderService = (OrderService) SpringContextUtil.getBean("orderService");
            this.tradeDao = (TradeDao) SpringContextUtil.getBean("tradeDao");
            this.redisTemplate = (StringRedisTemplate) SpringContextUtil.getBean("redisTemplate");
        }
        
        public static void START(){
            if(hedging == null){
                hedging = new Hedging();
            }
            new Thread(hedging).start();
        }
        
        public static void offerMarket(DepthMarketData marketData){
            MARKET_QUEUE.offer(marketData);
        }
        
    }

}
