package com.future.common.exception;

/**
 * 公共异常类
 * @author caojia
 *
 */
public class CommonFutureException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8236937460782468914L;
	
	/**
	 * 系统名
	 */
	String serviceName;
	
	/**
	 * 错误码
	 */
	String errorCode;
	
	/**
	 * 错误信息
	 */
	String errorMsg;
	
	public CommonFutureException(){
	    super();
	}
	
	public CommonFutureException(String serviceName, String errorCode, String errorMsg) {
		super(errorMsg);
		this.serviceName = serviceName;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	public CommonFutureException(String serviceName, String errorCode, String errorMsg, Throwable cause){
        super(errorMsg, cause);
        this.serviceName = serviceName;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

	public String getServiceName() {
		return serviceName;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
	

}
