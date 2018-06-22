package com.future.order.api.vo;

import java.io.Serializable;

public class OnRspInfo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -6996302957750693784L;

    private int errorId;
    
    private String errorMsg;
    
    private int nRequestID;

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getnRequestID() {
        return nRequestID;
    }

    public void setnRequestID(int nRequestID) {
        this.nRequestID = nRequestID;
    }
    
    
}
