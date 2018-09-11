package com.future.client.mq;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.future.instrument.api.vo.InvestorInstrumentVO;

public class InstrumentMessageHandle {

    static Logger logger = Logger.getLogger(InstrumentMessageHandle.class);
    
    public void handleMessage(InvestorInstrumentVO instrumentVO){
        logger.info("接收到合约变化"+JSON.toJSONString(instrumentVO));
    }
}
