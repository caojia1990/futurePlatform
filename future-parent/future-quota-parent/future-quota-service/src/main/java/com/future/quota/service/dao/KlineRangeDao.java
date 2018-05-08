package com.future.quota.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.quota.api.vo.KlineRange;

/**
 * K线坐标数据库操作
 * @author caojia
 */
@Repository("klineRangeDao")
public class KlineRangeDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 查询k线坐标
     * @param product
     * @param period
     * @param updateTime
     * @return
     */
    public KlineRange selectByCondition(String product, String period, String updateTime){
        
        String sql = "SELECT * FROM FUTURE_KLINE_RANGE WHERE PRODUCT = ? AND PERIOD = ? AND ? BETWEEN BEGIN_TIME AND END_TIME";
        
        return this.jdbcTemplate.queryForObject(sql, 
                BeanPropertyRowMapper.newInstance(KlineRange.class), 
                product,period,updateTime);
    }
    
    
}
