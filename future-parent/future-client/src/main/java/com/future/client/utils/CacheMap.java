package com.future.client.utils;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.future.client.entity.Tick;
import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.instrument.api.vo.InvestorInstrumentVO;

@Repository("cacheMap")
public class CacheMap {
    
    @Autowired
    private InstrumentService instrumentService;
    
    private Map<String,InstrumentVO> instrumentMap = new HashMap<>();
    
    public static Map<String, InvestorInstrumentVO> INVESTOR_INSTRUMENT = new Hashtable<>();
    /**
     * 缓存上一条行情
     */
    public Map<String, Tick> tickMap = new HashMap<>();
    
    /**
     * 查询合约属性
     * @param instrumentID
     * @return
     * @throws InstrumentException
     */
    public InstrumentVO getInstrument(String instrumentID) throws InstrumentException{
        
        if(instrumentMap.get(instrumentID) == null){
            instrumentMap.put(instrumentID, this.instrumentService.queryInstrument(instrumentID));
        }
        
        return instrumentMap.get(instrumentID);
    }
    
    /**
     * 查询合约最小跳动价格
     * @param instrumentID
     * @return
     * @throws InstrumentException
     */
    public double getTickPrice(String instrumentID) throws InstrumentException{
        
        if(instrumentMap.get(instrumentID) == null){
            instrumentMap.put(instrumentID, this.instrumentService.queryInstrument(instrumentID));
        }
        
        return instrumentMap.get(instrumentID).getPriceTick();
    }
    
    
}
