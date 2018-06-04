package com.future.client.strategy;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import com.future.client.ClientStarter;
import com.future.client.dao.TradeDao;
import com.future.client.utils.CacheMap;
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
 * 5跳里价格波动超过5跳，则跟随
 *
 */
public class PriceFollow implements Runnable{

    private static LinkedBlockingQueue<Double> priceQueue = new LinkedBlockingQueue<>();
    
    private static final String ACCOUNT_NO = "12345";
    
    private static final int FLUCTUATE_TICK = 5;
    
    private final DepthMarketData marketData;
    
    private final CacheMap cacheMap;
    
    private final OrderService orderService;
    
    public PriceFollow(DepthMarketData marketData, CacheMap cacheMap, OrderService orderService) {
        this.marketData = marketData;
        this.cacheMap = cacheMap;
        this.orderService = orderService;
    }

    @Override
    public void run() {
        
        try {
            
            String instrumentID = this.marketData.getInstrumentID();
            
            priceQueue.offer(marketData.getLastPrice());
            
            if(priceQueue.size() < 6){
                return;
            }
            
            Double tickPrice = this.cacheMap.getTickPrice(instrumentID);
            
            //之前5跳的价格
            Double passPrice = priceQueue.take();
            //现在的最新价
            Double lastPrice = marketData.getLastPrice();
            
            if(lastPrice - passPrice >= tickPrice * FLUCTUATE_TICK){
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
            }else if (passPrice - lastPrice >= tickPrice * FLUCTUATE_TICK ) {
                priceQueue.clear();
                //价格跌了5跳，跟单做空
                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice());
                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                reqOrderInsertVO.setDirection(Direction.SELL);
                reqOrderInsertVO.setMinVolume(1);
                reqOrderInsertVO.setVolumeTotalOriginal(1);
                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                orderService.reqOrderInsert(reqOrderInsertVO);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    /**
     * 止盈策略
     * @author caojia
     *
     */
    public static class StopProfit implements Runnable{
        
        private static final int STOP_TICK = 1;
        
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
                            if(tradeVO.getPrice() + tickPrice*STOP_TICK <= marketData.getBidPrice1().doubleValue()) {
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
                            }
                        }else {
                            //卖开
                            if(tradeVO.getPrice() - tickPrice*STOP_TICK >= marketData.getAskPrice1().doubleValue()) {
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
