package com.future.client.strategy;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.support.AbstractApplicationContext;

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
import com.future.quota.api.vo.MA;

/**
 * 手动抄单，1跳止盈
 * @author BHQH-CXYWB
 *
 */
public class Manual implements Runnable {
    
    static String INVESTOR_ID = "001";
    
    private static final String ACCOUNT_NO = "unknow";
    
    private static final int STOP_WIN = 1;
    
    private static final int STOP_LOSS = 1000;
    
    private final CacheMap cacheMap;
    
    private final OrderService orderService;
    
    private final TradeDao tradeDao;
    
    private static LinkedBlockingQueue<DepthMarketData> marketDataQueue = new LinkedBlockingQueue<>();
    
    private static Manual manual;
    
    private Manual(AbstractApplicationContext context){
        this.cacheMap = context.getBean(CacheMap.class);
        this.orderService = context.getBean(OrderService.class);
        this.tradeDao = context.getBean(TradeDao.class);
    }

    @Override
    public void run() {

        
        try {
            while (true) {
                
                DepthMarketData marketData = marketDataQueue.take();
            
                String instrumentId = marketData.getInstrumentID();
                double tickPrice = this.cacheMap.getTickPrice(instrumentId);
                
                List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(INVESTOR_ID, ACCOUNT_NO, instrumentId);
                
                if(list != null && list.size() > 0){
                    for (OnRtnTradeVO tradeVO : list) {
                        
                        if(tradeVO.getDirection() == Direction.BUY) {
                            //买开
                            if(tradeVO.getPrice() + tickPrice*STOP_WIN <= marketData.getBidPrice1().doubleValue()) {
                                
                                //止赢
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(INVESTOR_ID);
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
                            }else if (tradeVO.getPrice() - tickPrice*(STOP_LOSS) >= marketData.getBidPrice1().doubleValue()) {
                                
                              //止损
                                ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                reqOrderInsertVO.setInvestorId(INVESTOR_ID);
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
                            if(tradeVO.getPrice() - tickPrice*STOP_WIN >= marketData.getAskPrice1().doubleValue()) {
                                
                                //止赢
                                  ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                  reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                  reqOrderInsertVO.setInvestorId(INVESTOR_ID);
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
                              }else if (tradeVO.getPrice() + tickPrice*(STOP_LOSS) <= marketData.getAskPrice1().doubleValue()) {
                                  
                                //止损
                                  ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                                  reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                                  reqOrderInsertVO.setInvestorId(INVESTOR_ID);
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
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    

    }
    
    public static void START(AbstractApplicationContext context){
        if(manual == null){
            manual = new Manual(context);
            Thread thread = new Thread(manual);
            thread.start();
        }
    }
    
    public static void offerQuota(DepthMarketData marketData){
        marketDataQueue.offer(marketData);
    }

}
