package com.future.instrument.service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.instrument.api.vo.InvestorInstrumentVO;

@Repository("investorInstrumentDao")
public class InvestorInstrumentDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void insert(InvestorInstrumentVO investorInstrumentVO){
        this.jdbcTemplate.update("INSERT INTO INVESTOR_INSTRUMENT VALUES ()", 
                investorInstrumentVO.getInvestorNo(),
                investorInstrumentVO.getInstrumentId(),
                investorInstrumentVO.getStopWin(),
                investorInstrumentVO.getStopLoss(),
                investorInstrumentVO.getStatus(),
                investorInstrumentVO.getTarget(),
                investorInstrumentVO.getRetracement(),
                investorInstrumentVO.getHedgingType(),
                investorInstrumentVO.getHedgingTigger(),
                investorInstrumentVO.getHedgingStopWin(),
                investorInstrumentVO.getHedgingStopLoss()
                
                );
    }

}
