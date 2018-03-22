package com.future.order.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.order.api.vo.InvestorPositionVO;

@Repository("investorPositionDao")
public class InvestorPositionDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public int insert(InvestorPositionVO record) {
		
		return jdbcTemplate.update("INSERT INTO FUTURE_INVESTOR_POSITION VALUES(?,?,?,?,?,?,?,?,?)", 
				"");
	}
}
