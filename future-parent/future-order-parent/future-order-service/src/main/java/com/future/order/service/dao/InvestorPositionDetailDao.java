package com.future.order.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.order.api.vo.InvestorPositionDetailVO;

@Repository("investorPositionDetailDao")
public class InvestorPositionDetailDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(InvestorPositionDetailVO r) {
        
        return jdbcTemplate.update("INSERT INTO FUTURE_INVESTOR_POSI_DETAIL VALUES(?,?,?,?,?,?,?,?,?)", "");
    }
    
    

}
