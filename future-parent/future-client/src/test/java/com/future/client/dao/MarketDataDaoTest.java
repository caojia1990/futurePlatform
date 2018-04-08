package com.future.client.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = "classpath:spring-jdbc-test.xml")
public class MarketDataDaoTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private QuotaDao quotaDao;
    
    @Test
    public void select() throws IOException {
        
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String s = reader.readLine();
            if(s.equals("bye")) {
                break;
            }
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            try {
                this.quotaDao.selectByInstrumentID(s);
            } catch (EmptyResultDataAccessException e) {
            }
            stopWatch.stop();
            System.out.println("耗时："+stopWatch.getTime());
        }
    }
}
