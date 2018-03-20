package com.future.order.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.future.order.service.entity.OrderInput;

@Repository("orderInputDao")
public class OrderInputDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(OrderInput r) {
        
        return jdbcTemplate.update("INSERT INTO FUTURE_ORDER_INPUT VALUES(?,?,?,?,?,?,?,?,?)", 
                r.getOrderRef(),
                r.getInvestorID(),
                r.getAccountNo(),
                r.getVolumeTotalOriginal(),
                r.getTradeVolume(),
                r.getFrozenCommission(),
                r.getFrozenMargin(),
                r.getCommissionEachHand(),
                r.getMarginEachHand());
    }
    
    public OrderInput selectByOrderRef(String orderRef) {
    		
    		return jdbcTemplate.queryForObject("select * from FUTURE_ORDER_INPUT where order_ref = ?",
    				new RowMapper<OrderInput>() {

						@Override
						public OrderInput mapRow(ResultSet arg0, int arg1) throws SQLException {
							// TODO Auto-generated method stub
							OrderInput input = new OrderInput();
							input.setOrderRef(arg0.getString("ORDER_REF"));
							input.setAccountNo(arg0.getString("ACCOUNT_NO"));
							input.setInvestorID(arg0.getString("INVESTOR_ID"));
							input.setFrozenCommission(arg0.getBigDecimal("FROZEN_COMMISSION"));
							input.setFrozenMargin(arg0.getBigDecimal("FROZEN_MARGIN"));
							input.setCommissionEachHand(arg0.getBigDecimal("COMMISSION_EACH_HAND"));
							input.setMarginEachHand(arg0.getBigDecimal("MARGIN_EACH_HAND"));
							return input;
						}
					}, orderRef);
    }
}
