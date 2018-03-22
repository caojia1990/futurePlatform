package com.future.order.service.impl.inner;

import com.future.order.api.vo.OnRtnTradeVO;

/**
 * 持仓接口
 * @author caojia
 *
 */
public interface PositionInnerService {
	
	public void increasePosition(OnRtnTradeVO onRtnTradeVO);
	
	public void reducePosition(OnRtnTradeVO onRtnTradeVO);
	
	public void frozenPosition();
	
	public void releasePosition();

}
