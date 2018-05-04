package com.future.client.dao;

import java.util.List;

import com.future.client.entity.KlineRange;

/**
 * K线坐标数据库操作
 * @author caojia
 */
public class KlineRangeDao {
    
    
    public List<KlineRange> selectByCondition(String product, String period, String updateTime){
        
        String sql = "select * from FUTURE_KLINE_RANGE WHERE PRODUCT = ? AND PERIOD = ? AND ";
    }
    
    
}
