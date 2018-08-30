package com.future.client.strategy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;

import com.future.client.ClientStarter;
import com.future.client.EMAStarter;
import com.future.client.dao.TradeDao;
import com.future.client.utils.CacheMap;
import com.future.common.exception.CommonFutureException;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.CombOffsetFlag;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.order.api.vo.TimeCondition;
import com.future.quota.api.vo.MA;

public class OneMinutesMA implements Runnable {
    
    static Logger logger = Logger.getLogger(OneMinutesMA.class);
    
    //对冲子账号
    static final String ACCOUNT_NO = "unknow";
    
    //被对冲的账号
    static final String ORIG_ACCOUNT_NO = "00009";
    
    //止盈跳数
    private static final int STOP_TICK = 1;
    
    private static OneMinutesMA oneMinutesMA;
    
    private static LinkedBlockingQueue<MA> maQueue = new LinkedBlockingQueue<>();
    
    private Map<String, MA> maMap = new HashMap<>();
    
    //记录下单信息
    private static Map<String, ReqOrderInsertVO> orderMap = new HashMap<>();
    
    private final TradeDao tradeDao;
    
    private final OrderService orderService;
    
    private final CacheMap cacheMap;
    
    
    @Override
    public void run() {

        while (true) {
            
            MA ma = null;
            try {
                ma = maQueue.take();
            } catch (InterruptedException e) {
                continue;
            }
            
            try {
                this.stopProfit(ma);
            } catch (CommonFutureException e) {
                logger.error("止盈异常",e);
            }
            
            String instrumentId = ma.getInstrumentId();
            
            MA oldMA = maMap.get(instrumentId);
            if(oldMA == null){
                if(ma.getLastPrice().compareTo(ma.getMa5())!=0){
                    maMap.put(instrumentId, ma);
                }
                continue;
            }
            
            //查询需要对冲账户的持仓信息
            List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ORIG_ACCOUNT_NO, instrumentId);
            if(list == null||list.size() < 1){
                if(ma.getLastPrice().compareTo(ma.getMa5())!=0){
                    maMap.put(instrumentId, ma);
                }
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
                                    logger.info("1分钟MA死叉，对冲一手");
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                } catch (CommonFutureException e) {
                                    logger.error("下单失败",e);
                                }
                                //记录下单缓存
                                orderMap.put(instrumentId, reqOrderInsertVO);
                            }
                        }
                    }
                }else {
                    //卖开
                    double touch = (onRtnTradeVO.getPrice()-ma.getLastPrice().doubleValue())/onRtnTradeVO.getPrice();
                    if(touch > 0.03){
                      //查询对冲账户是否有对冲持仓
                        List<OnRtnTradeVO> hedgingList = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"0");
                        if(hedgingList == null || hedgingList.size() < 1 ){
                            //判断是否金叉
                            BigDecimal o = oldMA.getLastPrice().subtract(oldMA.getMa5());
                            BigDecimal n = ma.getLastPrice().subtract(ma.getMa5());
                            //金叉 对冲一手
                            if(o.compareTo(BigDecimal.ZERO) < 0 && n.compareTo(BigDecimal.ZERO) > 0){
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentId(instrumentId);
                                reqOrderInsertVO.setLimitPrice(ma.getLowerPrice().doubleValue());
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                reqOrderInsertVO.setTimeCondition(TimeCondition.GFD);
                                reqOrderInsertVO.setDirection(Direction.BUY);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(1);
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                try {
                                    logger.info("1分钟MA金叉，对冲一手");
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                } catch (CommonFutureException e) {
                                    logger.error("下单失败",e);
                                }
                                //记录下单缓存
                                orderMap.put(instrumentId, reqOrderInsertVO);
                            }
                        }
                    }
                }
            }
            //更新缓存中的ma
            if(ma.getLastPrice().compareTo(ma.getMa5())!=0){
                maMap.put(instrumentId, ma);
            }
        }

    }
    
    private OneMinutesMA(AbstractApplicationContext context){
        this.cacheMap = context.getBean(CacheMap.class);
        this.orderService = context.getBean(OrderService.class);
        this.tradeDao = context.getBean(TradeDao.class);
    }
    
    public static void START(AbstractApplicationContext context){
        if(oneMinutesMA == null){
            oneMinutesMA = new OneMinutesMA(context);
            Thread thread = new Thread(oneMinutesMA);
            thread.start();
        }
    }
    
    public static void offerQuota(MA ma){
        maQueue.offer(ma);
    }
    
    /**
     * 止盈策略
     * @author caojia
     * @throws CommonFutureException 
     *
     */
    public void stopProfit(MA ma) throws CommonFutureException {
                
        String instrumentId = ma.getInstrumentId();
        double tickPrice = this.cacheMap.getTickPrice(instrumentId);
        List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId);
        if(list != null && list.size() > 0) {
            for (OnRtnTradeVO tradeVO : list) {
                
                if(tradeVO.getDirection() == Direction.BUY) {
                    //买开
                    if(tradeVO.getPrice() + tickPrice*STOP_TICK <= ma.getBidPrice1().doubleValue()) {
                        
                        //止赢
                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                        reqOrderInsertVO.setInvestorId(EMAStarter.INVESTOR_ID);
                        reqOrderInsertVO.setInstrumentId(instrumentId);
                        reqOrderInsertVO.setLimitPrice(ma.getBidPrice1().doubleValue());
                        if(tradeVO.getTradingDay().equals(ma.getTradingDay())) {
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
                    if(tradeVO.getPrice() - tickPrice*STOP_TICK >= ma.getAskPrice1().doubleValue()) {
                        
                        //止赢
                          ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                          reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                          reqOrderInsertVO.setInvestorId(EMAStarter.INVESTOR_ID);
                          reqOrderInsertVO.setInstrumentId(instrumentId);
                          reqOrderInsertVO.setLimitPrice(ma.getAskPrice1().doubleValue());
                          if(tradeVO.getTradingDay().equals(ma.getTradingDay())) {
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
        
    }

}
