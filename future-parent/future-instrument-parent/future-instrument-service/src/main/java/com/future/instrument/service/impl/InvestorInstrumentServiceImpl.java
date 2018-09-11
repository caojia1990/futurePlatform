package com.future.instrument.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

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

        if(StringUtils.isBlank(investorInstrumentVO.getInvestorNo())){
            throw new InstrumentException(InstrumentError.INVESTOR_NO_REQUIRED);
        }
        
        if(StringUtils.isBlank(investorInstrumentVO.getInstrumentId())){
            throw new InstrumentException(InstrumentError.INSTRUMENT_ID_REQUIRED);
        }
        
        if(investorInstrumentVO.getVolume() == null || investorInstrumentVO.getVolume() < 1){
            throw new InstrumentException(InstrumentError.VOLUME_ILLEGAL);
        }
        
        if(StringUtils.isBlank(investorInstrumentVO.getStatus())){
            throw new InstrumentException(InstrumentError.STATUS_REQUIRED);
        }
        
        if(investorInstrumentVO.getTarget() == null){
            throw new InstrumentException(InstrumentError.TARGET_REQUIRED);
        }
        
        if(investorInstrumentVO.getRetracement() == null){
            throw new InstrumentException(InstrumentError.RETRACEMENT_REQUIRED);
        }
        
        if(StringUtils.isBlank(investorInstrumentVO.getHedgingType())){
            throw new InstrumentException(InstrumentError.HEDGING_TYPE_REQUIRED);
        }
        
        if(investorInstrumentVO.getHedgingTigger() == null || investorInstrumentVO.getHedgingTigger().compareTo(BigDecimal.ZERO) < 0){
            throw new InstrumentException(InstrumentError.HEDGING_TIGGER_ILLEGAL);
        }
        
        if(investorInstrumentVO.getHedgingVolume() == null || investorInstrumentVO.getHedgingVolume() < 1){
            throw new InstrumentException(InstrumentError.HEDGING_VOLUME_ILLEGAL);
        }
        
        if(investorInstrumentVO.getHedgingStopWin() == null || investorInstrumentVO.getHedgingStopWin() < 1){
            throw new InstrumentException(InstrumentError.HEDGING_STOP_WIN_ILLEGAL);
        }
        
        InvestorInstrumentVO instrumentVO = null;
        try {
            instrumentVO = this.investorInstrumentDao.select(investorInstrumentVO.getInvestorNo(),
                    investorInstrumentVO.getInstrumentId());
            //合约已经存在
        } catch (EmptyResultDataAccessException e) {
            //没有找到该合约，可以继续保存
        } catch (Exception e) {
            logger.error("查询合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        
        if(instrumentVO != null){
            throw new InstrumentException(InstrumentError.INSTRUMENT_ALREADY_EXSITS);
        }
        
        try {
            this.investorInstrumentDao.insert(investorInstrumentVO);
        } catch (Exception e) {
            logger.error("保存合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        
        rabbitTemplate.convertAndSend(investorInstrumentVO.getInvestorNo(), investorInstrumentVO);
    }

    @Override
    public void updateInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException {
        
        if(StringUtils.isBlank(investorInstrumentVO.getInvestorNo())){
            throw new InstrumentException(InstrumentError.INVESTOR_NO_REQUIRED);
        }
        
        if(StringUtils.isBlank(investorInstrumentVO.getInstrumentId())){
            throw new InstrumentException(InstrumentError.INSTRUMENT_ID_REQUIRED);
        }
        
        if(investorInstrumentVO.getVolume() == null || investorInstrumentVO.getVolume() < 1){
            throw new InstrumentException(InstrumentError.VOLUME_ILLEGAL);
        }
        
        if(StringUtils.isBlank(investorInstrumentVO.getStatus())){
            throw new InstrumentException(InstrumentError.STATUS_REQUIRED);
        }
        
        if(investorInstrumentVO.getTarget() == null){
            throw new InstrumentException(InstrumentError.TARGET_REQUIRED);
        }
        
        if(investorInstrumentVO.getRetracement() == null){
            throw new InstrumentException(InstrumentError.RETRACEMENT_REQUIRED);
        }
        
        if(StringUtils.isBlank(investorInstrumentVO.getHedgingType())){
            throw new InstrumentException(InstrumentError.HEDGING_TYPE_REQUIRED);
        }
        
        if(investorInstrumentVO.getHedgingTigger() == null || investorInstrumentVO.getHedgingTigger().compareTo(BigDecimal.ZERO) < 0){
            throw new InstrumentException(InstrumentError.HEDGING_TIGGER_ILLEGAL);
        }
        
        if(investorInstrumentVO.getHedgingVolume() == null || investorInstrumentVO.getHedgingVolume() < 1){
            throw new InstrumentException(InstrumentError.HEDGING_VOLUME_ILLEGAL);
        }
        
        if(investorInstrumentVO.getHedgingStopWin() == null || investorInstrumentVO.getHedgingStopWin() < 1){
            throw new InstrumentException(InstrumentError.HEDGING_STOP_WIN_ILLEGAL);
        }
        
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
