package com.future.order.service.impl.inner;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.order.api.vo.InvestorPositionDetailVO;
import com.future.order.api.vo.OnRtnTradeVO;
import com.future.order.service.dao.InvestorPositionDetailDao;

@Service("positionInnerService")
public class PositionInnerServiceImpl implements PositionInnerService {
	
	@Autowired
	private InvestorPositionDetailDao investorPositionDetailDao;

	@Override
	public void increasePosition(OnRtnTradeVO onRtnTradeVO) {
		
		//保存持仓明细
		InvestorPositionDetailVO detailVO = new InvestorPositionDetailVO();
        detailVO.setAccountNo(onRtnTradeVO.getAccountNo());
        detailVO.setCombInstrumentID(onRtnTradeVO.getInstrumentID());
        detailVO.setDirection(onRtnTradeVO.getDirection());
        detailVO.setHedgeFlag(onRtnTradeVO.getHedgeFlag());
        detailVO.setInstrumentID(onRtnTradeVO.getInstrumentID());
        detailVO.setInvestorID(onRtnTradeVO.getInvestorID());
        detailVO.setOpenDate(onRtnTradeVO.getTradeDate());
        detailVO.setOpenPrice(new BigDecimal(onRtnTradeVO.getPrice()));
        detailVO.setTradeID(onRtnTradeVO.getTradeID());
        detailVO.setTradeType(onRtnTradeVO.getTradeType());
        detailVO.setTradingDay(onRtnTradeVO.getTradingDay());
        detailVO.setVolume(onRtnTradeVO.getVolume());
        investorPositionDetailDao.insert(detailVO);
        //TODO 更新持仓信息
	}

	@Override
	public void reducePosition(OnRtnTradeVO onRtnTradeVO) {
		// TODO Auto-generated method stub
		switch (onRtnTradeVO.getOffsetFlag()) {
		case CLOSE:
			
			break;
		case CloseToday:
			break;
		case CloseYesterday:
			break;
		default:
			break;
		}

	}

	@Override
	public void frozenPosition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void releasePosition() {
		// TODO Auto-generated method stub

	}

}
