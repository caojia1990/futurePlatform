package com.future.instrument.service.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.instrument.api.vo.InvestorInstrumentVO;

@Repository("investorInstrumentDao")
public class InvestorInstrumentDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int  insert(InvestorInstrumentVO investorInstrumentVO){
        return this.jdbcTemplate.update("INSERT INTO INVESTOR_INSTRUMENT VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)", 
                investorInstrumentVO.getInvestorNo(),
                investorInstrumentVO.getInstrumentId(),
                investorInstrumentVO.getVolume(),
                investorInstrumentVO.getStopWin(),
                investorInstrumentVO.getStopLoss(),
                investorInstrumentVO.getStatus(),
                investorInstrumentVO.getTarget(),
                investorInstrumentVO.getRetracement(),
                investorInstrumentVO.getHedgingType(),
                investorInstrumentVO.getHedgingTigger(),
                investorInstrumentVO.getHedgingVolume(),
                investorInstrumentVO.getHedgingStopWin(),
                investorInstrumentVO.getHedgingStopLoss()
                
                );
    }
    
    public int update(InvestorInstrumentVO investorInstrumentVO){
        return this.jdbcTemplate.update("UPDATE INVESTOR_INSTRUMENT SET "
                + "VOLUME = ?,"
                + "STOP_WIN = ?,"
                + "STOP_LOSS = ?,"
                + "STATUS = ?,"
                + "TARGET = ?,"
                + "RETRACEMENT = ?,"
                + "HEDGING_TYPE = ?,"
                + "HEDGING_TIGGER = ?,"
                + "HEDGING_VOLUME = ?,"
                + "HEDGING_STOP_WIN = ?,"
                + "HEDGING_STOP_LOSS = ?"
                + "WHERE INVESTOR_NO = ? AND INSTRUMENT_ID = ?", 
                investorInstrumentVO.getVolume(),
                investorInstrumentVO.getStopWin(),
                investorInstrumentVO.getStopLoss(),
                investorInstrumentVO.getStatus(),
                investorInstrumentVO.getTarget(),
                investorInstrumentVO.getRetracement(),
                investorInstrumentVO.getHedgingType(),
                investorInstrumentVO.getHedgingTigger(),
                investorInstrumentVO.getHedgingVolume(),
                investorInstrumentVO.getHedgingStopWin(),
                investorInstrumentVO.getHedgingStopLoss(),
                investorInstrumentVO.getInvestorNo(),
                investorInstrumentVO.getInstrumentId()
                );
    }
    
    public int delete(String investorNo, String instrumentId){
        return this.jdbcTemplate.update("DELETE INVESTOR_INSTRUMENT WHERE INVESTOR_NO = ? AND INSTRUMENT_ID = ?", 
                investorNo, instrumentId);
    }
    
    public InvestorInstrumentVO select(String investorNo, String instrumentId){
        
        String sql = "SELECT * FROM INVESTOR_INSTRUMENT WHERE INVESTOR_NO = ? AND INSTRUMENT_ID = ?";
        return this.jdbcTemplate.queryForObject(sql, 
                BeanPropertyRowMapper.newInstance(InvestorInstrumentVO.class), 
                investorNo,instrumentId);
    }
    
    public List<InvestorInstrumentVO> selectList(String investorNo){
        
        String sql = "SELECT * FROM INVESTOR_INSTRUMENT WHERE INVESTOR_NO = ? ORDER BY INSTRUMENT_ID";
        return this.jdbcTemplate.query(sql, 
                BeanPropertyRowMapper.newInstance(InvestorInstrumentVO.class), 
                investorNo);
    }

}
