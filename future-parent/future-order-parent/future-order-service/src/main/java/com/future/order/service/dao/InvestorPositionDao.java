package com.future.order.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.future.order.api.vo.Direction;
import com.future.order.api.vo.HedgeFlag;
import com.future.order.api.vo.InvestorPositionVO;

@Repository("investorPositionDao")
public class InvestorPositionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(InvestorPositionVO record) {
        
        return jdbcTemplate.update("INSERT INTO FUTURE_INVESTOR_POSITION VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 
                record.getInstrumentID(),
                record.getInvestorID(),
                record.getAccountNo(),
                record.getPosiDirection().getCode(),
                record.getHedgeFlag().getCode(),
                record.getYdPosition(),
                record.getPosition(),
                record.getYdPositionFrozen(),
                record.getPositionFrozen(),
                record.getOpenVolume(),
                record.getCloseVolume(),
                record.getOpenAmount(),
                record.getPositionCost(),
                record.getPreMargin(),
                record.getUseMargin(),
                record.getFrozenCommission(),
                record.getCommission(),
                record.getCloseProfit(),
                record.getPositionProfit(),
                record.getPreSettlementPrice(),
                record.getSettlementPrice(),
                record.getTradingDay(),
                record.getSettlementID());
    }
    
    public int update(InvestorPositionVO record) {
        String sql = "update FUTURE_INVESTOR_POSITION"
                + "set INVESTOR_ID = ?,"
                + "HEDGE_FLAG = ?,"
                + "YD_POSITION = ?,"
                + "POSITION = ?,"
                + "YD_POSITION_FROZEN = ?,"
                + "POSITION_FROZEN = ?,"
                + "OPEN_VOLUME = ?,"
                + "CLOSE_VOLUME = ?,"
                + "OPEN_AMOUNT = ?,"
                + "POSITION_COST = ?,"
                + "PRE_MARGIN = ?,"
                + "USE_MARGIN = ?,"
                + "FROZEN_COMMISSION = ?,"
                + "COMMISSION = ?,"
                + "CLOSE_PROFIT = ?,"
                + "POSITION_PROFIT = ?,"
                + "PRE_SETTLEMENT_PRICE = ?,"
                + "SETTLEMENT_PRICE = ?,"
                + "TRADING_DAY = ?,"
                + "SETTLEMENT_ID = ?"
                + "WHERE ACCOUNT_NO = ? AND INSTRUMENT_ID = ? AND POSI_DIRECTION = ?";
        
        return jdbcTemplate.update(sql, record.getInvestorID(),
                record.getHedgeFlag().getCode(),
                record.getYdPosition(),
                record.getPosition(),
                record.getYdPositionFrozen(),
                record.getPositionFrozen(),
                record.getOpenVolume(),
                record.getCloseVolume(),
                record.getOpenAmount(),
                record.getPositionCost(),
                record.getPreMargin(),
                record.getUseMargin(),
                record.getFrozenCommission(),
                record.getCommission(),
                record.getCloseProfit(),
                record.getPositionProfit(),
                record.getPreSettlementPrice(),
                record.getSettlementPrice(),
                record.getTradingDay(),
                record.getSettlementID(),
                record.getAccountNo(),
                record.getInstrumentID(),
                record.getPosiDirection().getCode());
    }
    
    public InvestorPositionVO selectByCondition(String accountNo, String instrument, Direction direction) {
        
        return jdbcTemplate.queryForObject("SELECT * FROM FUTURE_INVESTOR_POSITION "
                + "WHERE ACCOUNT_NO = ? AND INSTRUMENT_ID = ? AND POSI_DIRECTION = ?", 
                new RowMapper<InvestorPositionVO>() {

                    @Override
                    public InvestorPositionVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                        InvestorPositionVO r = new InvestorPositionVO();
                        r.setAccountNo(rs.getString("ACCOUNT_NO"));
                        r.setCloseProfit(rs.getBigDecimal("CLOSE_PROFIT"));
                        r.setCloseVolume(rs.getInt("CLOSE_VOLUME"));
                        r.setCommission(rs.getBigDecimal("COMMISSION"));
                        r.setFrozenCommission(rs.getBigDecimal("FROZEN_COMMISSION"));
                        r.setHedgeFlag(HedgeFlag.ofCode(rs.getString("Hedge_Flag").charAt(0)));
                        r.setInstrumentID(rs.getString("INSTRUMENT_ID"));
                        r.setInvestorID(rs.getString("INVESTOR_ID"));
                        r.setOpenAmount(rs.getBigDecimal("OPEN_AMOUNT"));
                        r.setOpenVolume(rs.getInt("OPEN_VOLUME"));
                        r.setPosiDirection(Direction.ofCode(rs.getString("POSI_DIRECTION").charAt(0)));
                        r.setPosition(rs.getInt("POSITION"));
                        r.setPositionCost(rs.getBigDecimal("POSITION_COST"));
                        r.setPositionFrozen(rs.getInt("POSITION_FROZEN"));
                        r.setPositionProfit(rs.getBigDecimal("POSITION_PROFIT"));
                        r.setPreMargin(rs.getBigDecimal("PRE_MARGIN"));
                        r.setPreSettlementPrice(rs.getBigDecimal("PRE_SETTLEMENT_PRICE"));
                        r.setSettlementID(rs.getString("SETTLEMENT_ID"));
                        r.setSettlementPrice(rs.getBigDecimal("SETTLEMENT_PRICE"));
                        r.setTradingDay(rs.getString("TRADING_DAY"));
                        r.setUseMargin(rs.getBigDecimal("USE_MARGIN"));
                        r.setYdPosition(rs.getInt("YD_POSITION"));
                        r.setYdPositionFrozen(rs.getInt("YD_POSITION_FROZEN"));
                        return r;
                    }
                    
                },
                accountNo, instrument, direction.getCode());
        
    }
}
