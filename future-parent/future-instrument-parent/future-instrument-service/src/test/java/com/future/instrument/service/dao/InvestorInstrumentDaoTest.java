package com.future.instrument.service.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.fastjson.JSON;
import com.future.instrument.api.vo.InvestorInstrumentVO;

@ContextConfiguration(locations = "classpath:spring-jdbc.xml")
public class InvestorInstrumentDaoTest extends AbstractJUnit4SpringContextTests{

    static Logger logger = Logger.getLogger(InvestorInstrumentDaoTest.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private InvestorInstrumentDao investorInstrumentDao;
    
    @Test
    public void insert() throws IOException {
        
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String s = reader.readLine();
            if(s.equals("bye")) {
                break;
            }
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            InvestorInstrumentVO investorInstrumentVO = new InvestorInstrumentVO();
            investorInstrumentVO.setInvestorNo("001");
            investorInstrumentVO.setInstrumentId("cu1810");
            investorInstrumentVO.setStopLoss(20);
            try {
                this.investorInstrumentDao.insert(investorInstrumentVO);
            } catch (Exception e) {
                
            }
            stopWatch.stop();
            System.out.println("耗时："+stopWatch.getTime());
        }
    }
    
    @Test
    public void update(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        InvestorInstrumentVO investorInstrumentVO = new InvestorInstrumentVO();
        investorInstrumentVO.setInvestorNo("001");
        investorInstrumentVO.setInstrumentId("cu1810");
        investorInstrumentVO.setStopLoss(10);
        investorInstrumentVO.setHedgingStopLoss(20);
        investorInstrumentVO.setHedgingStopWin(2);
        try {
            this.investorInstrumentDao.update(investorInstrumentVO);
        } catch (Exception e) {
            
        }
        stopWatch.stop();
        System.out.println("耗时："+stopWatch.getTime());
    }
    
    @Test
    public void delete() throws IOException{
        
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            String s = reader.readLine();
            if(s.equals("bye")) {
                break;
            }
            
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            int row = 0;
            try {
                row = this.investorInstrumentDao.delete("001", "cu1810");
            } catch (Exception e) {
                
            }
            stopWatch.stop();
            System.out.println(row +"条记录受影响  ，耗时："+stopWatch.getTime());
        }
    }
    
    @Test
    public void select(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            this.investorInstrumentDao.select("001", "cu1810");
        } catch (Exception e) {
            logger.error("",e);
        }
        stopWatch.stop();
        System.out.println("耗时："+stopWatch.getTime());
    }
    
    @Test
    public void selectList(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<InvestorInstrumentVO> list = null;
        try {
            list = this.investorInstrumentDao.selectList("001");
        } catch (Exception e) {
            logger.error("",e);
        }
        stopWatch.stop();
        System.out.println("耗时："+stopWatch.getTime());
        logger.info(JSON.toJSONString(list,true));
    }
    
}
