package com.future.risk.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.future.common.exception.CommonFutureException;
import com.future.order.api.vo.ReqOrderInsertVO;
import com.future.risk.consumer.OrderConsumer;
import com.future.risk.vo.ResponseHead;

@RestController
public class OrderController {

	@Autowired
	private OrderConsumer orderConsumer;
	
	@RequestMapping(value="reqOrderInsert", method=RequestMethod.POST)
	public ResponseHead reqOrderInsert(@RequestBody ReqOrderInsertVO reqOrderInsertVO) throws CommonFutureException {
		this.orderConsumer.reqOrderInsert(reqOrderInsertVO);
		return new ResponseHead();
	}
}
