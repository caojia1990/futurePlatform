package com.future.client.component;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.future.instrument.api.service.InstrumentService;

//@Component
public class TableCreateBean implements InitializingBean {
    
    @Autowired
    private JdbcTemplate JdbcTemplate;
    
    @Autowired
    private InstrumentService instrumentService;

    @Override
    public void afterPropertiesSet() throws Exception {
        
        List<String> instruments = this.instrumentService.queryInstrumentName();
        if(instruments != null && instruments.size() > 0 ){
            for (String instrumentID : instruments) {
                
                try {
                    this.JdbcTemplate.execute("CREATE TABLE FUTURE_"+instrumentID+"_TICK("
                            + "TRADING_DAY varchar(8),"
                            + "UPDATE_TIME varchar(8),"
                            + "UPDATE_MILLISECS int,"
                            + "LAST_PRICE double,"
                            + "BID_PRICE double,"
                            + "BID_VOLUME int,"
                            + "ASK_PRICE double,"
                            + "ASK_VOLUME int,"
                            + "OPEN_PRICE double,"
                            + "HIGHEST_PRICE double,"
                            + "LOWEST_PRICE double,"
                            + "UPPER_LIMIT_PRICE double,"
                            + "LOWER_LIMIT_PRICE double,"
                            + "CLOSE_PRICE double,"
                            + "PRE_CLOSE_PRICE double,"
                            + "SETTLEMENT_PRICE double,"
                            + "PRE_SETTLEMENT_PRICE double,"
                            + "VOLUME int,"
                            + "AVERAGE_PRICE double,"
                            + "AVERAGE_VOLUME int,"
                            + "OPEN_INTEREST double,"
                            + "TURNOVER double)");
                } catch (Exception e) {
                    if(e.getMessage().indexOf("already exists") > -1){
                        System.out.println(instrumentID+"已存在");
                        continue;
                    }
                }
            }
        }
        
    }

}
