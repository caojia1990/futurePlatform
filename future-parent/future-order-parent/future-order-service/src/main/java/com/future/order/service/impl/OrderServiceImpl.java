package com.future.order.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.order.api.service.OrderService;
import com.future.trade.api.vo.ReqOrderInsertVO;

/**
 * 报单接口实现类
 * @author caojia
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	static Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private InstrumentService instrumentService;

    @Override
    public void openOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void cancelOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void closeToday() {
        // TODO Auto-generated method stub

    }

    @Override
    public void queryOrder() {
        // TODO Auto-generated method stub

    }

	@Override
	public void reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) {

		String instrumentID = reqOrderInsertVO.getInstrumentID();
		InstrumentVO instrumentVO = this.instrumentService.queryInstrument(instrumentID);
		
		//调用合约中心查询手续费率和保证金比例
		
		//计算应冻结手续费
		//TODO
		
		//计算应冻结保证金
		//TODO
		
		//调用账户中心冻结资金
		
		
		//生成委托编号
		
		
		//调用交易中心下单
		
		
	}

}
