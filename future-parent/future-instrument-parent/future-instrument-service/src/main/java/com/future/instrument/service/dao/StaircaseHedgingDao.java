package com.future.instrument.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.instrument.api.vo.StaircaseHedgingVO;

@Repository("staircaseHedgingDao")
public class StaircaseHedgingDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(StaircaseHedgingVO staircaseHedgingVO){
        
        String sql = "INSERT INTO STAIRCASE_HEDGING VALUES (?,?,?,?)";
        return this.jdbcTemplate.update(sql, 
                staircaseHedgingVO.getInstrumentId(),
                staircaseHedgingVO.getHedgingBeginTick(),
                staircaseHedgingVO.getHedgingEndTick(),
                staircaseHedgingVO.getHedgingVolume());
        
    }
    
    public int delete(String instrumentId) {
        
        return this.jdbcTemplate.update("DELETE STAIRCASE_HEDGING WHERE INSTRUMENT_ID = ? ",instrumentId);
        
    }
    
    public List<StaircaseHedgingVO> selectList(String instrumentId) {
        
        String sql = "SELECT * FROM STAIRCASE_HEDGING WHERE INSTRUMENT_ID = ? ";
        return this.jdbcTemplate.query(sql, 
                BeanPropertyRowMapper.newInstance(StaircaseHedgingVO.class), 
                instrumentId);
        
    }
}
