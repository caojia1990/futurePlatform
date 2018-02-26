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
	
	
}
