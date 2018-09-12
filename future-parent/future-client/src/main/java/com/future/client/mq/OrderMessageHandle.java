package com.future.client.mq;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.future.client.dao.TradeDao;
import com.future.order.api.vo.OffsetFlag;
import com.future.order.api.vo.OnRtnOrderVO;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.quota.api.vo.EMA;

public class OrderMessageHandle {
	
	static Logger logger = Logger.getLogger(OrderMessageHandle.class);
	
	@Resource(name="redisTemplate")
	private ValueOperations<String , OnRtnTradeVO> valueOperations;
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, OnRtnTradeVO> hashOperations;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private TradeDao tradeDao;
	
	/**
     * 报单回报
     * @param onRtnOrderVO
     */
    public void onRtnOrder(OnRtnOrderVO onRtnOrderVO){
        
        if(logger.isDebugEnabled()){
            
            logger.debug("报单回报"+onRtnOrderVO);
        }
        
    }
    
    /**
     * 成交回报
     * @param onRtnTrade
     */
    public void onRtnTrade(OnRtnTradeVO onRtnTrade){
        
        if(logger.isDebugEnabled()){
            
            logger.debug("成交回报"+onRtnTrade);
        }
        
        try {
            if(onRtnTrade.getOffsetFlag() == OffsetFlag.OPEN) {
                hashOperations.put(onRtnTrade.getAccountNo(), onRtnTrade.getInstrumentId(), onRtnTrade);
                //保存数据
                tradeDao.insert(onRtnTrade);
                //更新最大最小价格
                EMA ema = (EMA) this.redisTemplate.opsForHash().get(onRtnTrade.getInstrumentId(), "EMA5");
                if(ema != null){
                    ema.setHighestPrice(new BigDecimal(onRtnTrade.getPrice()));
                    ema.setLowestPrice(new BigDecimal(onRtnTrade.getPrice()));
                    this.redisTemplate.opsForHash().put(onRtnTrade.getInstrumentId(), "EMA5", ema);
                }
            }else {
                hashOperations.delete(onRtnTrade.getAccountNo(), onRtnTrade.getInstrumentId());
                //删除持仓
                tradeDao.deleteByCondition(onRtnTrade.getInvestorId(), onRtnTrade.getAccountNo(), 
                        onRtnTrade.getInstrumentId(), String.valueOf(onRtnTrade.getDirection().getCode()));
            }
        } catch (Exception e) {
            logger.error("处理成交回报失败",e);
        }
        
        
    }
    
    /**
     * 报单错误回报
     */
    public void onRspOrderInsert(){
        System.out.println("报单错误回报");
    }
    
    /**
     * 撤单回报
     */
    public void onRspOrderAction(){
        System.out.println("撤单回报");
    }
    
    public void onRspError(){
        System.out.println("错误回报");
    }
    
    public void onErrRtnOrderInsert(){
        System.out.println("错误回报");
    }

}
