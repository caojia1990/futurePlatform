package com.future.client.strategy;

import java.util.List;

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
 * 手动抄单，1跳止盈
 * @author BHQH-CXYWB
 *
 */
public class Manual implements Runnable {
    
    private static final String ACCOUNT_NO = "00007";
    
    private static final int STOP_WIN = 1;
    
    private static final int STOP_LOSS = 10;
    
    private final DepthMarketData marketData;
    
    private final CacheMap cacheMap;
    
    private final OrderService orderService;
    
    private final TradeDao tradeDao;
    
    public Manual(DepthMarketData marketData, CacheMap cacheMap, OrderService orderService, TradeDao tradeDao) {
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
                            
                            //止赢
                            ReqOrderInsertVO reqOrderInsertVO = new ReqOrderInsertVO();
                            reqOrderInsertVO.setAccountNo(ACCOUNT_NO);
                            reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
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
                            reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
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
                              reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
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
                              reqOrderInsertVO.setInvestorId(ClientStarter.INVESTOR_ID);
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
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    

    }

}
