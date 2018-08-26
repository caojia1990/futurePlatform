package com.future.risk.vo;

public class ResponseBody<T> extends ResponseHead {

    private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}
