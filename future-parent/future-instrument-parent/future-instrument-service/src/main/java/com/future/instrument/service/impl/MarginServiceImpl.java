package com.future.instrument.service.impl;

import java.math.BigDecimal;

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
        
        return null;
    }

}
