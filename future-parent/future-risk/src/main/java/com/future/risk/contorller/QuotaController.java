package com.future.risk.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.future.quota.api.exception.QuotaException;
import com.future.quota.api.vo.EMA;
import com.future.risk.consumer.EmaConsumer;
import com.future.risk.vo.ResponseBody;
import com.future.risk.vo.ResponseHead;

@RestController
public class QuotaController {
    
    @Autowired
    private EmaConsumer emaConsumer;
    
    @RequestMapping(value="queryEmaList")
    public ResponseBody<List<EMA>> queryEmaList() throws QuotaException{
        
        ResponseBody<List<EMA>> responseBody = new ResponseBody<List<EMA>>();
        responseBody.setData(this.emaConsumer.queryEmaList());
        return responseBody;
    }
    
    @RequestMapping(value="saveEma", method=RequestMethod.POST)
    public ResponseHead saveEma(@RequestBody EMA ema) throws QuotaException{
        this.emaConsumer.saveEma(ema);
        return new ResponseHead();
    }
    
    @PostMapping(value="importEma")
    public ResponseHead importEma(@RequestBody List<EMA> emas) throws QuotaException{
        
        for (EMA ema : emas) {
            this.emaConsumer.saveEma(ema);
        }
        return new ResponseHead();
    }
    
    @RequestMapping(value="removeEma/{instrumentId}", method=RequestMethod.DELETE)
    public ResponseHead removeEma(@PathVariable String instrumentId) throws QuotaException{
        this.emaConsumer.removeEma(instrumentId);
        return new ResponseHead();
    }
}
