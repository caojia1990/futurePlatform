package com.future.risk.consumer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InvestorInstrumentService;
import com.future.instrument.api.vo.InvestorInstrumentVO;

@Component
public class InvestorInstrumentConsumer {

    @Reference(check = false)
    private InvestorInstrumentService investorInstrumentService;
    
    public List<InvestorInstrumentVO> queryInstruments(String investorNo) throws InstrumentException{
        return this.investorInstrumentService.queryInvestorInstrumentList(investorNo);
    }
    
    public void saveInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException{
        this.investorInstrumentService.saveInvestorInstrument(investorInstrumentVO);
    }
    
    public void updateInvestorInstrument(InvestorInstrumentVO investorInstrumentVO) throws InstrumentException{
        this.investorInstrumentService.updateInvestorInstrument(investorInstrumentVO);
    }
    
    public void removeInvestorInstrument(String investorNo, String instrumentId) throws InstrumentException{
        this.investorInstrumentService.removeInvestorInstrument(investorNo, instrumentId);
    }
}
