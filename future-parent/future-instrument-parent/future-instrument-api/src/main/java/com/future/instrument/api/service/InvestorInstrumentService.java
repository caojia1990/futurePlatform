package com.future.instrument.api.service;

import java.util.List;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InvestorInstrumentVO;

public interface InvestorInstrumentService {

    /**
     * 查询投资者订阅的合约信息
     * @param investorNo
     * @param instrumentId
     * @return
     * @throws InstrumentException
     */
    public InvestorInstrumentVO queryInvestorInstrument(String investorNo, String instrumentId) throws InstrumentException;
    
    /**
     * 查询投资者合约列表
     * @param investorNo
     * @return
     * @throws InstrumentException
     */
    public List<InvestorInstrumentVO> queryInvestorInstrumentList(String investorNo) throws InstrumentException;
    
    /**
     * 添加用户合约
     * @param investorInstrumentVO
     * @throws InstrumentException
     */
    public void saveInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException;
    
    /**
     * 修改用户合约
     * @param investorInstrumentVO
     * @throws InstrumentException
     */
    public void updateInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException;
    
    /**
     * 删除用户合约
     * @param investorNo
     * @param instrumentId
     * @throws InstrumentException
     */
    public void removeInvestorInstrument(String investorNo, String instrumentId) throws InstrumentException;
    
}
