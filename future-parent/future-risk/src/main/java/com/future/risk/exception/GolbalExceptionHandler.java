package com.future.risk.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.future.common.exception.CommonFutureException;
import com.future.risk.vo.ResponseHead;

/**
 * 全局异常处理类
 * @author caojia
 *
 */
@ControllerAdvice
public class GolbalExceptionHandler {
    
    @ExceptionHandler(value = CommonFutureException.class)
    @ResponseBody
    public ResponseHead jsonErrorHandler(HttpServletRequest req, CommonFutureException e) {
        ResponseHead header = new ResponseHead();
        header.setRspCode(e.getErrorCode());
        header.setErrorMsg(e.getServiceName()+":"+e.getErrorMsg());
        return header;
    }

}
