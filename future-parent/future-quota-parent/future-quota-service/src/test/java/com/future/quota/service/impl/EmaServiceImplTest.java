package com.future.quota.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;
import com.future.quota.api.exception.QuotaException;
import com.future.quota.api.service.EmaService;
import com.future.quota.api.vo.EMA;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmaServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private EmaService emaService;
    
    @Test
    public void get() {
        List<EMA> list = null;
        try {
            list = this.emaService.queryEmaList();
        } catch (QuotaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(JSON.toJSONString(list,true));
    }
    
}
