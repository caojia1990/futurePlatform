package com.future.order.service.inner;

import com.future.common.exception.CommonFutureException;
import com.future.order.api.vo.OnRtnTradeVO;

/**
 * 持仓接口
 * @author caojia
 *
 */
public interface PositionInnerService {
	
	public void increasePosition(OnRtnTradeVO onRtnTradeVO) throws CommonFutureException;
	
	public void reducePosition(OnRtnTradeVO onRtnTradeVO);
	
	public void frozenPosition();
	
	public void releasePosition();

}
