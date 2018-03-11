package com.future.market.service.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentCommissionRateVO;
import com.future.instrument.api.vo.InstrumentVO;

/**
 * 合约接口mock
 * @author caoji_000
 *
 */
@Service("InstrumentService")
public class InstrumentServiceImpl implements InstrumentService{

    @Override
    public InstrumentVO queryInstrument(String instrumentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InstrumentVO queryInstrument(String instrumentID, String tradingDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> queryInstrumentName() {
        List<String> list = new ArrayList<>();
        list.add("cu1804");
        list.add("cu1805");
        list.add("cu1806");
        list.add("rb1806");
        list.add("rb1807");
        list.add("rb1808");
        list.add("m1805");
        list.add("m1809");
        return list;
    }

    @Override
    public List<String> queryInstrumentName(String tradingDate) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveInstrument(InstrumentVO instrumentVO) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saveInstrument(String tradingDate, InstrumentVO instrumentVO) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeInstrument() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeInstrument(String tradingDate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public InstrumentCommissionRateVO queryInstrumentCommission(String instrumentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InstrumentCommissionRateVO queryInvestorCommission(String investorNo, String instrumentID) {
        // TODO Auto-generated method stub
        return null;
    }

}
