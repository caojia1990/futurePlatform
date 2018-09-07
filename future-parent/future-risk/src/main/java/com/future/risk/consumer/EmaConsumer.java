package com.future.risk.consumer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.future.quota.api.exception.QuotaException;
import com.future.quota.api.service.EmaService;
import com.future.quota.api.vo.EMA;

@Component
public class EmaConsumer {

    @Reference(check=false,timeout=5000)
    private EmaService emaService;
    
    public List<EMA> queryEmaList() throws QuotaException{
        return this.emaService.queryEmaList();
    }
    
    public void saveEma(EMA ema) throws QuotaException{
        this.emaService.saveOrUpdateEma(ema);
    }
    
    public void removeEma(String instrumentId) throws QuotaException{
        this.emaService.remove(instrumentId);
    }
}
