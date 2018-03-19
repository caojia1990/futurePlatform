package com.future.instrument.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.service.MarginService;
import com.future.instrument.api.vo.InstrumentMarginRateVO;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.instrument.api.vo.InvestorTradeParamVO;

@Service("marginService")
public class MarginServiceImpl implements MarginService {
    
    @Autowired
    private InstrumentService instrumentService;

    @Override
    public InstrumentMarginRateVO queryInstrumentMargin(String instrumentID) throws InstrumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal calculateMargin(InvestorTradeParamVO paramVO) throws InstrumentException {

        InstrumentVO instrumentVO = this.instrumentService.queryInstrument(paramVO.getInstrumentID());
        
        BigDecimal marginRatio = BigDecimal.ZERO;
        if("0".equals(paramVO.getDirection())) {
        		marginRatio = new BigDecimal(instrumentVO.getLongMarginRatio());
        }else {
			marginRatio = new BigDecimal(instrumentVO.getShortMarginRatio());
		}
        
        if("1".equals(paramVO.getPriceType())) {
        		//市价
        }else if("2".equals(paramVO.getPriceType())) {
			//限价
        		//每手保证金=成交金额*保证金比例=指定价*合约乘数*保证金比例
        		return paramVO.getLimitPrice()
        				.multiply(new BigDecimal(instrumentVO.getVolumeMultiple()))
        				.multiply(marginRatio).setScale(2, RoundingMode.HALF_UP);
		}
        
        return null;
    }

}
