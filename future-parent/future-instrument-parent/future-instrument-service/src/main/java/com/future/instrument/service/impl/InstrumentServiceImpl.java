package com.future.instrument.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentCommissionRateVO;
import com.future.instrument.api.vo.InstrumentVO;

@Service("instrumentService")
public class InstrumentServiceImpl implements InstrumentService{
    
    static Logger logger = Logger.getLogger(InstrumentServiceImpl.class);
    
    static final String INSTRUMENT_REDIS_KEY = "instrument";
    
    @Resource(name="redisTemplate")
    private ValueOperations<String, Object> valueOperations;
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String, InstrumentVO> hashOperations;
    
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Override
    public InstrumentVO queryInstrument(String instrumentID) {
        
        return this.hashOperations.get(INSTRUMENT_REDIS_KEY, instrumentID);
        
    }

    @Override
    public InstrumentVO queryInstrument(String instrumentID, String tradingDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> queryInstrumentName() {

        return new ArrayList<String>(this.hashOperations.keys(INSTRUMENT_REDIS_KEY));
    }

    @Override
    public List<String> queryInstrumentName(String tradingDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveInstrument(InstrumentVO instrumentVO) {
        
        this.hashOperations.put(INSTRUMENT_REDIS_KEY, instrumentVO.getInstrumentID(), instrumentVO);
        
    }

    @Override
    public void saveInstrument(String tradingDate, InstrumentVO instrumentVO) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeInstrument() {
        
        this.redisTemplate.delete(INSTRUMENT_REDIS_KEY);
        
    }

    @Override
    public void removeInstrument(String tradingDate) {
        // TODO Auto-generated method stub
        
    }


}
