package com.future.trade.api.vo;

import java.io.Serializable;

/**
 * 下单参数
 * @author caojia
 *
 */
public class ReqOrderInsertVO implements Serializable{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -7390751012439707057L;

    
    /**
     * 请求编号
     */
    private String RequestID;
    
    /**
     * 经纪公司代码
     */
    private String brokerID;
    
    /**
     * 投资者代码
     */
    private String investorID;
    
    /**
     * 合约代码
     */
    private String instrumentID;
    
    /**
     * 报单引用
     */
    private String orderRef;
    
    /**
     * 用户代码
     */
    private String userID;
    
    /**
     * 报单价格条件
     */
    private OrderPriceType orderPriceType;
    
    /**
     * 买卖方向
     */
    private Direction direction;
    
    ///组合开平标志
    private CombOffsetFlag combOffsetFlag;
    ///组合投机套保标志
    private CombHedgeFlag combHedgeFlag;
    
    /**
     * 价格
     */
    private double limitPrice;
    
    /**
     * 数量
     */
    private int volumeTotalOriginal;
    
    /**
     * 有效期类型
     */
    private TimeCondition timeCondition;
    
    /**
     * GTD 日期
     */
    private String gTDDate;
    
    /**
     * 成交量类型
     */
    TThostFtdcVolumeConditionType VolumeCondition;
    
    /**
     * 最小成交量
     */
    private int minVolume;
    
    ///触发条件
    TThostFtdcContingentConditionType ContingentCondition;
    
    ///止损价
    TThostFtdcPriceType StopPrice;
    
    ///强平原因
    TThostFtdcForceCloseReasonType ForceCloseReason;
    
    ///自动挂起标志
    TThostFtdcBoolType IsAutoSuspend;
    
    ///业务单元
    TThostFtdcBusinessUnitType BusinessUnit;
    

}
