package com.future.order.service.mq;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.future.account.api.service.AccountService;
import com.future.instrument.api.service.CommissionService;
import com.future.instrument.api.service.MarginService;
import com.future.order.api.vo.CombHedgeFlag;
import com.future.order.api.vo.ContingentCondition;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.ForceCloseReason;
import com.future.order.api.vo.OrderPriceType;
import com.future.order.api.vo.OrderStatus;
import com.future.order.api.vo.OrderSubmitStatus;
import com.future.order.api.vo.TimeCondition;
import com.future.order.service.dao.OrderInputDao;
import com.future.order.service.entity.OrderInput;
import com.future.trade.api.vo.OnRtnOrderVO;
import com.future.trade.api.vo.OnRtnTradeVO;

/**
 * 交易中心消息接收处理
 * @author caojia
 *
 */
public class TradeMessageHandle {
    
    static Logger logger = Logger.getLogger(TradeMessageHandle.class);
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private CommissionService commissionService;
    
    @Autowired
    private MarginService marginService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private OrderInputDao orderInputDao;
    
    @Value("${topicExchange.onRtnOrder}")
    private String onRtnOrder;
    
    @Value("${topicExchange.onRtnTrade}")
    private String onRtnTrade;
    
    @Value("${topicExchange.onRspOrderInsert}")
    private String onRspOrderInsert;
    
    @Value("${topicExchange.onRspOrderAction}")
    private String onRspOrderAction;
    
    @Value("${topicExchange.onRspError}")
    private String onRspError;
    
    @Value("${topicExchange.onErrRtnOrderInsert}")
    private String onErrRtnOrderInsert;
    
    /**
     * 报单回报
     * @param onRtnOrderVO
     */
    public void onRtnOrder(OnRtnOrderVO onRtnOrderVO){
        
        if(logger.isDebugEnabled()){
            
            logger.debug("报单回报:"+onRtnOrderVO);
        }
        
        //根据orderRef查询账户编号
        
        switch (onRtnOrderVO.getOrderStatus()) {
        case Canceled:
            //撤单  --最终状态
            //解冻未成交部分的手续费和保证金
            break;
        case AllTraded:
            //全部成交 --最终状态
            break;
        case NoTradeNotQueueing:
            //未成交不在队列中 --最终状态
            break;
        case PartTradedNotQueueing:
            //部分成交不在队列中 --最终状态
            break;
        case PartTradedQueueing:
            //部分成交还在队列中
            break;
        case NoTradeQueueing:
            //成交还在队列中
            break;
        case Unknown:
            //未知 说明：报单已经被CTP接收，但还没发往交易所
            
            break;
        default:
            break;
        }
        
        com.future.order.api.vo.OnRtnOrderVO message = 
        		new com.future.order.api.vo.OnRtnOrderVO();
        OrderInput input = orderInputDao.selectByOrderRef(onRtnOrderVO.getOrderRef());
        message.setOrderRef(onRtnOrderVO.getOrderRef());
        message.setAccountNo(input.getAccountNo());
        message.setActiveTime(onRtnOrderVO.getActiveTime());
        message.setCancelTime(onRtnOrderVO.getCancelTime());
        message.setCombHedgeFlag(CombHedgeFlag.ofCode(
        		onRtnOrderVO.getCombOffsetFlag().getCode()));
        message.setCombHedgeFlag(CombHedgeFlag.ofCode(
        		onRtnOrderVO.getCombHedgeFlag().getCode()));
        message.setContingentCondition(ContingentCondition.ofCode(
        		onRtnOrderVO.getContingentCondition().getCode()));
        message.setDirection(Direction.ofCode(
        		onRtnOrderVO.getDirection().getCode()));
        message.setExchangeID(onRtnOrderVO.getExchangeID());
        message.setExchangeInstID(onRtnOrderVO.getExchangeInstID());
        message.setForceCloseReason(ForceCloseReason.ofCode(
        		onRtnOrderVO.getForceCloseReason().getCode()));
        message.setFrontID(onRtnOrderVO.getFrontID());
        message.setgTDDate(onRtnOrderVO.getgTDDate());
        message.setInsertDate(onRtnOrderVO.getInsertDate());
        message.setInsertTime(onRtnOrderVO.getInsertTime());
        message.setInstrumentID(onRtnOrderVO.getInstrumentID());
        message.setInvestorID(input.getInvestorID());
        message.setLimitPrice(onRtnOrderVO.getLimitPrice());
        message.setMinVolume(onRtnOrderVO.getMinVolume());
        message.setOrderPriceType(OrderPriceType.ofCode(
        		onRtnOrderVO.getOrderPriceType().getCode()));
        message.setOrderSource(onRtnOrderVO.getOrderSource());
        message.setOrderStatus(OrderStatus.ofCode(
        		onRtnOrderVO.getOrderStatus().getCode()));
        message.setOrderSubmitStatus(OrderSubmitStatus.ofCode(
        		onRtnOrderVO.getOrderSubmitStatus().getCode()));
        message.setOrderSysID(onRtnOrderVO.getOrderSysID());
        message.setOrderType(onRtnOrderVO.getOrderType());
        message.setRequestID(onRtnOrderVO.getRequestID());
        message.setSessionID(onRtnOrderVO.getSessionID());
        message.setStatusMsg(onRtnOrderVO.getStatusMsg());
        message.setStopPrice(onRtnOrderVO.getStopPrice());
        message.setTimeCondition(TimeCondition.ofCode(
        		onRtnOrderVO.getTimeCondition().getCode()));
        //TODO
        rabbitTemplate.convertAndSend(onRtnOrder, input.getInvestorID(), message);
        
    }
    
    /**
     * 成交回报
     * @param onRtnTrade
     */
    public void onRtnTrade(OnRtnTradeVO onRtnTrade){
        
        if(logger.isDebugEnabled()){
            
            logger.debug("成交回报"+onRtnTrade);
        }
        
        String orderRef = onRtnTrade.getOrderRef();
        
        
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
