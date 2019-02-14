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
import com.future.instrument.api.vo.InvestorInstrumentVO;
import com.future.instrument.api.vo.StaircaseHedgingVO;
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
    private static final int DEFAULT_STOP_TICK = 1;
    
    private static OneMinutesMA oneMinutesMA;
    
    private static LinkedBlockingQueue<MA> maQueue = new LinkedBlockingQueue<>();
    
    private Map<String, MA> maMap = new HashMap<>();
    
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
                
            try {
                MA oldMA = maMap.get(instrumentId);
                if(oldMA == null){
                    continue;
                }
                
                //查询需要对冲账户的持仓信息
                List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ORIG_ACCOUNT_NO, instrumentId);
                if(list == null||list.size() < 1){
                    //如果没有持仓，平所有对冲的头寸 TODO
                    continue;
                }
                
                InvestorInstrumentVO vo = CacheMap.INVESTOR_INSTRUMENT.get(instrumentId);
                if(vo == null || "2".equals(vo.getHedgingType())){
                    continue;
                }
                
                
                for (OnRtnTradeVO onRtnTradeVO : list) {
                    if(onRtnTradeVO.getDirection() == Direction.BUY){
                        
                        //判断是否死叉
                        BigDecimal o = oldMA.getLastPrice().subtract(oldMA.getMa5());
                        BigDecimal n = ma.getLastPrice().subtract(ma.getMa5());
                        //死叉触发对冲
                        if(!(o.compareTo(BigDecimal.ZERO) > 0 && n.compareTo(BigDecimal.ZERO) < 0)){
                            break;
                        }
                        //按比例触发
                        if("0".equals(vo.getHedgingType())){
                            double touch = (ma.getLastPrice().doubleValue()-onRtnTradeVO.getPrice())/onRtnTradeVO.getPrice();
                            if(touch > vo.getHedgingTigger().doubleValue()){
                                //查询对冲账户是否有对冲持仓
                                List<OnRtnTradeVO> hedgingList = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"1");
                                if(hedgingList == null || hedgingList.size() < 1 ){
                                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                    reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                    reqOrderInsertVO.setInstrumentId(instrumentId);
                                    reqOrderInsertVO.setLimitPrice(ma.getLowerPrice().doubleValue());
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                    reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                    reqOrderInsertVO.setDirection(Direction.SELL);
                                    reqOrderInsertVO.setMinVolume(1);
                                    reqOrderInsertVO.setVolumeTotalOriginal(vo.getHedgingVolume());
                                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                    logger.info("1分钟MA死叉，对冲一手");
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                }
                            }
                        }else if ("1".equals(vo.getHedgingType())) {
                            //立即触发
                            //查询对冲账户是否有对冲持仓
                            List<OnRtnTradeVO> hedgingList = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"1");
                            if(hedgingList == null || hedgingList.size() < 1 ){
                                
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentId(instrumentId);
                                reqOrderInsertVO.setLimitPrice(ma.getLowerPrice().doubleValue());
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                reqOrderInsertVO.setDirection(Direction.SELL);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(vo.getHedgingVolume());
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                logger.info("1分钟MA死叉，对冲一手");
                                orderService.reqOrderInsert(reqOrderInsertVO);
                            }
                        }else if ("3".equals(vo.getHedgingType())) {
                            //阶梯对冲方式
                            List<StaircaseHedgingVO> hedgingVOs = vo.getHedgingList();
                            if(hedgingVOs == null || hedgingVOs.size() <1){
                                break;
                            }
                            double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                            int tick = (int) ((ma.getBidPrice1().doubleValue()-onRtnTradeVO.getPrice())/tickPrice);
                            
                            for (StaircaseHedgingVO staircaseHedgingVO : hedgingVOs) {
                                //寻找当前价格所在的对冲阶段
                                if(tick >= staircaseHedgingVO.getHedgingBeginTick() && tick< staircaseHedgingVO.getHedgingEndTick()){
                                    int volume = staircaseHedgingVO.getHedgingVolume();//可以对冲的笔数
                                    //查询已经对冲的笔数
                                    int count = this.tradeDao.sumByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"1");
                                    if(volume > count){
                                        //如果对冲数量还不满，则继续对冲
                                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                        reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                        reqOrderInsertVO.setInstrumentId(instrumentId);
                                        reqOrderInsertVO.setLimitPrice(ma.getLowerPrice().doubleValue());
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                        reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                        reqOrderInsertVO.setDirection(Direction.SELL);
                                        reqOrderInsertVO.setMinVolume(1);
                                        reqOrderInsertVO.setVolumeTotalOriginal(volume-count);
                                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                        logger.info("1分钟MA死叉，阶梯对冲一手");
                                        orderService.reqOrderInsert(reqOrderInsertVO);
                                    }
                                    break;
                                }
                            }
                        }
                    }else {
                        //卖开
                        
                        //判断是否金叉
                        BigDecimal o = oldMA.getLastPrice().subtract(oldMA.getMa5());
                        BigDecimal n = ma.getLastPrice().subtract(ma.getMa5());
                        //金叉 对冲一手
                        if(!(o.compareTo(BigDecimal.ZERO) < 0 && n.compareTo(BigDecimal.ZERO) > 0)){
                            break;
                        }
                      //按比例触发
                        if("0".equals(vo.getHedgingType())){
                            double touch = (onRtnTradeVO.getPrice()-ma.getLastPrice().doubleValue())/onRtnTradeVO.getPrice();
                            if(touch > vo.getHedgingTigger().doubleValue()){
                                //查询对冲账户是否有对冲持仓
                                List<OnRtnTradeVO> hedgingList = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"0");
                                if(hedgingList == null || hedgingList.size() < 1 ){
                                    
                                    ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                    reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                    reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                    reqOrderInsertVO.setInstrumentId(instrumentId);
                                    reqOrderInsertVO.setLimitPrice(ma.getUpperPrice().doubleValue());
                                    reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                    reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                    reqOrderInsertVO.setDirection(Direction.BUY);
                                    reqOrderInsertVO.setMinVolume(1);
                                    reqOrderInsertVO.setVolumeTotalOriginal(vo.getHedgingVolume());
                                    reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                    logger.info("1分钟MA金叉，对冲一手");
                                    orderService.reqOrderInsert(reqOrderInsertVO);
                                }
                            }
                        }else if ("1".equals(vo.getHedgingType())) {
                          //查询对冲账户是否有对冲持仓
                            List<OnRtnTradeVO> hedgingList = this.tradeDao.selectByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"0");
                            if(hedgingList == null || hedgingList.size() < 1 ){
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                reqOrderInsertVO.setInstrumentId(instrumentId);
                                reqOrderInsertVO.setLimitPrice(ma.getUpperPrice().doubleValue());
                                reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                reqOrderInsertVO.setDirection(Direction.BUY);
                                reqOrderInsertVO.setMinVolume(1);
                                reqOrderInsertVO.setVolumeTotalOriginal(vo.getHedgingVolume());
                                reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                logger.info("1分钟MA金叉，对冲一手");
                                orderService.reqOrderInsert(reqOrderInsertVO);
                            }
                        }else if ("3".equals(vo.getHedgingType())) {
                            //阶梯对冲方式
                            List<StaircaseHedgingVO> hedgingVOs = vo.getHedgingList();
                            if(hedgingVOs == null || hedgingVOs.size() <1){
                                break;
                            }
                            double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                            int tick = (int) ((onRtnTradeVO.getPrice()-ma.getAskPrice1().doubleValue())/tickPrice);
                            
                            for (StaircaseHedgingVO staircaseHedgingVO : hedgingVOs) {
                                //寻找当前价格所在的对冲阶段
                                if(tick >= staircaseHedgingVO.getHedgingBeginTick() && tick< staircaseHedgingVO.getHedgingEndTick()){
                                    int volume = staircaseHedgingVO.getHedgingVolume();//可以对冲的笔数
                                    //查询已经对冲的笔数
                                    int count = this.tradeDao.sumByCondition(ClientStarter.INVESTOR_ID, ACCOUNT_NO, instrumentId,"0");
                                    if(volume > count){
                                        //如果对冲数量还不满，则继续对冲
                                        ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                        reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                        reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
                                        reqOrderInsertVO.setInstrumentId(instrumentId);
                                        reqOrderInsertVO.setLimitPrice(ma.getUpperPrice().doubleValue());
                                        reqOrderInsertVO.setCombOffsetFlag(CombOffsetFlag.OPEN);
                                        reqOrderInsertVO.setTimeCondition(TimeCondition.IOC);
                                        reqOrderInsertVO.setDirection(Direction.BUY);
                                        reqOrderInsertVO.setMinVolume(1);
                                        reqOrderInsertVO.setVolumeTotalOriginal(volume-count);
                                        reqOrderInsertVO.setOrderPriceType(OrderPriceType.LimitPrice);
                                        logger.info("1分钟MA死叉，阶梯对冲");
                                        orderService.reqOrderInsert(reqOrderInsertVO);
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    //防止重复对冲
                    break;
                }
            } catch (Exception e) {
                logger.error("对冲异常",e);
            } finally {
                //更新缓存中的ma
                if(ma.getLastPrice().compareTo(ma.getMa5())!=0){
                    maMap.put(instrumentId, ma);
                }
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
        
        InvestorInstrumentVO vo = CacheMap.INVESTOR_INSTRUMENT.get(instrumentId);
        if(vo == null){
            vo = new InvestorInstrumentVO();
            vo.setHedgingStopWin(DEFAULT_STOP_TICK);
        }
        
        if(list != null && list.size() > 0) {
            for (OnRtnTradeVO tradeVO : list) {
                
                if(tradeVO.getDirection() == Direction.BUY) {
                    //买开
                    if(tradeVO.getPrice() + tickPrice*vo.getHedgingStopWin() <= ma.getBidPrice1().doubleValue()) {
                        
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
                    if(tradeVO.getPrice() - tickPrice*vo.getHedgingStopWin() >= ma.getAskPrice1().doubleValue()) {
                        
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
