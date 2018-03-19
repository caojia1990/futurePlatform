package com.future.trade.service.ctp;


import org.apache.log4j.Logger;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderActionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInputOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentCommissionRateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInstrumentMarginRateField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInvestorPositionDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcInvestorPositionField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcOrderField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInstrumentField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcQryInvestorPositionDetailField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcReqUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspInfoField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcRspUserLoginField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcSettlementInfoConfirmField;
import org.hraink.futures.ctp.thostftdcuserapistruct.CThostFtdcTradeField;
import org.hraink.futures.jctp.trader.JCTPTraderApi;
import org.hraink.futures.jctp.trader.JCTPTraderSpi;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.alibaba.fastjson.JSON;
import com.future.instrument.api.service.InstrumentService;
import com.future.instrument.api.vo.InstrumentCommissionRateVO;
import com.future.instrument.api.vo.InstrumentVO;
import com.future.trade.api.vo.CombHedgeFlag;
import com.future.trade.api.vo.CombOffsetFlag;
import com.future.trade.api.vo.ContingentCondition;
import com.future.trade.api.vo.Direction;
import com.future.trade.api.vo.ForceCloseReason;
import com.future.trade.api.vo.HedgeFlag;
import com.future.trade.api.vo.OffsetFlag;
import com.future.trade.api.vo.OnRtnOrderVO;
import com.future.trade.api.vo.OnRtnTradeVO;
import com.future.trade.api.vo.OrderPriceType;
import com.future.trade.api.vo.OrderStatus;
import com.future.trade.api.vo.OrderSubmitStatus;
import com.future.trade.api.vo.TimeCondition;
import com.future.trade.api.vo.VolumeCondition;
import com.future.trade.service.TradeMain;

/**
 * Custom TraderSpi
 * 
 * @author Hraink E-mail:Hraink@Gmail.com
 * @version 2013-1-25 下午11:46:13
 */
public class MyTraderSpi extends JCTPTraderSpi {

    static Logger logger = Logger.getLogger(MyTraderSpi.class);
    
	JCTPTraderApi traderApi;
	int nRequestID = 0;
	
	final static String ONRTNORDER_KEY = "onRtnOrder";
	final static String ONRTNTRADE_KEY = "onRtnTrade";
	final static String ONRSPORDERINSERT_KEY = "onRspOrderInsert";
	final static String ONRSPORDERACTION_KEY = "onRspOrderAction";
	final static String ONRSPERROR_KEY = "onRspError";
	final static String ONERRRTNORDERINSERT_KEY = "onErrRtnOrderInsert";
	
	private InstrumentService instrumentService;
	
	private RabbitTemplate template;
	
	public MyTraderSpi(JCTPTraderApi traderApi, RabbitTemplate template,InstrumentService instrumentService) {
		this.traderApi = traderApi;
		this.template = template;
		this.instrumentService = instrumentService;
	}
	
	public MyTraderSpi(JCTPTraderApi traderApi, TradeMain main) {
	    this.traderApi = traderApi;
	}
	public void onFrontConnected() {
		System.out.println("前置机连接");
		CThostFtdcReqUserLoginField userLoginField = new CThostFtdcReqUserLoginField();
		
		userLoginField.setBrokerID(TradeMain.BROKER_ID);
		userLoginField.setUserID(TradeMain.USER_ID);
		userLoginField.setPassword(TradeMain.PASSWORD);
		
		traderApi.reqUserLogin(userLoginField, 112);
		
	}
	
	@Override
	public void onRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("TradingDay:" + traderApi.getTradingDay()+"请求编号："+nRequestID);
		System.out.println(pRspInfo.getErrorID());
		System.out.println(pRspUserLogin.getLoginTime());
		System.out.println(pRspUserLogin.getCZCETime());
		System.out.println(pRspUserLogin.getDCETime());
		System.out.println(pRspUserLogin.getFFEXTime());
		System.out.println(pRspUserLogin.getSHFETime());
		System.out.println(pRspUserLogin.getMaxOrderRef());
		
		//查询持仓明细
		CThostFtdcQryInvestorPositionDetailField positionField = new CThostFtdcQryInvestorPositionDetailField();
		positionField.setBrokerID(TradeMain.BROKER_ID);
		positionField.setInstrumentID("cu1703");
		positionField.setInvestorID(TradeMain.USER_ID);
		//traderApi.reqQryInvestorPositionDetail(positionField, ++nRequestID);
		
		
		//确认结算单
		CThostFtdcSettlementInfoConfirmField confirmField = new CThostFtdcSettlementInfoConfirmField();
		confirmField.setBrokerID(TradeMain.BROKER_ID);
		confirmField.setInvestorID(TradeMain.USER_ID);
		traderApi.reqSettlementInfoConfirm(confirmField, ++nRequestID);
		
		//查询合约信息
		CThostFtdcQryInstrumentField pQryInstrument = new CThostFtdcQryInstrumentField();
		traderApi.reqQryInstrument(pQryInstrument, ++nRequestID);
		
		
		//从redis中查询持仓信息
		/*CommonRedisDao commonRedisDao = (CommonRedisDao) SpringContextUtil.getBean("commonRedisDao");
		commonRedisDao.setValueByKey(TraderMain.BUY+"cu1803", "0");
		commonRedisDao.setValueByKey(TraderMain.SELL+"cu1803", "0");*/
	}
	
	//报单回报
	@Override
	public void onRtnOrder(CThostFtdcOrderField pOrder) {
		System.out.println(pOrder.getStatusMsg());
		
		OnRtnOrderVO onRtnOrderVO = new OnRtnOrderVO();
		onRtnOrderVO.setActiveTime(pOrder.getActiveTime());
		onRtnOrderVO.setActiveTraderID(pOrder.getActiveTraderID());
		onRtnOrderVO.setBusinessUnit(pOrder.getBusinessUnit());
		onRtnOrderVO.setCancelTime(pOrder.getCancelTime());
		onRtnOrderVO.setClearingPartID(pOrder.getClearingPartID());
		onRtnOrderVO.setClientID(pOrder.getClientID());
		onRtnOrderVO.setCombHedgeFlag(CombHedgeFlag.ofCode(pOrder.getCombHedgeFlag()));
		onRtnOrderVO.setCombOffsetFlag(CombOffsetFlag.ofCode(pOrder.getCombOffsetFlag()));
		onRtnOrderVO.setContingentCondition(ContingentCondition.ofCode(pOrder.getContingentCondition()));
		onRtnOrderVO.setDirection(Direction.ofCode(pOrder.getDirection()));
		onRtnOrderVO.setExchangeID(pOrder.getExchangeID());
		onRtnOrderVO.setExchangeInstID(pOrder.getExchangeInstID());
		onRtnOrderVO.setForceCloseReason(ForceCloseReason.ofCode(pOrder.getForceCloseReason()));
		onRtnOrderVO.setgTDDate(pOrder.getGTDDate());
		onRtnOrderVO.setInsertDate(pOrder.getInsertDate());
		onRtnOrderVO.setInsertTime(pOrder.getInsertTime());
		onRtnOrderVO.setInstallID(pOrder.getInstallID());
		onRtnOrderVO.setInstrumentID(pOrder.getInstrumentID());
		onRtnOrderVO.setInvestorID(pOrder.getInvestorID());//投资者编号 
		onRtnOrderVO.setIsAutoSuspend(pOrder.getIsAutoSuspend());
		onRtnOrderVO.setLimitPrice(pOrder.getLimitPrice());
		onRtnOrderVO.setMinVolume(pOrder.getMinVolume());
		onRtnOrderVO.setNotifySequence(pOrder.getNotifySequence());
		onRtnOrderVO.setOrderLocalID(pOrder.getOrderLocalID());
		onRtnOrderVO.setOrderPriceType(OrderPriceType.ofCode(pOrder.getOrderPriceType()));
		onRtnOrderVO.setOrderRef(pOrder.getOrderRef());
		onRtnOrderVO.setOrderSource(pOrder.getOrderSource());
		onRtnOrderVO.setOrderStatus(OrderStatus.ofCode(pOrder.getOrderStatus()));
		onRtnOrderVO.setOrderSubmitStatus(OrderSubmitStatus.ofCode(pOrder.getOrderSubmitStatus()));
		onRtnOrderVO.setOrderSysID(pOrder.getOrderSysID());
		onRtnOrderVO.setOrderType(pOrder.getOrderType());
		onRtnOrderVO.setParticipantID(pOrder.getParticipantID());
		onRtnOrderVO.setRequestID(pOrder.getRequestID());
		onRtnOrderVO.setSequenceNo(pOrder.getSequenceNo());
		onRtnOrderVO.setSessionID(pOrder.getSessionID());
		onRtnOrderVO.setSettlementID(pOrder.getSettlementID());
		onRtnOrderVO.setStatusMsg(pOrder.getStatusMsg());
		onRtnOrderVO.setStopPrice(pOrder.getStopPrice());
		onRtnOrderVO.setSuspendTime(pOrder.getSuspendTime());
		onRtnOrderVO.setTimeCondition(TimeCondition.ofCode(pOrder.getTimeCondition()));
		onRtnOrderVO.setTraderID(pOrder.getTraderID());
		onRtnOrderVO.setTradingDay(pOrder.getTradingDay());
		onRtnOrderVO.setUpdateTime(pOrder.getUpdateTime());
		onRtnOrderVO.setUserID(pOrder.getUserID());
		onRtnOrderVO.setUserProductInfo(pOrder.getUserProductInfo());
		onRtnOrderVO.setVolumeCondition(VolumeCondition.ofCode(pOrder.getVolumeCondition()));
		onRtnOrderVO.setVolumeTotal(pOrder.getVolumeTotal());
		onRtnOrderVO.setVolumeTotalOriginal(pOrder.getVolumeTotalOriginal());
		onRtnOrderVO.setVolumeTraded(pOrder.getVolumeTraded());
		
		this.template.convertAndSend("future.trade.direct", ONRTNORDER_KEY, onRtnOrderVO);
	}
	
	//报单响应
	@Override
	public void onRspOrderInsert(CThostFtdcInputOrderField pInputOrder,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		logger.error("报单失败："+JSON.toJSONString(pRspInfo)+JSON.toJSONString(pInputOrder));
		//traderMain.onRspOrderInsert(pInputOrder, pRspInfo, nRequestID, bIsLast);
	}
	
	//撤单
	@Override
	public void onRspOrderAction(
			CThostFtdcInputOrderActionField pInputOrderAction,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		logger.error(pRspInfo.getErrorMsg());
	}
	
	//成交回报
	@Override
	public void onRtnTrade(CThostFtdcTradeField pTrade) {
		//System.out.println("成交"+pTrade.getInstrumentID());
	    OnRtnTradeVO onRtnTradeVO = new OnRtnTradeVO();
	    //TODO 账户号  不需要返回
	    //onRtnTradeVO.setAccountNo("");
	    onRtnTradeVO.setInvestorID(pTrade.getInvestorID());
	    onRtnTradeVO.setDirection(Direction.ofCode(pTrade.getDirection()));
	    onRtnTradeVO.setExchangeID(pTrade.getExchangeID());
	    onRtnTradeVO.setExchangeInstID(pTrade.getExchangeInstID());
	    onRtnTradeVO.setHedgeFlag(HedgeFlag.ofCode(pTrade.getHedgeFlag()));
	    onRtnTradeVO.setInstrumentID(pTrade.getInstrumentID());
	    onRtnTradeVO.setOffsetFlag(OffsetFlag.ofCode(pTrade.getOffsetFlag()));
	    onRtnTradeVO.setOrderLocalID(pTrade.getOrderLocalID());
	    onRtnTradeVO.setOrderRef(pTrade.getOrderRef());
	    onRtnTradeVO.setOrderSysID(pTrade.getOrderSysID());
	    onRtnTradeVO.setPrice(pTrade.getPrice());
	    onRtnTradeVO.setSequenceNo(pTrade.getSequenceNo());
	    onRtnTradeVO.setTradeDate(pTrade.getTradeDate());
	    onRtnTradeVO.setTradeTime(pTrade.getTradeTime());
	    onRtnTradeVO.setTradeID(pTrade.getTradeID());//成交编号（重要）
	    onRtnTradeVO.setTradeType(pTrade.getTradeType());
	    onRtnTradeVO.setTradingDay(pTrade.getTradingDay());//交易日
	    onRtnTradeVO.setUserID(pTrade.getUserID());
	    onRtnTradeVO.setVolume(pTrade.getVolume());//成交量
	    
        this.template.convertAndSend("future.trade.direct", ONRTNTRADE_KEY, onRtnTradeVO);
	}
	
	@Override
	public void onRspQryInvestorPositionDetail(
			CThostFtdcInvestorPositionDetailField pInvestorPositionDetail,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("持仓明细查询回调");
	}
	
	
	@Override
	public void onRspQryInvestorPosition(
			CThostFtdcInvestorPositionField pInvestorPosition,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("持仓查询回调");
	}

   /**
     * 投资者结算结果确认响应
     * @param pSettlementInfoConfirm
     * @param pRspInfo
     * @param nRequestID
     * @param bIsLast
     */
	@Override
	public void onRspSettlementInfoConfirm(
			CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm,
			CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		logger.info("确认结算单："+JSON.toJSONString(pSettlementInfoConfirm));
	}
	
	@Override
	public void onRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID,
			boolean bIsLast) {
	    logger.error("错误回调");
	}
	@Override
	public void onErrRtnOrderInsert(CThostFtdcInputOrderField pInputOrder,
			CThostFtdcRspInfoField pRspInfo) {
	    logger.error("报单录入错误回调："+JSON.toJSONString(pRspInfo));
	}
	
	/**
     * 请求查询合约保证金率响应
     * @param pInstrumentMarginRate
     * @param pRspInfo
     * @param nRequestID
     * @param bIsLast
     */
	@Override
	public void onRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField pInstrumentMarginRate,
	        CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	    
	}
	
	/**
     * 请求查询合约响应
     * @param pInstrument
     * @param pRspInfo
     * @param nRequestID
     * @param bIsLast
     */
	@Override
    public void onRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	    
	    InstrumentVO info = new InstrumentVO();
	    info.setInstrumentID(pInstrument.getInstrumentID());
	    info.setInstrumentName(pInstrument.getInstrumentName());//合约名称
	    info.setVolumeMultiple(pInstrument.getVolumeMultiple());
	    info.setPriceTick(pInstrument.getPriceTick());
	    info.setExchangeID(pInstrument.getExchangeID());
	    info.setExchangeInstID(pInstrument.getExchangeInstID());
	    info.setProductID(pInstrument.getProductID());
	    info.setProductClass(pInstrument.getProductClass());//产品类型
	    info.setMaxMarketOrderVolume(pInstrument.getMaxMarketOrderVolume());
	    info.setMaxLimitOrderVolume(pInstrument.getMaxLimitOrderVolume());
	    info.setMinMarketOrderVolume(pInstrument.getMinMarketOrderVolume());
	    info.setMinLimitOrderVolume(pInstrument.getMinLimitOrderVolume());
	    info.setLongMarginRatio(pInstrument.getLongMarginRatio());
	    info.setShortMarginRatio(pInstrument.getShortMarginRatio());
	    info.setTradingDate(this.traderApi.getTradingDay());//交易日
	    info.setDeliveryMonth(pInstrument.getDeliveryMonth());//交割月
	    info.setDeliveryYear(pInstrument.getDeliveryYear());//交割年
	    info.setStartDelivDate(pInstrument.getStartDelivDate());//开始交割日
	    info.setEndDelivDate(pInstrument.getEndDelivDate());//结束交割日
	    info.setOpenDate(pInstrument.getOpenDate());//上市日
	    info.setExpireDate(pInstrument.getExpireDate());//到期日
	    info.setInstLifePhase(pInstrument.getInstLifePhase());//合约生命周期状态
	    info.setIsTrading(pInstrument.getIsTrading());//当前是否交易
	    info.setPositionDateType(pInstrument.getPositionDateType());//持仓日期类型
	    info.setPositionType(pInstrument.getPositionType());//持仓类型
	    this.instrumentService.saveInstrument(info);
	    
	    
	  /*//查询合约手续费
        CThostFtdcQryInstrumentCommissionRateField pQryInstrumentCommissionRate = new CThostFtdcQryInstrumentCommissionRateField();
        pQryInstrumentCommissionRate.setBrokerID(brokerId);
        pQryInstrumentCommissionRate.setInvestorID(userId);
        pQryInstrumentCommissionRate.setInstrumentID(pInstrument.getProductID());
        traderApi.reqQryInstrumentCommissionRate(pQryInstrumentCommissionRate, ++nRequestID);*/
	}
	
	   /**
     * 请求查询合约手续费率响应
     * @param pInstrumentCommissionRate
     * @param pRspInfo
     * @param nRequestID
     * @param bIsLast
     */
    public void onRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField pInstrumentCommissionRate, 
            CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
        
        InstrumentCommissionRateVO info = new InstrumentCommissionRateVO();
        info.setInvestorID(pInstrumentCommissionRate.getInvestorID());
        info.setInvestorRange(pInstrumentCommissionRate.getInvestorRange());
        info.setInstrumentID(pInstrumentCommissionRate.getInstrumentID());
        info.setOpenRatioByMoney(pInstrumentCommissionRate.getOpenRatioByMoney());
        info.setOpenRatioByVolume(pInstrumentCommissionRate.getOpenRatioByVolume());
        info.setCloseRatioByMoney(pInstrumentCommissionRate.getCloseRatioByMoney());
        info.setCloseRatioByVolume(pInstrumentCommissionRate.getCloseRatioByVolume());
        info.setCloseTodayRatioByMoney(pInstrumentCommissionRate.getCloseTodayRatioByMoney());
        info.setCloseTodayRatioByVolume(pInstrumentCommissionRate.getCloseTodayRatioByVolume());
        //instrumentInfoRedisDao.saveInstrumentCommision(info);
    }
	

}
