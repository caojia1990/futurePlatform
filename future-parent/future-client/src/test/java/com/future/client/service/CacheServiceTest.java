package com.future.client.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;
import com.future.instrument.api.exception.InstrumentException;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CacheServiceTest extends AbstractJUnit4SpringContextTests{
    
    
    @Autowired
    private CacheService cacheService;
    
    @Test
    public void get() throws InstrumentException{
        
        System.out.println(JSON.toJSONString(this.cacheService.getInstrumentById("cu1810")));
        System.out.println(JSON.toJSONString(this.cacheService.getInstrumentById("cu1810")));
        System.out.println(JSON.toJSONString(this.cacheService.getInstrumentById("cu1810")));
        System.out.println(JSON.toJSONString(this.cacheService.getTickPrice("cu1810")));
    }

}
