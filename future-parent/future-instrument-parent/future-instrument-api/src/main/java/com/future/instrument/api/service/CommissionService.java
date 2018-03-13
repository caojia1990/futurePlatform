package com.future.instrument.api.service;

import java.math.BigDecimal;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InstrumentCommissionRateVO;
import com.future.instrument.api.vo.InvestorTradeParamVO;

/**
 * 手续费接口
 * @author caojia
 *
 */
public interface CommissionService {

    /**
     * 查询当前交易日合约手续费
     * @param instrumentID
     * @return
     */
    public InstrumentCommissionRateVO queryInstrumentCommission(String instrumentID);
    
    /**
     * 查询用户当前交易日合约手续费
     * @param instrumentID
     * @return never returns null
     * @exception InstrumentException if no InvestorCommission found
     */
    public InstrumentCommissionRateVO queryInvestorCommission(String investorNo, String instrumentID) throws InstrumentException;
    
    /**
     * 计算交易手续费
     * @return 手续费金额
     * @throws InstrumentException
     */
    public BigDecimal calculateCommission(InvestorTradeParamVO paramVO) throws InstrumentException;
}
