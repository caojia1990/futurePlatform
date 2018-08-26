package com.future.risk.consumer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentVO;

@Component
public class InstrumentConsumer {

    @Reference
    private InstrumentService instrumentService;
    
    public InstrumentVO queryInstrument(String instrumentId) throws InstrumentException{
        return this.instrumentService.queryInstrument(instrumentId);
    }
    
    public List<String> queryInstrumentName(){
        return this.instrumentService.queryInstrumentName();
    }
}
