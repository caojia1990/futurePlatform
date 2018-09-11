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
    
    static final String SERVICE_NAME = "instrument-service";

    public InstrumentException(){
        super();
    }
    
    public InstrumentException(String errorCode, String errorMsg){
        super(SERVICE_NAME, errorCode, errorMsg);
    }
    
    public InstrumentException(String errorCode, String errorMsg, Throwable cause){
        super(SERVICE_NAME, errorCode, errorMsg, cause);
    }
    
    public InstrumentException(InstrumentError error){
        super(SERVICE_NAME, error.errorCode, error.errorMsg);
    }
    
    public InstrumentException(InstrumentError error, Throwable cause){
        super(SERVICE_NAME, error.errorCode, error.errorMsg, cause);
    }

}
