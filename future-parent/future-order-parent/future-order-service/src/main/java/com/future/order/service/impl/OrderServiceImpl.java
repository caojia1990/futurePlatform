package com.future.order.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.future.account.api.service.AccountService;
import com.future.common.exception.CommonFutureException;
import com.future.instrument.api.service.CommissionService;
import com.future.instrument.api.service.MarginService;
import com.future.instrument.api.vo.InvestorTradeParamVO;
import com.future.order.api.service.OrderService;
import com.future.order.api.vo.ReqOrderActionVO;
import com.future.order.service.dao.OrderInputDao;
import com.future.order.service.entity.OrderInput;
import com.future.trade.api.exception.TradeException;
import com.future.trade.api.service.TradeService;
import com.future.trade.api.vo.CombHedgeFlag;
import com.future.trade.api.vo.CombOffsetFlag;
import com.future.trade.api.vo.ContingentCondition;
import com.future.trade.api.vo.Direction;
import com.future.trade.api.vo.ForceCloseReason;
import com.future.trade.api.vo.OrderPriceType;
import com.future.trade.api.vo.ReqOrderInsertVO;
import com.future.trade.api.vo.TimeCondition;
import com.future.trade.api.vo.VolumeCondition;

/**
 * 报单接口实现类
 * @author caojia
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    
    static Logger logger = Logger.getLogger(OrderServiceImpl.class);
    
    final static String ORDERREF_SEQUENCE_KEY = "orderRef-sequence-key";
    
    final static String ORDERREF_KEY = "orderRef";
    
    @Autowired
    private CommissionService commissionService;
    
    @Autowired
    private MarginService marginService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private TradeService tradeService;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private OrderInputDao orderInputDao;

    @Override
    public void openOrder() {
        // TODO Auto-generated method stub

    }

    @Override
    public void cancelOrder(String investorNo, String acountNo, String orderRef) {
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
    public void reqOrderInsert(com.future.order.api.vo.ReqOrderInsertVO reqOrderInsertVO) throws CommonFutureException{

        
        //调用合约中心查询每手应冻结手续费
        InvestorTradeParamVO paramVO = new InvestorTradeParamVO();
        paramVO.setDirection(String.valueOf(reqOrderInsertVO.getDirection().getCode()));
        paramVO.setInstrumentID(reqOrderInsertVO.getInstrumentID());
        paramVO.setInvestorNo(reqOrderInsertVO.getInvestorID());
        paramVO.setLimitPrice(new BigDecimal(reqOrderInsertVO.getLimitPrice()));
        paramVO.setOffset(reqOrderInsertVO.getCombOffsetFlag().getText());
        paramVO.setPriceType(String.valueOf(reqOrderInsertVO.getOrderPriceType()));
        
        BigDecimal commissionEachHand = this.commissionService.calculateCommission(paramVO);
        BigDecimal commission = BigDecimal.ZERO;
        if(reqOrderInsertVO.getCombOffsetFlag() != com.future.order.api.vo.CombOffsetFlag.OPEN){
            //平仓不需要冻结保证金
            commission = commissionEachHand.multiply(new BigDecimal(reqOrderInsertVO.getVolumeTotalOriginal()));
            //TODO  按照先开先平原则对应冻结持仓
            
            
        }
        
        //调用合约中心计算每手应冻结保证金
        BigDecimal marginEachHand = this.marginService.calculateMargin(paramVO);
        BigDecimal margin = marginEachHand.multiply(new BigDecimal(reqOrderInsertVO.getVolumeTotalOriginal()));
        
        //生成委托编号
        Long orderRef = stringRedisTemplate.opsForValue().increment(ORDERREF_SEQUENCE_KEY, 1);
        OrderInput r = new OrderInput();
        r.setAccountNo(reqOrderInsertVO.getAccountNo());
        r.setOrderRef(String.valueOf(orderRef));
        r.setInvestorID(reqOrderInsertVO.getInvestorID());
        r.setFrozenCommission(commission);
        r.setFrozenMargin(margin);
        r.setCommissionEachHand(commissionEachHand);
        r.setMarginEachHand(marginEachHand);
        orderInputDao.insert(r);
        
        //缓存orderRef与账户关系
        stringRedisTemplate.opsForHash().put(ORDERREF_KEY, String.valueOf(orderRef), reqOrderInsertVO.getAccountNo());
        
        //调用账户中心冻结资金
        accountService.frozenCapital(reqOrderInsertVO.getInvestorID(), reqOrderInsertVO.getAccountNo(), commission, margin);
        //调用交易中心下单
        ReqOrderInsertVO orderInsertVO = new ReqOrderInsertVO();
        orderInsertVO.setOrderRef(String.valueOf(orderRef));//报单引用
        orderInsertVO.setLimitPrice(reqOrderInsertVO.getLimitPrice());//指定价格
        orderInsertVO.setInstrumentID(reqOrderInsertVO.getInstrumentID());//合约
        orderInsertVO.setVolumeTotalOriginal(reqOrderInsertVO.getVolumeTotalOriginal());//手数
        orderInsertVO.setDirection(Direction.ofCode(
                reqOrderInsertVO.getDirection().getCode()));//买卖方向
        orderInsertVO.setOrderPriceType(OrderPriceType.ofCode(
                reqOrderInsertVO.getOrderPriceType().getCode()));//报单价格类型
        orderInsertVO.setCombOffsetFlag(CombOffsetFlag.ofCode(
                reqOrderInsertVO.getCombOffsetFlag().getCode()));//组合开平标志
        orderInsertVO.setCombHedgeFlag(CombHedgeFlag.ofCode(
                reqOrderInsertVO.getCombHedgeFlag().getCode()));//投保标志
        orderInsertVO.setTimeCondition(TimeCondition.ofCode(
                reqOrderInsertVO.getTimeCondition().getCode()));//有效期类型
        orderInsertVO.setVolumeCondition(VolumeCondition.ofCode(
                reqOrderInsertVO.getVolumeCondition().getCode()));//成交量类型
        orderInsertVO.setContingentCondition(ContingentCondition.ofCode(
                reqOrderInsertVO.getContingentCondition().getCode()));//触发条件
        orderInsertVO.setForceCloseReason(ForceCloseReason.ofCode(
                reqOrderInsertVO.getForceCloseReason().getCode()));//强平原因
        orderInsertVO.setMinVolume(reqOrderInsertVO.getMinVolume());
        orderInsertVO.setRequestID(reqOrderInsertVO.getRequestID());//请求ID
        
        try {
			tradeService.reqOrderInsert(orderInsertVO);
		} catch (TradeException e) {
			//下单失败先解冻手续费和保证金
			accountService.thawCapital(reqOrderInsertVO.getInvestorID(), reqOrderInsertVO.getAccountNo(), commission, margin);
			throw e;
		}
    }

    @Override
    public void reqOrderAction(ReqOrderActionVO reqOrderActionVO) throws CommonFutureException {
        // TODO Auto-generated method stub
        
    }

}
