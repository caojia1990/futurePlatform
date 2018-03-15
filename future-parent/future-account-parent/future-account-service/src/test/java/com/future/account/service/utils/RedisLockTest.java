package com.future.account.service.utils;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisLockTest extends AbstractJUnit4SpringContextTests{
    
    
    @Resource(name="redisTemplate")
    private StringRedisTemplate redisTemplate;;
    
    @Test
    public void test(){
        
        for(int i = 0; i<3 ;i++){
            
            Thread thread = new Thread(new Runnable() {
                
                @Override
                public void run() {
                    RedisLock lock = new RedisLock(redisTemplate, "test");
                    try {
                        lock.lock();
                        int millis = RandomUtils.nextInt(0, 1000);
                        Thread.sleep(millis);
                        lock.unlock();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }
            });
            
            thread.start();
            
        }
        
        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    

}
