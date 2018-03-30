package com.future.client.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.future.market.api.vo.DepthMarketData;

//@Repository("marketDataDao")
public class MarketDataDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void save(DepthMarketData marketData){
        
        String sql = "insert into t_future_market("
                +"INSTRUMENT_ID,"
                +"EXCHANGE_ID,"
                +"OPEN_PRICE,"
                +"CLOSE_PRICE,"
                +"PRE_CLOSE_PRICE,"
                +"HIGHEST_PRICE,"
                +"LOWEST_PRICE,"
                +"LAST_PRICE,"
                +"VOLUME,"
                +"TURNOVER,"
                +"BID_PRICE1,"
                +"ASK_PRICE1,"
                +"BID_VOLUME1,"
                +"ASK_VOLUME1,"
                +"UPPER_LIMIT_PRICE,"
                +"LOWER_LIMIT_PRICE,"
                +"CURR_DELTA,"
                +"PRE_DELTA,"
                +"PRE_SETTLEMENT_PRICE,"
                +"SETTLEMENT_PRICE,"
                +"OPEN_INTEREST,"
                +"TRADING_DAY,"
                +"UPDATE_TIME,"
                +"UPDATE_MILLISEC,"
                +"CREATE_TIME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        this.jdbcTemplate.update(sql, marketData.getInstrumentID(),
                marketData.getExchangeID(),
                Double.MAX_VALUE==marketData.getOpenPrice()?0:marketData.getOpenPrice(),
                String.valueOf(marketData.getClosePrice()),
                Double.MAX_VALUE==marketData.getPreClosePrice()?0:marketData.getPreClosePrice(),
                Double.MAX_VALUE==marketData.getHighestPrice()?0:marketData.getHighestPrice(),
                Double.MAX_VALUE==marketData.getLowestPrice()?0:marketData.getLowestPrice(),
                Double.MAX_VALUE==marketData.getLastPrice()?0:marketData.getLastPrice(),
                marketData.getVolume(),
                Double.MAX_VALUE==marketData.getTurnover()?0:marketData.getTurnover(),
                Double.MAX_VALUE==marketData.getBidPrice1()?0:marketData.getBidPrice1(),
                Double.MAX_VALUE==marketData.getAskPrice1()?0:marketData.getAskPrice1(),
                        marketData.getBidVolume1(),
                        marketData.getAskVolume1(),
                Double.MAX_VALUE==marketData.getUpperLimitPrice()?0:marketData.getUpperLimitPrice(),
                Double.MAX_VALUE==marketData.getLowerLimitPrice()?0:marketData.getLowerLimitPrice(),
                String.valueOf(marketData.getCurrDelta()),
                String.valueOf(marketData.getPreDelta()),
                Double.MAX_VALUE==marketData.getPreSettlementPrice()?0:marketData.getPreSettlementPrice(),
                String.valueOf(marketData.getSettlementPrice()),
                Double.MAX_VALUE==marketData.getOpenInterest()?0:marketData.getOpenInterest(),
                        marketData.getTradingDate(),
                        marketData.getUpdateTime(),
                        marketData.getUpdateMillisec(),
                        new Date());
    }
    
    public List<String> selectMainInstrumentName(String tradingDay){
        
        //this.jdbcTemplate.query;
        return null; 
    }

}
