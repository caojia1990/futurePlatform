package com.future.order.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.order.service.entity.OrderInput;

@Repository("orderInputDao")
public class OrderInputDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(OrderInput r) {
        
        return jdbcTemplate.update("INSERT INTO FUTURE_ORDER_INPUT VALUES(?,?,?,?,?,?,?)", 
                r.getOrderRef(),
                r.getInvestorID(),
                r.getAccountNo(),
                r.getVolumeTotalOriginal(),
                r.getTradeVolume(),
                r.getFrozenCommission(),
                r.getFrozenMargin());
    }
}
