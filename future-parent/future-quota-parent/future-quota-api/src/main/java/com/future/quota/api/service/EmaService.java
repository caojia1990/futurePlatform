package com.future.quota.api.service;

import java.util.List;

import com.future.quota.api.exception.QuotaException;
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
    public List<EMA> queryEmaByTradingDay(String tradingDay) throws QuotaException;
    
    /**
     * 查询最新EMA指标
     * @return
     * @throws QuotaException
     */
    public List<EMA> queryEmaList() throws QuotaException;
    
    /**
     * 更新或保存EMA
     * @param ema
     * @throws QuotaException
     */
    public void saveOrUpdateEma(EMA ema) throws QuotaException;
    
    /**
     * 删除EMA
     * @param instrumentId
     * @throws QuotaException
     */
    public void remove(String instrumentId) throws QuotaException;
    
}
