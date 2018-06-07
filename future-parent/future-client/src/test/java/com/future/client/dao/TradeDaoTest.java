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

import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
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
    
    @Test
    public void insertSelect(){
        
        OnRtnTradeVO tradeVO = new OnRtnTradeVO();
        tradeVO.setInvestorId("123");
        tradeVO.setAccountNo("123456");
        tradeVO.setDirection(Direction.BUY);
        tradeVO.setInstrumentId("cu1807");
        tradeVO.setOrderRef("001");
        tradeVO.setOrderSysId("956321");
        tradeVO.setPrice(51420);
        tradeVO.setVolume(1);
        tradeVO.setTradingDay("20180605");
        StopWatch stopWatch = StopWatch.createStarted();
        this.tradeDao.insert(tradeVO);
        stopWatch.stop();
        System.out.println("耗时："+stopWatch.getTime());
        stopWatch.reset();
        stopWatch.start();
        this.tradeDao.selectByCondition("123", "123456", "cu1807", "0");
        stopWatch.stop();
        System.out.println("耗时："+stopWatch.getTime());
    }
}
