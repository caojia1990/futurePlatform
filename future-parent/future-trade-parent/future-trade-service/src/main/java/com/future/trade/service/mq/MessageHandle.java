package com.future.trade.service.mq;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.future.trade.api.vo.OnRspInfo;
import com.future.trade.api.vo.OnRtnOrderVO;
import com.future.trade.api.vo.OnRtnTradeVO;
import com.future.trade.api.vo.ReqOrderInsertVO;

public class MessageHandle {
    
    static Logger logger = Logger.getLogger(MessageHandle.class);
    
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
    }
    
    /**
     * 报单错误回报
     */
    public void onRspOrderInsert(ReqOrderInsertVO reqOrderInsertVO){
        System.out.println("onRspOrderInsert报单错误回报"+JSON.toJSONString(reqOrderInsertVO));
    }
    
    /**
     * 撤单回报
     */
    public void onRspOrderAction(){
        System.out.println("撤单回报");
    }
    
    public void onRspError(OnRspInfo onRspInfo){
        System.out.println("onRspError错误回报"+JSON.toJSONString(onRspInfo));
    }
    
    public void onErrRtnOrderInsert(ReqOrderInsertVO reqOrderInsertVO){
        System.out.println("onErrRtnOrderInsert错误回报"+JSON.toJSONString(reqOrderInsertVO));
    }
    

}
