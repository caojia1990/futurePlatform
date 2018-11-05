package com.future.order.service.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.StopWatch;

import com.alibaba.fastjson.JSON;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.HedgeFlag;
import com.future.order.api.vo.InvestorPositionVO;
import com.future.order.service.entity.OrderInput;

@ContextConfiguration(locations = "classpath:spring-jdbc-test.xml")
public class InvestorPositionDaoTest extends AbstractJUnit4SpringContextTests{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private InvestorPositionDao investorPositionDao;
    
    @Test
    public void Test() throws IOException {
        
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr = br.readLine();
            
            if("bye".equals(inputStr)) {
                System.out.println("bye!");
                break;
            }
            
            StopWatch watch = new StopWatch();
            watch.start();
            
            String accountNo = "0025712602082001";
            String instrumentID = "cu1806";
            String investorID = "34080001";
            Direction direction = Direction.BUY;
            InvestorPositionVO r = new InvestorPositionVO();
            r.setInvestorID(investorID);
            r.setAccountNo(inputStr);
            r.setInstrumentID(instrumentID);
            r.setPosiDirection(direction);
            r.setHedgeFlag(HedgeFlag.Speculation);
            this.investorPositionDao.insert(r);
            
            InvestorPositionVO rindb = this.investorPositionDao.selectByCondition(inputStr, instrumentID, direction);
            System.out.println(JSON.toJSONString(rindb));
            Assert.assertEquals(investorID,rindb.getInvestorID());
            watch.stop();
            if(logger.isDebugEnabled()){
                logger.debug("耗时:"+watch.getTotalTimeMillis());
            }
        }
        
    }

}
