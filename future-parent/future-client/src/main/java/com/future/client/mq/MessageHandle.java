package com.future.client.mq;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;

import com.future.client.ClientStarter;
import com.future.client.utils.CacheMap;
import com.future.market.api.mq.MessageReceive;
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

public class MessageHandle implements MessageReceive{
    
    static Logger logger = Logger.getLogger(MessageHandle.class);
    
    @Autowired
    private OrderService orderService;
    
    private Map<String, ReqOrderInsertVO> map = new HashMap<>();
    
    @Resource(name="redisTemplate")
    private ValueOperations<String , OnRtnTradeVO> valueOperations;
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String, OnRtnTradeVO> hashOperations;
    
    @Autowired
    private CacheMap cacheMap;

    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        try {
            if(logger.isDebugEnabled()){
                //logger.debug(marketData);
            }
            String updateTime = marketData.getUpdateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse(updateTime, formatter);
            
            if(map.get(marketData.getInstrumentID()) == null){
                
                //if(time.isAfter(LocalTime.parse("09:06:06")) && time.isBefore(LocalTime.parse("09:00:06"))){
                    
                    if(marketData.getAskPrice1().doubleValue() == marketData.getHighestPrice().doubleValue()){
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo("00001");
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
                        orderService.reqOrderInsert(reqOrderInsertVO);
                        map.put(marketData.getInstrumentID(), reqOrderInsertVO);
                    }else if (marketData.getBidPrice1().doubleValue() == marketData.getLowestPrice().doubleValue()) {
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo("00001");
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
                        orderService.reqOrderInsert(reqOrderInsertVO);
                        map.put(marketData.getInstrumentID(), reqOrderInsertVO);
                    }
                //}
            
                
            }else {
                
                OnRtnTradeVO tradeVO = this.hashOperations.get("00001", marketData.getInstrumentID());
                
                if(tradeVO != null){
                    if(tradeVO.getDirection() == Direction.BUY){
                        if(marketData.getBidPrice1().doubleValue() >= (tradeVO.getPrice()+ 2*this.cacheMap.getTickPrice(marketData.getInstrumentID()))) {
                            //两跳止盈
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo("00001");
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
                            //map.remove(marketData.getInstrumentID());
                        }
                    }else {
                        if(tradeVO.getPrice() >= (marketData.getAskPrice1().doubleValue() + 2*this.cacheMap.getTickPrice(marketData.getInstrumentID()))) {
                            //两跳止盈
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo("00001");
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
                            //map.remove(marketData.getInstrumentID());
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
