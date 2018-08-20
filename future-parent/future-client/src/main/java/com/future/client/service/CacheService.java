package com.future.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentVO;

@Service("cacheService")
public class CacheService{
    
    @Autowired
    private InstrumentService instrumentService;
    
    @Cacheable(value="instrument")
    public InstrumentVO getInstrumentById(String instrumentId) throws InstrumentException{
        System.out.println("远程调用");
        return this.instrumentService.queryInstrument(instrumentId);
        
    }
    
    public double getTickPrice(String instrumentID) throws InstrumentException{
        return this.getInstrumentById(instrumentID).getPriceTick();
    }
}
