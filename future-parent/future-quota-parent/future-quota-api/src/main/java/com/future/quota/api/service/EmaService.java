package com.future.quota.api.service;

import java.util.List;

import com.future.quota.api.vo.EMA;

/**
 * 查询EMA指标
 * @author caojia
 */
public interface EmaService {

    /**
     * 根据交易日查询ema均线
     * @param tradingDay
     * @return
     */
    public List<EMA> queryEmaByTradingDay(String tradingDay);
    
    
}
