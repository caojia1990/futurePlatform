package com.future.order.service.mq;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;

import com.future.account.api.exception.AccountException;
import com.future.common.exception.CommonFutureException;
import com.future.order.api.vo.CombHedgeFlag;
import com.future.order.api.vo.ContingentCondition;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.ForceCloseReason;
import com.future.order.api.vo.HedgeFlag;
import com.future.order.api.vo.OffsetFlag;
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
public class FasterTradeMessageHandle {
    
    static Logger logger = Logger.getLogger(FasterTradeMessageHandle.class);
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
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
     * @throws AccountException 
     */
    public void onRtnOrder(OnRtnOrderVO onRtnOrderVO) throws AccountException{
        
        if(logger.isDebugEnabled()){
            
            logger.debug("报单回报:"+onRtnOrderVO);
        }
        
        //根据orderRef查询账户编号
        OrderInput input = null;
        try {
            input = orderInputDao.selectByOrderRef(onRtnOrderVO.getOrderRef());
        } catch (EmptyResultDataAccessException e) {
            //找不到报单信息，说明是从其他客户端下单
            return;
        }
        
        com.future.order.api.vo.OnRtnOrderVO message = 
                new com.future.order.api.vo.OnRtnOrderVO();
        
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
        rabbitTemplate.convertAndSend(this.onRtnOrder, input.getInvestorID(), message);
        
    }
    
    /**
     * 成交回报
     * @param onRtnTrade
     */
    public void onRtnTrade(OnRtnTradeVO onRtnTrade) throws CommonFutureException{
        
        if(logger.isDebugEnabled()){
            
            logger.debug("成交回报"+onRtnTrade);
        }
        
        
        String orderRef = onRtnTrade.getOrderRef();
        OrderInput orderInput = null;
        try {
            orderInput = this.orderInputDao.selectByOrderRef(orderRef);
        } catch (EmptyResultDataAccessException e) {
            return;
        }
        
        com.future.order.api.vo.OnRtnTradeVO message = new com.future.order.api.vo.OnRtnTradeVO();
        message.setAccountNo(orderInput.getAccountNo());
        message.setDirection(Direction.ofCode(onRtnTrade.getDirection().getCode()));
        message.setExchangeId(onRtnTrade.getExchangeID());
        message.setExchangeInstId(onRtnTrade.getExchangeInstID());
        message.setHedgeFlag(HedgeFlag.ofCode(onRtnTrade.getHedgeFlag().getCode()));
        message.setInstrumentId(onRtnTrade.getInstrumentID());
        message.setInvestorId(orderInput.getInvestorID());
        message.setOffsetFlag(OffsetFlag.ofCode(onRtnTrade.getOffsetFlag().getCode()));
        message.setOrderRef(onRtnTrade.getOrderRef());
        message.setOrderSysId(onRtnTrade.getOrderSysID());
        message.setPrice(onRtnTrade.getPrice());
        message.setSequenceNo(onRtnTrade.getSequenceNo());
        message.setTradeDate(onRtnTrade.getTradeDate());
        message.setTradeId(onRtnTrade.getTradeID());
        message.setTradeTime(onRtnTrade.getTradeTime());
        message.setTradeType(onRtnTrade.getTradeType());
        message.setTradingDay(onRtnTrade.getTradingDay());
        message.setUserId(onRtnTrade.getUserID());
        message.setVolume(onRtnTrade.getVolume());
        
        rabbitTemplate.convertAndSend(this.onRtnTrade, orderInput.getInvestorID(), message);
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
