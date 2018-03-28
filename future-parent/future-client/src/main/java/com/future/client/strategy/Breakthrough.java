package com.future.client.strategy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.HashOperations;

import com.future.client.ClientStarter;
import com.future.client.utils.CacheMap;
import com.future.market.api.vo.DepthMarketData;
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

/**
 * 突破前值
 * @author caojia
 */
public class Breakthrough implements Runnable{
    
    static Logger logger = Logger.getLogger(Breakthrough.class);
    
    private static final String ACCOUNT_NO = "00002";
    
    private final DepthMarketData marketData;
    
    private final OrderService orderService;
    
    private final HashOperations<String, String, OnRtnTradeVO> hashOperations;
    
    private final CacheMap cacheMap;
    
    public Breakthrough(DepthMarketData marketData, OrderService orderService, 
            HashOperations<String, String, OnRtnTradeVO> hashOperations, CacheMap cacheMap) {
        this.cacheMap = cacheMap;
        this.hashOperations = hashOperations;
        this.orderService = orderService;
        this.marketData = marketData;
    }

    @Override
    public void run() {
        try {
            if(logger.isDebugEnabled()){
                //logger.debug(marketData);
            }
            String updateTime = marketData.getUpdateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse(updateTime, formatter);
            
            OnRtnTradeVO tradeVO = this.hashOperations.get(ACCOUNT_NO, marketData.getInstrumentID());
            if(tradeVO == null){
                
                if((time.isAfter(LocalTime.parse("21:30:00")) && time.isBefore(LocalTime.parse("23:59:59"))) || 
                        (time.isAfter(LocalTime.parse("09:30:00")) && time.isBefore(LocalTime.parse("14:59:59")))){
                    
                    if(marketData.getAskPrice1().doubleValue() == marketData.getHighestPrice().doubleValue()){
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                        reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice());
                        reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                        reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                        reqOrderInsertVO.setDirection(Direction.BUY);
                        reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(1);
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
                        reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
                        if(logger.isDebugEnabled()){
                            logger.debug(marketData);
                            logger.debug("触发下单");
                        }
                        tradeVO = new OnRtnTradeVO();
                        tradeVO.setInstrumentID(marketData.getInstrumentID());
                        this.hashOperations.put(ACCOUNT_NO, marketData.getInstrumentID(), tradeVO);
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }else if (marketData.getBidPrice1().doubleValue() == marketData.getLowestPrice().doubleValue()) {
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                        reqOrderInsertVO.setLimitPrice(marketData.getLowerLimitPrice());
                        reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                        reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                        reqOrderInsertVO.setDirection(Direction.SELL);
                        reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(1);
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
                        reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
                        if(logger.isDebugEnabled()){
                            logger.debug(marketData);
                            logger.debug("触发下单");
                        }
                        tradeVO = new OnRtnTradeVO();
                        tradeVO.setInstrumentID(marketData.getInstrumentID());
                        this.hashOperations.put(ACCOUNT_NO, marketData.getInstrumentID(), tradeVO);
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }
                }
                
            }else if(tradeVO.getTradeID() != null){
                
                if(tradeVO.getDirection() == Direction.BUY){
                    if(marketData.getBidPrice1().doubleValue() >= (tradeVO.getPrice()+ 2*this.cacheMap.getTickPrice(marketData.getInstrumentID()))) {
                        //两跳止盈
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                        reqOrderInsertVO.setLimitPrice(marketData.getLowerLimitPrice());
                        reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                        reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                        reqOrderInsertVO.setDirection(Direction.SELL);
                        reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(1);
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
                        reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
                        if(logger.isDebugEnabled()){
                            logger.debug(marketData);
                            logger.debug("触发止盈");
                        }
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }
                }else {
                    if(tradeVO.getPrice() >= (marketData.getAskPrice1().doubleValue() + 2*this.cacheMap.getTickPrice(marketData.getInstrumentID()))) {
                        //两跳止盈
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorID(ClientStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentID(marketData.getInstrumentID());
                        reqOrderInsertVO.setLimitPrice(marketData.getUpperLimitPrice());
                        reqOrderInsertVO.setCombHedgeFlag(CombHedgeFlag.Speculation);
                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.CloseToday);
                        reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                        reqOrderInsertVO.setDirection(Direction.BUY);
                        reqOrderInsertVO.setVolumeCondition(VolumeCondition.AV);
                        reqOrderInsertVO.setMinVolume(1);
                        reqOrderInsertVO.setVolumeTotalOriginal(1);
                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                        reqOrderInsertVO.setContingentCondition(ContingentCondition.Immediately);
                        reqOrderInsertVO.setForceCloseReason(ForceCloseReason.NotForceClose);
                        if(logger.isDebugEnabled()){
                            logger.debug(marketData);
                            logger.debug("触发止盈");
                        }
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        
    }
    
    
}
