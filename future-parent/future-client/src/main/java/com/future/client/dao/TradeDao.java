package com.future.client.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;

@Repository("tradeDao")
public class TradeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int insert(OnRtnTradeVO tradeVO) {
        
        String sql = "insert into FUTURE_TRADE values (?,?,?,?,?,?,?,?,?,?)";
        return this.jdbcTemplate.update(sql, 
                tradeVO.getInvestorId(),
                tradeVO.getAccountNo(),
                tradeVO.getInstrumentId(),
                tradeVO.getOrderRef(),
                tradeVO.getTradeId(),
                tradeVO.getDirection().getCode(),
                tradeVO.getOrderSysId(),
                tradeVO.getPrice(),
                tradeVO.getVolume(),
                tradeVO.getTradingDay());
    }
    
    public List<OnRtnTradeVO> selectByCondition(String investorId, String accountNo, String instrumentId, String direction) {
        
        String sql = "select * from FUTURE_TRADE where INVESTOR_ID = ? and ACCOUNT_NO = ? and INSTRUMENT_ID = ? and DIRECTION = ?";
        return this.jdbcTemplate.query(sql, 
                new RowMapper<OnRtnTradeVO>() {

                    @Override
                    public OnRtnTradeVO mapRow(ResultSet arg0, int arg1) throws SQLException {
                        OnRtnTradeVO tradeVO = new OnRtnTradeVO();
                        tradeVO.setInvestorId(arg0.getString(1));
                        tradeVO.setAccountNo(arg0.getString(2));
                        tradeVO.setInstrumentId(arg0.getString(3));
                        tradeVO.setOrderRef(arg0.getString(4));
                        tradeVO.setTradeId(arg0.getString(5));
                        tradeVO.setDirection(Direction.ofCode(arg0.getString(6).toCharArray()[0]));
                        tradeVO.setOrderSysId(arg0.getString(7));
                        tradeVO.setPrice(arg0.getDouble(8));
                        tradeVO.setVolume(arg0.getInt(9));
                        tradeVO.setTradingDay(arg0.getString(10));
                        return tradeVO;
                    }
            
                }, 
                instrumentId,accountNo,instrumentId,direction);
    }
    
    public List<OnRtnTradeVO> selectByCondition(String investorId, String accountNo, String instrumentId) {
        
        String sql = "select * from FUTURE_TRADE where INVESTOR_ID = ? and ACCOUNT_NO = ? and INSTRUMENT_ID = ?";
        return this.jdbcTemplate.query(sql, 
                new RowMapper<OnRtnTradeVO>() {

                    @Override
                    public OnRtnTradeVO mapRow(ResultSet arg0, int arg1) throws SQLException {
                        OnRtnTradeVO tradeVO = new OnRtnTradeVO();
                        tradeVO.setInvestorId(arg0.getString(1));
                        tradeVO.setAccountNo(arg0.getString(2));
                        tradeVO.setInstrumentId(arg0.getString(3));
                        tradeVO.setOrderRef(arg0.getString(4));
                        tradeVO.setTradeId(arg0.getString(5));
                        tradeVO.setDirection(Direction.ofCode(arg0.getString(6).toCharArray()[0]));
                        tradeVO.setOrderSysId(arg0.getString(7));
                        tradeVO.setPrice(arg0.getDouble(8));
                        tradeVO.setVolume(arg0.getInt(9));
                        tradeVO.setTradingDay(arg0.getString(10));
                        return tradeVO;
                    }
            
                }, 
                instrumentId,accountNo,instrumentId);
    }
    
    public int deleteByCondition(String investorId, String accountNo, String instrumentId, String direction){
        
        String sql = "delete from FUTURE_TRADE where INVESTOR_ID = ? "
                + "and ACCOUNT_NO = ? "
                + "and INSTRUMENT_ID = ? "
                + "and DIRECTION != ?";
        
        return this.jdbcTemplate.update(sql, 
                instrumentId,accountNo,instrumentId,direction);
    }
}
