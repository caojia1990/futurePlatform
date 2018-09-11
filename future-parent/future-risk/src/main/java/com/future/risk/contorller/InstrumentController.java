package com.future.risk.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.future.instrument.api.exception.InstrumentException;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.instrument.api.vo.InvestorInstrumentVO;
import com.future.risk.consumer.InstrumentConsumer;
import com.future.risk.consumer.InvestorInstrumentConsumer;
import com.future.risk.vo.ResponseBody;
import com.future.risk.vo.ResponseHead;

@RestController
public class InstrumentController {

	@Autowired
	private InstrumentConsumer instrumentConsumer;
	
	@Autowired
	private InvestorInstrumentConsumer investorInstrumentConsumer;
	
	@RequestMapping(value="queryInstrument/{instrumentId}")
	public InstrumentVO queryInstrument(@PathVariable String instrumentId) throws InstrumentException {
		return this.instrumentConsumer.queryInstrument(instrumentId);
	}
	
	@RequestMapping(value="queryInstrumentName")
	public List<String> queryInstrumentName(){
		return this.instrumentConsumer.queryInstrumentName();
	}
	
	@RequestMapping(value="queryInvestorInstrument/{investorNo}")
	public ResponseBody<List<InvestorInstrumentVO>> queryInvestorInstrument(@PathVariable String investorNo) throws InstrumentException{
	    
	    ResponseBody<List<InvestorInstrumentVO>> responseBody = new ResponseBody<List<InvestorInstrumentVO>>();
	    responseBody.setData(this.investorInstrumentConsumer.queryInstruments(investorNo));
	    return responseBody;
	}
	
	@RequestMapping(value="removeInvestorInstrument", method=RequestMethod.POST)
	public ResponseHead removeInvestorInstrument(@RequestBody InvestorInstrumentVO paramVo) throws InstrumentException{
	    this.investorInstrumentConsumer.removeInvestorInstrument(paramVo.getInvestorNo(), paramVo.getInstrumentId());
	    return new ResponseHead();
	}
	
	@RequestMapping(value="saveInvestorInstrument", method=RequestMethod.POST)
	public ResponseHead saveInvestorInstrument(@RequestBody InvestorInstrumentVO paramVo) throws InstrumentException{
	    this.investorInstrumentConsumer.saveInvestorInstrument(paramVo);
	    return new ResponseHead();
	}
	
	@RequestMapping(value="updateInvestorInstrument", method=RequestMethod.POST)
	public ResponseHead updateInvestorInstrument(@RequestBody InvestorInstrumentVO paramVo) throws InstrumentException{
        this.investorInstrumentConsumer.updateInvestorInstrument(paramVo);
        return new ResponseHead();
    }
}
