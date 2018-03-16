package com.future.order.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:spring-redis-test.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests{

    @Resource(name="redisTemplate")
    private StringRedisTemplate redisTemplate;;
    
    
    @Test
    public void increment(){
        
        for (int i=0 ; i<10 ; i++){
            Thread thread = new Thread(new Runnable() {
                
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(redisTemplate.opsForValue().increment(OrderServiceImpl.ORDERREF_SEQUENCE_KEY, 1));
                }
            });
            thread.start();
        }
        
    }
}
