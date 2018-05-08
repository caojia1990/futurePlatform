package com.future.client.strategy;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.client.ClientStarter;
import com.future.client.utils.CacheMap;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombHedgeFlag;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.ContingentCondition;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.ForceCloseReason;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;
import com.future.order.api.vo.VolumeCondition;
import com.future.quota.api.vo.EMA;

public class FiveMinutesEMA implements Runnable {
    
    static final String ACCOUNT_NO = "00009";
    
    final private OrderService orderService;
    
    final private EMA ema;
    
    final private StringRedisTemplate redisTemplate;
    
    final private CacheMap cacheMap;
    
    public FiveMinutesEMA(OrderService orderService, EMA ema, StringRedisTemplate redisTemplate, CacheMap cacheMap) {
        this.orderService = orderService;
        this.ema = ema;
        this.redisTemplate = redisTemplate;
        this.cacheMap = cacheMap;
    }

    @Override
    public void run() {
        
        try {
            //先获取缓存中的指标信息
            String instrumentId = ema.getInstrumentId();
            EMA oldEma = (EMA) this.redisTemplate.opsForHash().get(instrumentId, "EMA5");
            if(oldEma == null) {
                this.redisTemplate.opsForHash().put(instrumentId, "EMA5", ema);
                return;
            }
            
            
            
            int oldflag = oldEma.getEma5().compareTo(oldEma.getEma619());
            int newflag = ema.getEma5().compareTo(ema.getEma619());
            if(oldflag < 0 && newflag >0) {
                //金叉
                
            }
            
            
            //先判断是否有持仓
            OnRtnTradeVO tradeVO = (OnRtnTradeVO) this.redisTemplate.opsForHash().get(ACCOUNT_NO, instrumentId);
            if(tradeVO != null) {
                //判断是否需要止损  20点止损
                double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                if(tradeVO.getDirection() == Direction.BUY) {
                    //买开
                    if(tradeVO.getPrice() - tickPrice*20 >= ema.getClosePrice().doubleValue()) {
                        //止损
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
                    
                }else {
                    //卖开
                    if(tradeVO.getPrice() + tickPrice*20 <= ema.getClosePrice().doubleValue()) {
                      //止损
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
                        reqOrderInsertVO.setDirection(Direction.BUY);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(tradeVO.getVolume());
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }
                }
                
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
