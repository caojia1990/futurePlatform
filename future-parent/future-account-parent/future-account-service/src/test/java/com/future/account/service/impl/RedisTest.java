package com.future.account.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.future.account.api.vo.AccountVO;

@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisTest extends AbstractJUnit4SpringContextTests{

    @Resource(name="redisTemplate")
    private StringRedisTemplate redisTemplate;
    
    @Resource(name="redisTemplate")
    private ValueOperations<String, String> valueOperations;
    
    
    @Test
    public void getAccount(){
        
        try {
            AccountVO accountVO = new AccountVO();
            accountVO.setAccountNo("001");
            /*this.valueOperations.set("test", accountVO);
            
            AccountVO accountVO2 = this.valueOperations.get("test");*/
            
            //this.valueOperations.set("str","1234");
            long s = valueOperations.increment("sequence", 1);
            System.out.println(s);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
