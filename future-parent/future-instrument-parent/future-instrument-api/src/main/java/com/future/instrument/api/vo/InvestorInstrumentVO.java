package com.future.instrument.api.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 投资者合约信息
 * @author caojia
 *
 */
public class InvestorInstrumentVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 8005840524157199302L;

    //投资者代码
    private String investorNo;
    
    //合约代码
    private String instrumentId;
    
    //开仓手数
    private Integer volume;
    
    //止盈跳数
    private Integer stopWin;
    
    //止损跳数
    private Integer stopLoss;
    
    //运行状态 0：正常（默认）   1：暂停
    private String status = "0";
    
    //止盈幅度
    private BigDecimal target;
    
    //跟踪止盈回撤幅度
    private BigDecimal retracement;

    //对冲触发类型  0:按比例触发（默认） 1：立即触发   2：不触发
    private String hedgingType = "0";
    
    //触发对冲比例    默认2%
    private BigDecimal hedgingTigger = new BigDecimal("0.02");
    
    //对冲手数  默认1
    private Integer hedgingVolume = 1;
    
    //对冲止盈跳数
    private Integer hedgingStopWin;
    
    //对冲止损跳数
    private Integer hedgingStopLoss;
    
    private String hedgingVOs;
    
    private List<StaircaseHedgingVO> hedgingList;
    
    public String getHedgingVOs() {
        return hedgingVOs;
    }

    public void setHedgingVOs(String hedgingVOs) {
        this.hedgingVOs = hedgingVOs;
    }
    
    public List<StaircaseHedgingVO> getHedgingList() {
        return hedgingList;
    }

    public void setHedgingList(List<StaircaseHedgingVO> hedgingList) {
        this.hedgingList = hedgingList;
    }

    public String getInvestorNo() {
        return investorNo;
    }

    public void setInvestorNo(String investorNo) {
        this.investorNo = investorNo;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    public Integer getStopWin() {
        return stopWin;
    }

    public void setStopWin(Integer stopWin) {
        this.stopWin = stopWin;
    }

    public Integer getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(Integer stopLoss) {
        this.stopLoss = stopLoss;
    }

    /**
     * 运行状态 
     * @return 0：正常（默认）   1：暂停
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 止盈幅度
     * @return 到达该比例触发回撤止盈
     */
    public BigDecimal getTarget() {
        return target;
    }

    public void setTarget(BigDecimal target) {
        this.target = target;
    }

    public BigDecimal getRetracement() {
        return retracement;
    }

    public void setRetracement(BigDecimal retracement) {
        this.retracement = retracement;
    }

    /**
     * 对冲触发类型  
     * @return 0:按比例触发（默认） 1：立即触发   2：不触发 3:阶梯对冲
     */
    public String getHedgingType() {
        return hedgingType;
    }

    public void setHedgingType(String hedgingType) {
        this.hedgingType = hedgingType;
    }

    public BigDecimal getHedgingTigger() {
        return hedgingTigger;
    }

    public void setHedgingTigger(BigDecimal hedgingTigger) {
        this.hedgingTigger = hedgingTigger;
    }

    public Integer getHedgingStopWin() {
        return hedgingStopWin;
    }

    public void setHedgingStopWin(Integer hedgingStopWin) {
        this.hedgingStopWin = hedgingStopWin;
    }

    public Integer getHedgingStopLoss() {
        return hedgingStopLoss;
    }

    public void setHedgingStopLoss(Integer hedgingStopLoss) {
        this.hedgingStopLoss = hedgingStopLoss;
    }

    public Integer getHedgingVolume() {
        return hedgingVolume;
    }

    public void setHedgingVolume(Integer hedgingVolume) {
        this.hedgingVolume = hedgingVolume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    
}
