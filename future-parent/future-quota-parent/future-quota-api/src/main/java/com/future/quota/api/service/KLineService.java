package com.future.quota.api.service;

import java.util.List;

import com.future.quota.api.vo.Kline;

public interface KLineService {
    
    /**
     * 根据交易日和周期查询k线
     * @param tradingDay
     * @param period
     * @return
     */
    public List<Kline> queryKLineByTradingDay(String tradingDay, String period);

}
