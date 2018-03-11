package com.future.instrument.api.exception;

import com.future.common.exception.CommonFutureException;

/**
 * 合约中心异常类
 * @author caojia
 *
 */
public class InstrumentException extends CommonFutureException{

    /**
     * 
     */
    private static final long serialVersionUID = 251268835467538378L;

    public InstrumentException(String serviceName, String errorCode, String errorMsg) {
        super(serviceName, errorCode, errorMsg);
        // TODO Auto-generated constructor stub
    }

}
