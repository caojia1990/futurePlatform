package com.future.client.strategy;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.client.ClientStarter;
import com.future.client.utils.CacheMap;
import com.future.market.api.vo.DepthMarketData;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;

public class Hedging implements Runnable {
    
    static Logger logger = Logger.getLogger(Hedging.class);
    
    private final static String STRATEGY_NAME = "对冲保护";
    
    static final String ACCOUNT_NO = "00003";
    
    private final DepthMarketData marketData;
    
    private final StringRedisTemplate redisTemplate;
    
    private final CacheMap cacheMap;
    
    private final OrderService orderService;
    
    public Hedging(DepthMarketData marketData, OrderService orderService, StringRedisTemplate redisTemplate, CacheMap cacheMap) {
        this.marketData = marketData;
        this.redisTemplate = redisTemplate;
        this.cacheMap = cacheMap;
        this.orderService = orderService;
    }

    @Override
    public void run() {
        
        try {
            String instrumentID = this.marketData.getInstrumentID();
            
            OnRtnTradeVO tradeVO = (OnRtnTradeVO) this.redisTemplate.opsForHash().get(FiveSecsFollow.ACCOUNT_NO, instrumentID);
            
            if(tradeVO != null ){
                
                String flag = (String) this.redisTemplate.opsForHash().get(STRATEGY_NAME, marketData.getInstrumentID());
                if(flag == null) {
                    
                    //买开
                    if(tradeVO.getDirection() == Direction.BUY){
                        
                        //500止损
                        if((tradeVO.getPrice() - marketData.getBidPrice1())*this.cacheMap.getInstrument(instrumentID).getVolumeMultiple() >= 500) {
                            //if(tradeVO.getPrice() >= (marketData.getBidPrice1().doubleValue() + 10*this.cacheMap.getTickPrice(marketData.getInstrumentID()))){
                            //对冲反向开仓
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
                            if(logger.isInfoEnabled()){
                                logger.info("触发对冲保护");
                            }
                            //策略标记  只开仓一次
                            this.redisTemplate.opsForHash().put(STRATEGY_NAME, marketData.getInstrumentID(), "1");
                            
                            orderService.reqOrderInsert(reqOrderInsertVO);
                        }
                    }else {
                        //卖开
                        if((marketData.getAskPrice1() - tradeVO.getPrice()) * this.cacheMap.getInstrument(instrumentID).getVolumeMultiple() >= 500) {
                            //if(tradeVO.getPrice() <= (marketData.getAskPrice1().doubleValue() - 10*this.cacheMap.getTickPrice(marketData.getInstrumentID()))){
                            
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
                            if(logger.isInfoEnabled()){
                                logger.info("触发对冲保护");
                            }
                            this.redisTemplate.opsForHash().put(STRATEGY_NAME, marketData.getInstrumentID(), "1");
                            orderService.reqOrderInsert(reqOrderInsertVO);
                            
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("线程异常",e);
        }
        
    }

}
