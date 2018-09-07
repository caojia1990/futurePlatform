package com.future.risk.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.future.quota.api.exception.QuotaException;
import com.future.quota.api.vo.EMA;
import com.future.risk.consumer.EmaConsumer;
import com.future.risk.vo.ResponseBody;

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
}
