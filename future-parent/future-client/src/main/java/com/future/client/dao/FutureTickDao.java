package com.future.client.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.future.market.api.vo.DepthMarketData;

@Component
public class FutureTickDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 保存tick数据
     * @param instrumentId
     * @param depthMarketData
     */
    public void saveTick(String instrumentId, DepthMarketData depthMarketData){
        
        String sql = "insert into FUTURE_" + instrumentId + "_TICK values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        this.jdbcTemplate.update(sql, 
                depthMarketData.getTradingDate(),
                depthMarketData.getUpdateTime(),
                depthMarketData.getUpdateMillisec(),
                depthMarketData.getLastPrice(),
                depthMarketData.getBidPrice1(),
                depthMarketData.getBidVolume1(),
                depthMarketData.getAskPrice1(),
                depthMarketData.getAskVolume1(),
                depthMarketData.getOpenPrice(),
                depthMarketData.getHighestPrice(),
                depthMarketData.getLowestPrice(),
                depthMarketData.getUpperLimitPrice(),
                depthMarketData.getLowerLimitPrice(),
                depthMarketData.getClosePrice(),
                depthMarketData.getPreClosePrice(),
                depthMarketData.getSettlementPrice(),
                depthMarketData.getPreSettlementPrice(),
                depthMarketData.getVolume(),
                depthMarketData.getAveragePrice(),
                null,
                depthMarketData.getOpenInterest(),
                depthMarketData.getTurnover());
    }
}
