package com.future.risk.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.risk.consumer.InstrumentConsumer;

@RestController
public class InstrumentController {

	@Autowired
	private InstrumentConsumer instrumentConsumer;
	
	@RequestMapping(value="queryInstrument/{instrumentId}")
	public InstrumentVO queryInstrument(@PathVariable String instrumentId) throws InstrumentException {
		return this.instrumentConsumer.queryInstrument(instrumentId);
	}
	
	@RequestMapping(value="queryInstrumentName")
	public List<String> queryInstrumentName(){
		return this.instrumentConsumer.queryInstrumentName();
	}
}
