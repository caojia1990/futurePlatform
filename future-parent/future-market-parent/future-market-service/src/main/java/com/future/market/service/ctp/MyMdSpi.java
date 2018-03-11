package com.future.market.service.ctp;

import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcDepthMarketDataField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcSpecificInstrumentField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcUserLogoutField;
import org.hraink.futures.jctp.md.JCTPMdApi;
import org.hraink.futures.jctp.md.JCTPMdSpi;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.future.instrument.api.service.InstrumentService;
import com.future.market.api.vo.DepthMarketData;
import com.future.market.service.MarketMain;

public class MyMdSpi extends JCTPMdSpi {
	private JCTPMdApi mdApi;
	private RabbitTemplate template;
	private InstrumentService instrumentService;
    
	public MyMdSpi(JCTPMdApi mdApi) {
		this.mdApi = mdApi;
	}
	
	public MyMdSpi(JCTPMdApi mdApi,RabbitTemplate template,InstrumentService instrumentService) {
	    this.mdApi = mdApi;
	    this.template = template;
	    this.instrumentService = instrumentService;
	    
	}
	
	@Override
	public void onFrontConnected() {
		System.out.println("准备登陆");
		//登陆
		CThostFtdcReqUserLoginField userLoginField = new CThostFtdcReqUserLoginField();
		userLoginField.setBrokerID(MarketMain.BROKER_ID);
		userLoginField.setUserID(MarketMain.USER_ID);
		userLoginField.setPassword(MarketMain.PASSWORD);
		
		mdApi.reqUserLogin(userLoginField, 112);
		System.out.println("登陆完成");
	}
	
	@Override
	public void onRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		System.out.println("登录回调");
		System.out.println(pRspUserLogin.getLoginTime());
		//订阅
		int subResult = -1;
		
		String[] instruments = instrumentService.queryInstrumentName().toArray(new String[0]);
		
		
		subResult = mdApi.subscribeMarketData(instruments);
		System.out.println(subResult == 0 ? "订阅成功" : "订阅失败");
	}

	@Override
	public void onRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		
		DepthMarketData marketData = new DepthMarketData();
		marketData.setAskPrice1(pDepthMarketData.getAskPrice1());
		marketData.setAskVolume1(pDepthMarketData.getAskVolume1());
		marketData.setAveragePrice(pDepthMarketData.getAveragePrice());
		marketData.setBidPrice1(pDepthMarketData.getBidPrice1());
		marketData.setBidVolume1(pDepthMarketData.getBidVolume1());
		marketData.setClosePrice(pDepthMarketData.getClosePrice());
		marketData.setHighestPrice(pDepthMarketData.getHighestPrice());
		marketData.setInstrumentID(pDepthMarketData.getInstrumentID());
		marketData.setLastPrice(pDepthMarketData.getLastPrice());
		marketData.setLowerLimitPrice(pDepthMarketData.getLowerLimitPrice());
		marketData.setLowestPrice(pDepthMarketData.getLowestPrice());
		marketData.setOpenPrice(pDepthMarketData.getOpenPrice());
		marketData.setOpenInterest(pDepthMarketData.getOpenInterest());
		marketData.setPreOpenInterest(pDepthMarketData.getPreOpenInterest());
		marketData.setPreClosePrice(pDepthMarketData.getPreClosePrice());
		marketData.setPreSettlementPrice(pDepthMarketData.getPreSettlementPrice());
		marketData.setSettlementPrice(pDepthMarketData.getSettlementPrice());
		marketData.setTradingDate(pDepthMarketData.getTradingDay());
		marketData.setUpperLimitPrice(pDepthMarketData.getUpperLimitPrice());
		marketData.setVolume(pDepthMarketData.getVolume());
		marketData.setUpdateTime(pDepthMarketData.getUpdateTime());
		marketData.setUpdateMillisec(pDepthMarketData.getUpdateMillisec());
		marketData.setExchangeID(pDepthMarketData.getExchangeID());
		marketData.setExchangeInstId(pDepthMarketData.getExchangeInstID());
		marketData.setTurnover(pDepthMarketData.getTurnover());
		marketData.setCurrDelta(pDepthMarketData.getCurrDelta());
		marketData.setPreDelta(pDepthMarketData.getPreDelta());
		this.template.convertAndSend("com.future.market", "instrument."+marketData.getInstrumentID(), marketData);
		
	}
//	
	@Override
	public void onRspSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		
		System.out.println("订阅回报:" + bIsLast +" : "+ pRspInfo.getErrorID()+":"+pRspInfo.getErrorMsg());
		//System.out.println("InstrumentID:" + pSpecificInstrument.getInstrumentID());
	}
	
	@Override
	public void onHeartBeatWarning(int nTimeLapse) {
	}
	
	@Override
	public void onFrontDisconnected(int nReason) {
	}
	
	@Override
	public void onRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
		System.out.println("异常ID："+pRspInfo.getErrorID()+" 异常信息:"+pRspInfo.getErrorMsg());
	}
	
	@Override
	public void onRspUnSubMarketData(
			CThostFtdcSpecificInstrumentField pSpecificInstrument,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	    System.out.println("取消订阅回报:" + bIsLast +" : "+ pRspInfo.getErrorID()+":"+pRspInfo.getErrorMsg());
        System.out.println("InstrumentID:" + pSpecificInstrument.getInstrumentID());
	}
	
	@Override
	public void onRspUserLogout(CThostFtdcUserLogoutField pUserLogout,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		// TODO Auto-generated method stub
	}


}