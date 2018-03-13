package com.future.instrument.api.service;

import java.math.BigDecimal;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InstrumentMarginRateVO;
import com.future.instrument.api.vo.InvestorTradeParamVO;

/**
 * 保证金接口
 * @author caojia
 *
 */
public interface MarginService {
    
    /**
     * 查询当前交易日合约保证金
     * @param instrumentID
     * @return
     */
    public InstrumentMarginRateVO queryInstrumentMargin(String instrumentID) throws InstrumentException;
    
    /**
     * 计算交易保证金
     * @return 保证金金额
     * @throws InstrumentException
     */
    public BigDecimal calculateMargin(InvestorTradeParamVO paramVO) throws InstrumentException;

}
