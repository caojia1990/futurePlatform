package com.future.risk.consumer;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.future.common.exception.CommonFutureException;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.ReqOrderInsertVO;

@Component
public class OrderConsumer {
	
	@Reference
	private OrderService orderService;

	public void reqOrderInsert(ReqOrderInsertVO reqOrderInsertVO) throws CommonFutureException {
		this.orderService.reqOrderInsert(reqOrderInsertVO);
	}
}
