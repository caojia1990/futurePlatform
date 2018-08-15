package com.future.quota.service.mq;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.future.quota.api.vo.MA;

public class MAComsumer {
    
    static private Logger logger = Logger.getLogger(MAComsumer.class);

    public void handleMessage(MA ma){
        if(ma.isComplete()){
            logger.info(JSON.toJSONString(ma));
        }
    }
}
