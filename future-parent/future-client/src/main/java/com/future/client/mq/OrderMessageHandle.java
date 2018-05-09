package com.future.client.mq;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;

import com.future.client.dao.TradeDao;
import com.future.order.api.vo.OffsetFlag;
import com.future.order.api.vo.OnRtnOrderVO;
import com.future.order.api.vo.OnRtnTradeVO;

public class OrderMessageHandle {
	
	static Logger logger = Logger.getLogger(OrderMessageHandle.class);
	
	@Resource(name="redisTemplate")
	private ValueOperations<String , OnRtnTradeVO> valueOperations;
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, OnRtnTradeVO> hashOperations;
	
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
        
        if(onRtnTrade.getOffsetFlag() == OffsetFlag.OPEN) {
            hashOperations.put(onRtnTrade.getAccountNo(), onRtnTrade.getInstrumentId(), onRtnTrade);
            //保存数据
            tradeDao.insert(onRtnTrade);
        }else {
            hashOperations.delete(onRtnTrade.getAccountNo(), onRtnTrade.getInstrumentId());
            //删除持仓
            tradeDao.deleteByCondition(onRtnTrade.getInvestorId(), onRtnTrade.getAccountNo(), 
                    onRtnTrade.getInstrumentId(), String.valueOf(onRtnTrade.getDirection().getCode()));
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
