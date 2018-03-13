package com.future.instrument.api.service;

import java.util.List;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InstrumentCommissionRateVO;
import com.future.instrument.api.vo.InstrumentVO;

/**
 * 合约接口
 * @author caojia
 */
public interface InstrumentService {
    
    /**
     * 查询当前交易日合约详情
     * @param instrumentID 合约代码
     * @return
     */
    public InstrumentVO queryInstrument(String instrumentID);
    
    /**
     * 查询指定交易日合约详情
     * @param instrumentID
     * @param tradingDate
     * @return never returns null
     * @exception InstrumentException if no instrumentID found
     */
    public InstrumentVO queryInstrument(String instrumentID, String tradingDate) throws InstrumentException;
    
    /**
     * 查询当前交易日所有合约名称
     * @return
     */
    public List<String> queryInstrumentName();
    
    /**
     * 查询指定交易日所有合约名称
     * @param tradingDate
     * @return
     */
    public List<String> queryInstrumentName(String tradingDate);
    
    /**
     * 保存合约信息到redis
     * @param instrumentVO
     */
    public void saveInstrument(InstrumentVO instrumentVO);
    
    /**
     * 保存合约信息到数据库
     * @param instrumentVO
     */
    public void saveInstrument(String tradingDate, InstrumentVO instrumentVO);
    
    /**
     * 从redis中删除合约
     */
    public void removeInstrument();
    
    /**
     * 从数据库中删除合约
     * @param tradingDate
     */
    public void removeInstrument(String tradingDate);
    
}
