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

import com.future.order.service.entity.OrderInput;

@ContextConfiguration(locations = "classpath:spring-jdbc-test.xml")
public class OrderInputDaoTest extends AbstractJUnit4SpringContextTests{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private OrderInputDao orderInputDao;
    
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
            
            OrderInput r = new OrderInput();
            r.setAccountNo("123");
            r.setOrderRef(inputStr);
            r.setInvestorID("caojia");
            r.setVolumeTotalOriginal(5);
            r.setTradeVolume(2);
            r.setFrozenCommission(new BigDecimal(200));
            r.setFrozenMargin(new BigDecimal(12000));
            r.setMarginEachHand(new BigDecimal(100));
            r.setCommissionEachHand(new BigDecimal(6000));
            orderInputDao.insert(r);
            List list = jdbcTemplate.queryForList("select * from future_order_input");
            
            OrderInput rindb = orderInputDao.selectByOrderRef(inputStr);
            System.out.println(list);
            
            Assert.assertEquals(200d, rindb.getFrozenCommission().doubleValue(),0);
            watch.stop();
            if(logger.isDebugEnabled()){
                logger.debug("耗时:"+watch.getTotalTimeMillis());
            }
        }
        
    }

}
