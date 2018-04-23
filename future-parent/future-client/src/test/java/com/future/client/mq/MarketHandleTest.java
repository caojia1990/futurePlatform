package com.future.client.mq;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.future.client.dao.FutureTickDao;
import com.future.market.api.mq.MessageReceive;
import com.future.market.api.vo.DepthMarketData;

public class MarketHandleTest implements MessageReceive{
    
    static Logger logger = Logger.getLogger(MarketHandleTest.class);
    
    @Autowired
    private FutureTickDao futureTickDao;

    @Override
    public void handleMessage(DepthMarketData marketData) {

        try {
            this.futureTickDao.saveTick(marketData.getInstrumentID(), marketData);
        } catch (Exception e) {
            logger.error("保存tick数据失败");
        }
        
    }
    
    

}
