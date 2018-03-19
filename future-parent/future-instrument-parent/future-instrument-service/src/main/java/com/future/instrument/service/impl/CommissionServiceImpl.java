package com.future.instrument.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.service.CommissionService;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentCommissionRateVO;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.instrument.api.vo.InvestorTradeParamVO;

@Service("commissionService")
public class CommissionServiceImpl implements CommissionService {
    
    @Autowired
    private InstrumentService instrumentService;

    @Override
    public InstrumentCommissionRateVO queryInstrumentCommission(String instrumentID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InstrumentCommissionRateVO queryInvestorCommission(String investorNo, String instrumentID)
            throws InstrumentException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BigDecimal calculateCommission(InvestorTradeParamVO paramVO) throws InstrumentException {

        InstrumentCommissionRateVO commissionRateVO = this.queryInstrumentCommission(paramVO.getInstrumentID());
        
        BigDecimal byVolume = BigDecimal.ZERO;
        BigDecimal byMoney = BigDecimal.ZERO;
        if("0".equals(paramVO.getOffset())){
            //开仓
            if(commissionRateVO.getOpenRatioByVolume() != 0){
                //按手数  每手手续费=每手手续费
                byVolume =new BigDecimal(commissionRateVO.getOpenRatioByVolume())
                        .setScale(2, RoundingMode.HALF_UP);
            }
            if(commissionRateVO.getOpenRatioByMoney() != 0){
                InstrumentVO instrumentVO = this.instrumentService.queryInstrument(paramVO.getInstrumentID());
                //按金额    每手手续费=合约乘数*指定价格*手续费比例
                byMoney = new BigDecimal(instrumentVO.getVolumeMultiple())
                        .multiply(paramVO.getLimitPrice())
                        .multiply(new BigDecimal(commissionRateVO.getOpenRatioByMoney()))
                        .setScale(2, RoundingMode.HALF_UP);
            }
            return byVolume.add(byMoney);
        }else if("1".equals(paramVO.getOffset())){
            //平仓
            if(commissionRateVO.getCloseRatioByVolume() != 0){
                //按手数  每手手续费=每手手续费
                byVolume = new BigDecimal(commissionRateVO.getCloseRatioByVolume())
                        .setScale(2, RoundingMode.HALF_UP);
            }
            if(commissionRateVO.getCloseRatioByMoney() != 0){
                InstrumentVO instrumentVO = this.instrumentService.queryInstrument(paramVO.getInstrumentID());
                //按金额    手续费=合约乘数*指定价格*手续费比例
                byMoney = new BigDecimal(instrumentVO.getVolumeMultiple())
                        .multiply(paramVO.getLimitPrice())
                        .multiply(new BigDecimal(commissionRateVO.getCloseRatioByMoney()))
                        .setScale(2, RoundingMode.HALF_UP);
            }
            return byVolume.add(byMoney);
        }else if ("3".equals(paramVO.getOffset())) {
            //平今
            if(commissionRateVO.getCloseTodayRatioByVolume() != 0){
                //按手数  每手手续费=交易手数*每手手续费
                byVolume = new BigDecimal(commissionRateVO.getCloseTodayRatioByVolume())
                        .setScale(2, RoundingMode.HALF_UP);
            }
            if(commissionRateVO.getCloseTodayRatioByMoney() != 0){
                InstrumentVO instrumentVO = this.instrumentService.queryInstrument(paramVO.getInstrumentID());
                //按金额    每手手续费=合约乘数*指定价格*手续费比例
                byMoney = new BigDecimal(instrumentVO.getVolumeMultiple())
                        .multiply(paramVO.getLimitPrice())
                        .multiply(new BigDecimal(commissionRateVO.getCloseTodayRatioByMoney()))
                        .setScale(2, RoundingMode.HALF_UP);
            }
            return byVolume.add(byMoney);
        }
        
        return null;
    }

}
