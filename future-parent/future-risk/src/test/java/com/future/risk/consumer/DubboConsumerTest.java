package com.future.risk.consumer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.future.instrument.api.service.InstrumentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DubboConsumerTest {

    @Reference
    private InstrumentService instrumentService;
    
    @Test
    public void getName(){
        List<String> list = this.instrumentService.queryInstrumentName();
        System.out.println(JSON.toJSONString(list));
    }
}
