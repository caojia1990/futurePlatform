package com.future.order.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.future.order.api.vo.Direction;
import com.future.order.api.vo.HedgeFlag;
import com.future.order.api.vo.InvestorPositionDetailVO;

@Repository("investorPositionDetailDao")
public class InvestorPositionDetailDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(InvestorPositionDetailVO r) {
        
        return jdbcTemplate.update("INSERT INTO FUTURE_INVESTOR_POSI_DETAIL VALUES(?,?,?,?,?,?,?,?,?)", "");
    }
    
    public List<InvestorPositionDetailVO> selectByCondition(String accountNo, String instrumentID, Direction direction){
        
        return this.jdbcTemplate.query("SELECT * FROM FUTURE_INVESTOR_POSI_DETAIL WHERE ACCOUNT_NO = ? "
                + "AND INSTRUMENT_ID = ? AND DIRECTION != ? AND VOLUME != 0"
                + "ORDER BY TRADE_ID", 
                new RowMapper<InvestorPositionDetailVO>(){

                    @Override
                    public InvestorPositionDetailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        InvestorPositionDetailVO detailVO = new InvestorPositionDetailVO();
                        detailVO.setAccountNo(rs.getString("ACCOUNT_NO"));
                        detailVO.setCombInstrumentID(rs.getString("COMB_INSTRUMENT_ID"));
                        detailVO.setDirection(Direction.ofCode(rs.getString("DIRECTION").charAt(0)));
                        detailVO.setHedgeFlag(HedgeFlag.ofCode(rs.getString("HEDGE_FLAG").charAt(0)));
                        detailVO.setInstrumentID(rs.getString("INSTRUMENT_ID"));
                        detailVO.setInvestorID(rs.getString("INVESTOR_ID"));
                        detailVO.setOpenDate(rs.getString("OPEN_DATE"));
                        detailVO.setOpenPrice(rs.getBigDecimal("OPEN_PRICE"));
                        detailVO.setSettlementID(rs.getString("SETTLEMENT_ID"));
                        detailVO.setTradeID(rs.getString("TRADE_ID"));
                        detailVO.setTradeType(rs.getString("TRADE_TYPE").charAt(0));
                        detailVO.setTradingDay(rs.getString("TRADING_DAY"));
                        detailVO.setVolume(rs.getInt("VOLUME"));
                        return detailVO;
                    }
                },
                accountNo, instrumentID, direction.getCode());
    }
    
    public List<InvestorPositionDetailVO> selectByCondition(String accountNo, String instrumentID, Direction direction, String tradeDate){
        
        return this.jdbcTemplate.query("SELECT * FROM FUTURE_INVESTOR_POSI_DETAIL WHERE ACCOUNT_NO = ? "
                + "AND INSTRUMENT_ID = ? AND DIRECTION != ? AND VOLUME != 0 and OPEN_DATE = ?"
                + "ORDER BY TRADE_ID", 
                new RowMapper<InvestorPositionDetailVO>(){

                    @Override
                    public InvestorPositionDetailVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        InvestorPositionDetailVO detailVO = new InvestorPositionDetailVO();
                        detailVO.setAccountNo(rs.getString("ACCOUNT_NO"));
                        detailVO.setCombInstrumentID(rs.getString("COMB_INSTRUMENT_ID"));
                        detailVO.setDirection(Direction.ofCode(rs.getString("DIRECTION").charAt(0)));
                        detailVO.setHedgeFlag(HedgeFlag.ofCode(rs.getString("HEDGE_FLAG").charAt(0)));
                        detailVO.setInstrumentID(rs.getString("INSTRUMENT_ID"));
                        detailVO.setInvestorID(rs.getString("INVESTOR_ID"));
                        detailVO.setOpenDate(rs.getString("OPEN_DATE"));
                        detailVO.setOpenPrice(rs.getBigDecimal("OPEN_PRICE"));
                        detailVO.setSettlementID(rs.getString("SETTLEMENT_ID"));
                        detailVO.setTradeID(rs.getString("TRADE_ID"));
                        detailVO.setTradeType(rs.getString("TRADE_TYPE").charAt(0));
                        detailVO.setTradingDay(rs.getString("TRADING_DAY"));
                        detailVO.setVolume(rs.getInt("VOLUME"));
                        return detailVO;
                    }
                },
                accountNo, instrumentID, direction.getCode(), tradeDate);
    }

}
