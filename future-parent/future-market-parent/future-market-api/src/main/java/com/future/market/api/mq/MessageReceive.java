package com.future.market.api.mq;

import com.future.market.api.vo.DepthMarketData;

/**
 * 消息回报接口
 * @author caojia
 */
public interface MessageReceive {
    
    /**
     * 行情接收接口
     * @param market
     */
    public void handleMessage(DepthMarketData marketData);
}
