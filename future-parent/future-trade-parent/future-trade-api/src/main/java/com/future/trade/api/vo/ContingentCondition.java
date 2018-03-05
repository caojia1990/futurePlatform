package com.future.trade.api.vo;

/**
 * 触发条件
 * @author caojia
 *
 */
public enum ContingentCondition {

	/**
	 * 立即
	 */
	Immediately('1', "立即"),
	
	/**
	 * 止损
	 */
	Touch('2', "止损"),
	
	/**
	 * 止赢
	 */
	TouchProfit('3', "止盈"),
	
	/**
	 * 预埋单
	 */
	ParkedOrder('4', "预埋单"),
	
	/**
	 * 最新价大于条件价
	 */
	LastPriceGreaterThanStopPrice('5', "最新价大于条件价"),
	
	/**
	 * 最新价大于等于条件价
	 */
	LastPriceGreaterEqualStopPrice('6', "最新价大于等于条件价"),
	
	/**
	 * 最新价小于条件价
	 */
	LastPriceLesserThanStopPrice('7', "最新价小于条件价"),
	
	/**
	 * 最新价小于等于条件价
	 */
	LastPriceLesserEqualStopPrice('8', "最新价小于等于条件价"),
	
	/**
	 * 卖一价大于条件价
	 */
	AskPriceGreaterThanStopPrice('9', "卖一价大于条件价"),
	
	/**
	 * 卖一价大于等于条件价
	 */
	AskPriceGreaterEqualStopPrice('A', "卖一价大于等于条件价"),
	
	/**
	 * 卖一价小于条件价
	 */
	AskPriceLesserThanStopPrice('B', "卖一价小于条件价"),
	
	/**
	 * 卖一价小于等于条件价
	 */
	AskPriceLesserEqualStopPrice('C', "卖一价小于等于条件价"),
	
	/**
	 * 买一价大于条件价
	 */
	BidPriceGreaterThanStopPrice('D', "买一价大于条件价"),
	
	/**
	 * 买一价大于等于条件价
	 */
	BidPriceGreaterEqualStopPrice('E', "买一价大于等于条件价"),
	
	/**
	 * 买一价小于条件价
	 */
	BidPriceLesserThanStopPrice('F', "买一价小于条件价"),
	
	/**
	 * 买一价小于等于条件价
	 */
	BidPriceLesserEqualStopPrice('H', "买一价小于等于条件价");
    
    final char code;
    
    final String text;
    
    private ContingentCondition(char code, String text){
        this.code = code;
        this.text = text;
    }

    public char getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
	
    public static ContingentCondition ofCode(char code){
        for(ContingentCondition contingentCondition : ContingentCondition.values()){
          if(code == contingentCondition.getCode()){
            return contingentCondition;
          }
        }
        return null;  
    }
}
