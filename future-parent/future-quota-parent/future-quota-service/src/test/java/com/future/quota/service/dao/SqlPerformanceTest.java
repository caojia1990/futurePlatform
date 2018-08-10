package com.future.quota.service.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.StopWatch;

@ContextConfiguration(locations = "classpath:spring-jdbc.xml")
public class SqlPerformanceTest extends AbstractJUnit4SpringContextTests{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Test
    public void test() throws IOException{
        
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            if("bye".equals(inputStr)){
                System.out.println("bye!");
                break;
            }
            
            StopWatch watch = new StopWatch();
            watch.start();
            
            try {
                jdbcTemplate.execute(inputStr);
            } catch (DataAccessException e) {
                logger.error(e);
            }
            
            watch.stop();
            if(logger.isInfoEnabled()){
                logger.info("耗时:"+watch.getTotalTimeMillis());
            }
        }
    }

}
