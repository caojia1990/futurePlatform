package com.future.account.api.exception;

import com.future.common.exception.CommonFutureException;

/**
 * 账户中心异常类
 * @author caojia
 *
 */
public class AccountException extends CommonFutureException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -142873702585930617L;
	
	final static String SERVICE_NAME = "accountService";

	public AccountException(String errorCode, String errorMsg) {
		super(SERVICE_NAME, errorCode, errorMsg);
		// TODO Auto-generated constructor stub
	}

	
}
