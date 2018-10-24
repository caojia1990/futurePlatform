package com.future.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.client.dao.TradeDao;
import com.future.order.api.vo.Direction;
import com.future.order.api.vo.OnRtnTradeVO;

/**
 * 平仓实现
 * @author caojia
 *
 */
@Service("closeService")
public class CloseService {

    @Autowired
    private TradeDao tradeDao;
    
    /**
     * 减仓
     * @param onRtnTrade
     */
    public void reducePosition(OnRtnTradeVO onRtnTrade){
        
        String direction = onRtnTrade.getDirection() == Direction.BUY ? "1":"0";
        //查询持仓
        List<OnRtnTradeVO> list = this.tradeDao.selectByCondition(onRtnTrade.getInvestorId(), onRtnTrade.getAccountNo(), onRtnTrade.getInstrumentId(), direction);
        if(list != null && list.size() > 0){
            
            int volume = onRtnTrade.getVolume();
            for (OnRtnTradeVO onRtnTradeVO : list) {
                if(onRtnTradeVO.getVolume() <= volume){
                    //删除该笔持仓明细
                    this.tradeDao.deleteByCondition(onRtnTradeVO.getTradingDay(), onRtnTradeVO.getTradeId(), onRtnTradeVO.getInstrumentId());
                    volume -= onRtnTradeVO.getVolume();
                }else {
                    //更新该笔持仓明细    剩余持仓为   onRtnTradeVO.getVolume-volume
                    this.tradeDao.updatePosition(onRtnTradeVO.getTradingDay(), onRtnTradeVO.getTradeId(), onRtnTradeVO.getInstrumentId(), volume);
                    volume = 0;
                }
                
                if(volume == 0){
                    return;
                }
            }
        }
        
    }
}
