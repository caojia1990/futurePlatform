package com.future.instrument.api.service;

import com.future.instrument.api.vo.InstrumentField;

/**
 * 合约接口
 * @author caojia
 */
public interface InstrumentService {
    
    /**
     * 查询合约详情
     * @param instrumentID 合约代码
     * @return
     */
    public InstrumentField queryInstrument(String instrumentID);

}
