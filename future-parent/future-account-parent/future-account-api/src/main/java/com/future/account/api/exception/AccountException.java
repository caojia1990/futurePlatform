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
	}
	
	public AccountException(String errorCode, String errorMsg, Throwable cause) {
		super(SERVICE_NAME, errorCode, errorMsg, cause);
	}
	
	public AccountException(AccountErrorMsg accountErrorMsg) {
	    super(SERVICE_NAME, accountErrorMsg.code, accountErrorMsg.msg);
	}
	
	public AccountException(AccountErrorMsg accountErrorMsg, Throwable cause) {
	    super(SERVICE_NAME, accountErrorMsg.code, accountErrorMsg.msg, cause);
	}

	
}
