package com.future.trade.api.vo;

/**
 * 成交量类型
 * @author caojia
 *
 */
public enum VolumeCondition {

	/**
	 * 任何数量
	 */
	AV('1', "任何数量"),
	
	/**
	 * 最小数量
	 */
	MV('2', "全部数量"),
	
	/**
	 * 全部数量
	 */
	CV('3', "全部数量");
	
	final char code;
	
	final String text;
	
	private VolumeCondition(char code, String text) {
		this.code = code;
		this.text = text;
	}

	public char getCode() {
		return code;
	}

	public String getText() {
		return text;
	}
	
	
}
