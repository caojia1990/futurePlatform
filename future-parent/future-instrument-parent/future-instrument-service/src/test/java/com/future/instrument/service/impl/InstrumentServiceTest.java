package com.future.instrument.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.future.instrument.api.vo.InstrumentVO;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis-test.xml")
public class InstrumentServiceTest extends AbstractJUnit4SpringContextTests{
    
    
    @Resource(name="redisTemplate")
    private ValueOperations<String, Object> valueOperations;
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String , InstrumentVO> hashOperations;
    
    @Test
    public void test(){
        
        InstrumentVO instrumentVO = new InstrumentVO();
        instrumentVO.setInstrumentID("cu1804");
        instrumentVO.setExchangeID("SHEF");
        instrumentVO.setLongMarginRatio(0.00005);
        this.valueOperations.set("test", instrumentVO);
        this.hashOperations.put("instrument", instrumentVO.getInstrumentID(), instrumentVO);
        
    }

}
