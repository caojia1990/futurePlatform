package com.future.quota.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import com.future.quota.api.exception.QuotaError;
import com.future.quota.api.exception.QuotaException;
import com.future.quota.api.service.EmaService;
import com.future.quota.api.vo.EMA;
import com.future.quota.service.mq.QuotaHandle;

public class EmaServiceImpl implements EmaService {
    
    private static Logger logger = Logger.getLogger(EmaServiceImpl.class);
    
    private static final String REDIS_KEY = "EMA";
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String, EMA> hashOperations;

    @Override
    public List<EMA> queryEmaList() throws QuotaException {
        List<EMA> list = null;
        try {
            list = this.hashOperations.multiGet(REDIS_KEY, hashOperations.keys(REDIS_KEY));
        } catch (Exception e) {
            logger.error("获取EMA指标异常",e);
            throw new QuotaException(QuotaError.GET_EMA_FAILED, e);
        }
        return list;
    }

    @Override
    public void saveOrUpdateEma(EMA ema) throws QuotaException {
        
        try {
            this.hashOperations.put(REDIS_KEY, ema.getInstrumentId(), ema);
        } catch (Exception e) {
            logger.error("保存EMA指标异常",e);
            throw new QuotaException(QuotaError.SAVE_EMA_FAILED, e);
        }
        QuotaHandle.emaMap.put(ema.getInstrumentId(), ema);

    }

    @Override
    public void remove(String instrumentId) throws QuotaException {
        
        try {
            this.hashOperations.delete(REDIS_KEY, instrumentId);
        } catch (Exception e) {
            logger.error("删除EMA指标异常",e);
            throw new QuotaException(QuotaError.REMOVE_EMA_FAILED, e);
        }
        QuotaHandle.emaMap.remove(instrumentId);
    }

}
