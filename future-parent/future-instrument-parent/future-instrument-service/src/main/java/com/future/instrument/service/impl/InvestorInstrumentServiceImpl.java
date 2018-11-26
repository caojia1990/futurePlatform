package com.future.instrument.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.future.instrument.api.exception.InstrumentError;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InvestorInstrumentService;
import com.future.instrument.api.vo.InstrumentMessage;
import com.future.instrument.api.vo.InvestorInstrumentVO;
import com.future.instrument.api.vo.StaircaseHedgingVO;
import com.future.instrument.service.dao.InvestorInstrumentDao;
import com.future.instrument.service.dao.StaircaseHedgingDao;

public class InvestorInstrumentServiceImpl implements InvestorInstrumentService {
    
    static Logger logger = Logger.getLogger(InvestorInstrumentServiceImpl.class);
    
    @Autowired
    private InvestorInstrumentDao investorInstrumentDao;
    
    @Autowired
    private StaircaseHedgingDao hedgingDao;
    
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
        
        if(investorInstrumentVO.getHedgingType().equals("3") && investorInstrumentVO.getHedgingVOs() == null){
            throw new InstrumentException(InstrumentError.GREES_HEDGING_REQUIRED);
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
            //保存阶梯对冲信息
            this.hedgingDao.delete(investorInstrumentVO.getInstrumentId());
            if(investorInstrumentVO.getHedgingVOs() != null){
                List<StaircaseHedgingVO> list = JSON.parseArray(investorInstrumentVO.getHedgingVOs(), StaircaseHedgingVO.class);
                investorInstrumentVO.setHedgingList(list);
                for (StaircaseHedgingVO vo : list) {
                    this.hedgingDao.insert(vo);
                }
            }
        } catch (Exception e) {
            logger.error("保存合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        
        InstrumentMessage message = new InstrumentMessage();
        message.setMessageType("0");
        message.setMessage(investorInstrumentVO);
        rabbitTemplate.convertAndSend(investorInstrumentVO.getInvestorNo(), message);
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
        
        if(investorInstrumentVO.getHedgingType().equals("3") && investorInstrumentVO.getHedgingVOs() == null){
            throw new InstrumentException(InstrumentError.GREES_HEDGING_REQUIRED);
        }
        
        try {
            this.investorInstrumentDao.update(investorInstrumentVO);
            //保存阶梯对冲信息
            this.hedgingDao.delete(investorInstrumentVO.getInstrumentId());
            if(investorInstrumentVO.getHedgingVOs() != null){
                List<StaircaseHedgingVO> list = JSON.parseArray(investorInstrumentVO.getHedgingVOs(), StaircaseHedgingVO.class);
                investorInstrumentVO.setHedgingList(list);
                for (StaircaseHedgingVO vo : list) {
                    this.hedgingDao.insert(vo);
                }
            }
        } catch (Exception e) {
            logger.error("更新合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        
        InstrumentMessage message = new InstrumentMessage();
        message.setMessageType("1");
        message.setMessage(investorInstrumentVO);
        rabbitTemplate.convertAndSend(investorInstrumentVO.getInvestorNo(), message);

    }

    @Override
    public void removeInvestorInstrument(String investorNo, String instrumentId) throws InstrumentException {
        
        try {
            this.investorInstrumentDao.delete(investorNo, instrumentId);
            this.hedgingDao.delete(instrumentId);
        } catch (Exception e) {
            logger.error("删除合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        
        InstrumentMessage message = new InstrumentMessage();
        message.setMessageType("2");
        InvestorInstrumentVO investorInstrumentVO = new InvestorInstrumentVO();
        investorInstrumentVO.setInvestorNo(investorNo);
        investorInstrumentVO.setInstrumentId(instrumentId);
        message.setMessage(investorInstrumentVO);
        rabbitTemplate.convertAndSend(investorNo, message);

    }

    @Override
    public List<InvestorInstrumentVO> queryInvestorInstrumentList(String investorNo) throws InstrumentException {

        List<InvestorInstrumentVO> list = null;
        try {
            list = this.investorInstrumentDao.selectList(investorNo);
            if(list != null){
                for (InvestorInstrumentVO investorInstrumentVO : list) {
                    List<StaircaseHedgingVO> hedgingList = this.hedgingDao.selectList(investorInstrumentVO.getInstrumentId());
                    investorInstrumentVO.setHedgingList(hedgingList);
                    investorInstrumentVO.setHedgingVOs(JSON.toJSONString(hedgingList));
                }
            }
        } catch (Exception e) {
            logger.error("查询合约信息失败",e);
            throw new InstrumentException(InstrumentError.DATABASE_FAILED,e);
        }
        
        return list;
    }

}
