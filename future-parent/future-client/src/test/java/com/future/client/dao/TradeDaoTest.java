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

@ContextConfiguration(locations = "classpath:spring-jdbc.xml")
public class TradeDaoTest extends AbstractJUnit4SpringContextTests{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private TradeDao tradeDao;
    
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
                this.tradeDao.selectByCondition("001", "00009", "zn1807", "0");
            } catch (EmptyResultDataAccessException e) {
            }
            stopWatch.stop();
            System.out.println("耗时："+stopWatch.getTime());
        }
    }
}
