package com.future.instrument.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.future.instrument.api.exception.InstrumentError;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InvestorInstrumentService;
import com.future.instrument.api.vo.InvestorInstrumentVO;
import com.future.instrument.service.dao.InvestorInstrumentDao;

public class InvestorInstrumentServiceImpl implements InvestorInstrumentService {
    
    static Logger logger = Logger.getLogger(InvestorInstrumentServiceImpl.class);
    
    @Autowired
    private InvestorInstrumentDao investorInstrumentDao;

    @Override
    public InvestorInstrumentVO queryInvestorInstrument(String investorNo, String instrumentId) throws InstrumentException {
        
        InvestorInstrumentVO investorInstrumentVO = null;
        try {
            investorInstrumentVO = this.investorInstrumentDao.select(investorNo, instrumentId);
        } catch (EmptyResultDataAccessException e) {
            logger.warn("无此合约信息："+instrumentId);
            throw new InstrumentException(InstrumentError.INSTRUMENT_NOT_EXSITS,e);
        } catch (Exception e) {
            logger.error("查询合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        return investorInstrumentVO;
        
    }

    @Override
    public void saveInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException {

        try {
            this.investorInstrumentDao.insert(investorInstrumentVO);
        } catch (Exception e) {
            logger.error("保存合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
    }

    @Override
    public void updateInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException {
        
        try {
            this.investorInstrumentDao.update(investorInstrumentVO);
        } catch (Exception e) {
            logger.error("更新合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }

    }

    @Override
    public void removeInvestorInstrument(String investorNo, String instrumentId) throws InstrumentException {
        
        try {
            this.investorInstrumentDao.delete(investorNo, instrumentId);
        } catch (Exception e) {
            logger.error("删除合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }

    }

    @Override
    public List<InvestorInstrumentVO> queryInvestorInstrumentList(String investorNo) throws InstrumentException {

        List<InvestorInstrumentVO> list = null;
        try {
            list = this.investorInstrumentDao.selectList(investorNo);
        } catch (Exception e) {
            logger.error("查询合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        return list;
    }

}
