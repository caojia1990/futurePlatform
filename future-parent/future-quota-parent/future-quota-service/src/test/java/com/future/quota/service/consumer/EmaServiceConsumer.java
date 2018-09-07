package com.future.quota.service.consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSON;
import com.future.quota.api.exception.QuotaException;
import com.future.quota.api.service.EmaService;
import com.future.quota.api.vo.EMA;

@ContextConfiguration(locations = {"classpath:dubbo-consumer-test.xml"})
public class EmaServiceConsumer extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    private EmaService emaService;
    
    @Test
    public void get() throws IOException{
        
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            if("bye".equals(inputStr)){
                System.out.println("bye!");
                break;
            }
            
            StopWatch watch = new StopWatch();
            watch.start();
        
            List<EMA> list = null;
            try {
                list = this.emaService.queryEmaList();
            } catch (QuotaException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            watch.stop();
            if(logger.isInfoEnabled()){
                logger.info("耗时:"+watch.getTotalTimeMillis());
            }
            System.out.println(JSON.toJSONString(list,true));
        }
    }

}
