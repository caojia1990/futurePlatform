package com.future.risk.consumer;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.future.instrument.api.service.InstrumentService;

@Component
public class InstrumentConsumer {

    @Reference
    private InstrumentService instrumentService;
}
