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
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.future.client.ClientStarter;
import com.future.client.strategy.Breakthrough;
import com.future.client.strategy.FiveSecsFollow;
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
    
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Override
    public void handleMessage(DepthMarketData marketData) {
        
        taskExecutor.execute(new Breakthrough(marketData, orderService, hashOperations, cacheMap));
        taskExecutor.execute(new FiveSecsFollow(marketData, orderService, hashOperations, cacheMap));
        
    }

    

}
