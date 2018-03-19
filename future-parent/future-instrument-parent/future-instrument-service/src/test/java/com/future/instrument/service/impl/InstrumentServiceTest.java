package com.future.instrument.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import com.future.instrument.api.vo.InstrumentVO;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis-test.xml")
public class InstrumentServiceTest extends AbstractJUnit4SpringContextTests{
    
    static Logger logger = Logger.getLogger(InstrumentServiceTest.class);
    
    @Resource(name="redisTemplate")
    private ValueOperations<String, Object> valueOperations;
    
    @Resource(name="redisTemplate")
    private HashOperations<String, String , InstrumentVO> hashOperations;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Test
    public void test(){
        
        InstrumentVO instrumentVO = new InstrumentVO();
        instrumentVO.setInstrumentID("cu1804");
        instrumentVO.setExchangeID("SHEF");
        instrumentVO.setLongMarginRatio(0.00005);
        this.valueOperations.set("test", instrumentVO);
        this.hashOperations.put("instrument", instrumentVO.getInstrumentID(), instrumentVO);
        
    }
    
    @Test
    public void queryInstrument() throws IOException{
        
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            
            if(inputStr.equals("bye")){
                break;
            }
            StopWatch watch = new StopWatch();
            watch.start();
            if(logger.isDebugEnabled()){
                logger.debug("开始");
            }
            
            InstrumentVO instrumentVO;
            try {
                instrumentVO = hashOperations.get(InstrumentServiceImpl.INSTRUMENT_REDIS_KEY, "cu1804");
                logger.debug(instrumentVO);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            watch.stop();
            if(logger.isDebugEnabled()){
                logger.debug("耗时:"+watch.getTotalTimeMillis());
            }
        }
       
    }

}
