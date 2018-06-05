package com.future.client.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.future.client.ClientStarter;
import com.future.client.dao.TradeDao;
import com.future.client.utils.CacheMap;
import com.future.client.utils.SpringContextUtil;
import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;

/**
 * 价格跟随策略（高频）
 * @author caojia
 * n跳里价格波动超过f跳，则跟随
 *
 */
public class PriceFollow implements Runnable{
    
    static Logger logger = Logger.getLogger(PriceFollow.class);
    
    /**
     * 行情队列
     */
    public static LinkedBlockingQueue<DepthMarketData> MARKET_QUEUE = new LinkedBlockingQueue<>();

    private static Map<String,LinkedBlockingQueue<Double>> priceMap = new HashMap<>();
    
    private static final String ACCOUNT_NO = "12345";
    
    private static final int FLUCTUATE_TICK = 3;
    
    private static final int QUEUE_LENTH = 5;
    
    private DepthMarketData marketData;
    
    private final CacheMap cacheMap;
    
    private final OrderService orderService;
    
    private final TradeDao tradeDao;
    
    private static PriceFollow priceFollow;
    
    public PriceFollow(DepthMarketData marketData, CacheMap cacheMap, OrderService orderService, TradeDao tradeDao) {
        this.marketData = marketData;
        this.cacheMap = cacheMap;
        this.orderService = orderService;
        this.tradeDao = tradeDao;
    }
    
    public PriceFollow(){
        this.cacheMap = (CacheMap) SpringContextUtil.getBean("cacheMap");
        this.orderService = (OrderService) SpringContextUtil.getBean("orderService");
        this.tradeDao = (TradeDao) SpringContextUtil.getBean("tradeDao");
    }

    @Override
    public void run() {
        
        try {
            
            
            while (true) {
                DepthMarketData marketData = MARKET_QUEUE.take();
                
                String instrumentID = marketData.getInstrumentID();
                LinkedBlockingQueue<Double> priceQueue = priceMap.get(instrumentID);
                if(priceQueue == null){
                    priceQueue = new LinkedBlockingQueue<>();
                    priceMap.put(instrumentID, priceQueue);
                }
                
                priceQueue.offer(marketData.getLastPrice());
                
                if(priceQueue.size() < QUEUE_LENTH){
                    continue;
                }
                
                Double tickPrice = this.cacheMap.getTickPrice(instrumentID);
                
                //之前5跳的价格
                Double passPrice = priceQueue.take();
                //现在的最新价
                Double lastPrice = marketData.getLastPrice();
                
                if(lastPrice - passPrice >= tickPrice * FLUCTUATE_TICK){
                    List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentID, "0");
                    if(list != null && list.size() >0) {
                        //有仓位不再开
                        continue;
                    }
                    
                    //挂单量少则抢反弹
                    if(marketData.getBidVolume1()*3 < marketData.getAskVolume1()){
                        List<OnRtnTradeVO> l = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentID, "1");
                        if(l == null || l.size() < 1){
                            //做空期望反弹
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                            reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                            reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                            reqOrderInsertVO.setLimitPrice(marketData.getLowerLimitPrice());
                            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                            reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                            reqOrderInsertVO.setDirection(Direction.SELL);
                            reqOrderInsertVO.setMinVolume(1);
                            reqOrderInsertVO.setVolumeTotalOriginal(1);
                            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                            orderService.reqOrderInsert(reqOrderInsertVO);
                        }
                        continue;
                    }
                    
                    priceQueue.clear();
                    //价格涨了5跳，跟单做多
                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                    reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                    reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                    reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice());
                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                    reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                    reqOrderInsertVO.setDirection(Direction.BUY);
                    reqOrderInsertVO.setMinVolume(1);
                    reqOrderInsertVO.setVolumeTotalOriginal(1);
                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                    orderService.reqOrderInsert(reqOrderInsertVO);
                    logger.info("追涨");
                }else if (passPrice - lastPrice >= tickPrice * FLUCTUATE_TICK ) {
                    List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentID, "1");
                    if(list != null && list.size() >0) {
                        //有仓位不再开
                        continue;
                    }
                    
                    //挂单量少则期望反弹
                    if(marketData.getAskVolume1()*3 < marketData.getBidVolume1()){
                        List<OnRtnTradeVO> l = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentID, "0");
                        if(l == null || l.size() < 1){
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                            reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                            reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                            reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice());
                            reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                            reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                            reqOrderInsertVO.setDirection(Direction.BUY);
                            reqOrderInsertVO.setMinVolume(1);
                            reqOrderInsertVO.setVolumeTotalOriginal(1);
                            reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                            orderService.reqOrderInsert(reqOrderInsertVO);
                        }
                        
                        continue;
                    }
                    
                    priceQueue.clear();
                    //价格跌了5跳，跟单做空
                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                    reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                    reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                    reqOrderInsertVO.setLimitPrice(marketData.getLowerLimitPrice());
                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                    reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                    reqOrderInsertVO.setDirection(Direction.SELL);
                    reqOrderInsertVO.setMinVolume(1);
                    reqOrderInsertVO.setVolumeTotalOriginal(1);
                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                    orderService.reqOrderInsert(reqOrderInsertVO);
                    logger.info("追跌");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void START(){
        if(priceFollow == null){
            priceFollow = new PriceFollow();
        }
        new Thread(priceFollow).start();
    }
    
    public static void offerMarket(DepthMarketData marketData){
        MARKET_QUEUE.offer(marketData);
    }
    
    
    /**
     * 止盈策略
     * @author caojia
     *
     */
    public static class StopProfit implements Runnable{
        
        private static final int STOP_WIN = 1;
        
        private static final int STOP_LOSS = 2;
        
        private final DepthMarketData marketData;
        
        private final CacheMap cacheMap;
        
        private final OrderService orderService;
        
        private final TradeDao tradeDao;
        
        public StopProfit(DepthMarketData marketData, CacheMap cacheMap, OrderService orderService, TradeDao tradeDao) {
            this.marketData = marketData;
            this.cacheMap = cacheMap;
            this.orderService = orderService;
            this.tradeDao = tradeDao;
        }

        @Override
        public void run() {
            
            try {
                String instrumentId = marketData.getInstrumentID();
                double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                
                List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId);
                
                if(list != null && list.size() > 0){
                    for (OnRtnTradeVO tradeVO : list) {
                        
                        if(tradeVO.getDirection() == Direction.BUY) {
                            //买开
                            if(tradeVO.getPrice() + tickPrice*STOP_WIN <= marketData.getBidPrice1().doubleValue()) {
                                
                                //买挂单支撑强则继续持有
                                if(marketData.getBidVolume1()*2 >= marketData.getAskVolume1()){
                                    continue;
                                }
                                
                                //止赢
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentID(instrumentId);
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
                            }else if (tradeVO.getPrice() - tickPrice*(STOP_LOSS) >= marketData.getBidPrice1().doubleValue()) {
                                
                              //买挂单支撑强则继续持有
                                if(marketData.getBidVolume1()*2 >= marketData.getAskVolume1()){
                                    continue;
                                }
                              //止损
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentID(instrumentId);
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
                            if(tradeVO.getPrice() - tickPrice*STOP_WIN >= marketData.getAskPrice1().doubleValue()) {
                                
                                //卖单支撑强则继续持有
                                if(marketData.getAskVolume1()*2 >= marketData.getBidVolume1()){
                                    continue;
                                }
                                //止赢
                                  ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                  reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                  reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                                  reqOrderInsertVO.setInstrumentID(instrumentId);
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
                              }else if (tradeVO.getPrice() + tickPrice*(STOP_LOSS) <= marketData.getAskPrice1().doubleValue()) {
                                  
                                //卖单支撑强则继续持有
                                  if(marketData.getAskVolume1()*2 >= marketData.getBidVolume1()){
                                      continue;
                                  }
                                //止损
                                  ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                  reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                  reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                                  reqOrderInsertVO.setInstrumentID(instrumentId);
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
    
    
}
