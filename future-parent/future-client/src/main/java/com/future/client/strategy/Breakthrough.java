package com.future.client.strategy;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.client.ClientStarter;
import com.future.client.dao.QuotaDao;
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
    
    private final static String STRATEGY_NAME = "突破前值";
    
    private static final String ACCOUNT_NO = "00002";
    
    private final DepthMarketData marketData;
    
    private final OrderService orderService;
    
    private StringRedisTemplate redisTemplate;
    
    private final CacheMap cacheMap;
    
    private final QuotaDao quotaDao;
    
    public Breakthrough(DepthMarketData marketData, OrderService orderService, 
            StringRedisTemplate redisTemplate, CacheMap cacheMap, QuotaDao quotaDao) {
        this.cacheMap = cacheMap;
        this.redisTemplate = redisTemplate;
        this.orderService = orderService;
        this.marketData = marketData;
        this.quotaDao = quotaDao;
    }

    @Override
    public void run() {
        try {
            if(logger.isInfoEnabled()){
                //logger.info(marketData);
            }
            String updateTime = marketData.getUpdateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse(updateTime, formatter);
            
           /* Map<String, Object> map = null;
            if(time.isAfter(LocalTime.parse("09:00:00")) && time.isBefore(LocalTime.parse("14:59:59"))){
                try {
                     map = this.quotaDao.selectByInstrumentID(marketData.getInstrumentID());
                    if(map != null){
                        if((double)map.get("HIGHEST_PRICE") < marketData.getLastPrice()){
                            this.quotaDao.updateHighestPrice(marketData.getInstrumentID(), marketData.getLastPrice());
                        }else if ((double)map.get("LOWEST_PRICE") > marketData.getLastPrice()) {
                            this.quotaDao.updateLowestPrice(marketData.getInstrumentID(), marketData.getLastPrice());
                        }
                    }
                } catch (EmptyResultDataAccessException e) {
                    this.quotaDao.insert(marketData.getInstrumentID(), marketData.getLastPrice(), marketData.getLastPrice());
                }
                
            }*/
            
            OnRtnTradeVO tradeVO = (OnRtnTradeVO) this.redisTemplate.opsForHash().get(ACCOUNT_NO, marketData.getInstrumentID());
            String flag = (String) this.redisTemplate.opsForHash().get(STRATEGY_NAME, marketData.getInstrumentID());
            if(tradeVO == null && flag == null){
                
                if((time.isAfter(LocalTime.parse("21:15:00")) && time.isBefore(LocalTime.parse("23:59:59"))) || 
                        (time.isAfter(LocalTime.parse("09:15:00")) && time.isBefore(LocalTime.parse("14:59:59")))){
                    
                    //if(marketData.getAskPrice1().doubleValue() == (double)map.get("HIGHEST_PRICE")){
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
                        if(logger.isInfoEnabled()){
                            logger.info(marketData);
                            logger.info("触发下单");
                        }
                        tradeVO = new OnRtnTradeVO();
                        tradeVO.setInstrumentID(marketData.getInstrumentID());
                        this.redisTemplate.opsForHash().put(ACCOUNT_NO, marketData.getInstrumentID(), tradeVO);
                        
                        //策略标记  只开仓一次
                        this.redisTemplate.opsForHash().put(STRATEGY_NAME, marketData.getInstrumentID(), "1");
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }else if (marketData.getBidPrice1().doubleValue() == marketData.getLowestPrice().doubleValue()) {
                    //}else if (marketData.getBidPrice1().doubleValue() == (double)map.get("LOWEST_PRICE")) {
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
                        if(logger.isInfoEnabled()){
                            logger.info(marketData);
                            logger.info("触发下单");
                        }
                        tradeVO = new OnRtnTradeVO();
                        tradeVO.setInstrumentID(marketData.getInstrumentID());
                        this.redisTemplate.opsForHash().put(ACCOUNT_NO, marketData.getInstrumentID(), tradeVO);
                        this.redisTemplate.opsForHash().put(STRATEGY_NAME, marketData.getInstrumentID(), "1");
                        orderService.reqOrderInsert(reqOrderInsertVO);
                    }
                }
                
            }else if(tradeVO != null && tradeVO.getTradeID() != null){
                
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
                        if(logger.isInfoEnabled()){
                            logger.info(marketData);
                            logger.info("触发止盈");
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
                        if(logger.isInfoEnabled()){
                            logger.info(marketData);
                            logger.info("触发止盈");
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
