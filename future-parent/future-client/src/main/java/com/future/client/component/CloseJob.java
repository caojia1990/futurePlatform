package com.future.client.component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.future.trade.api.exception.TradeException;
import com.future.trade.api.service.TradeService;

//@Component
public class CloseJob implements InitializingBean {
    
    @Autowired
    private TradeService tradeService;

    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            
            @Override
            public void run() {
                try {
                    tradeService.reqOrderInsert(null);
                } catch (TradeException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        
    }

}
