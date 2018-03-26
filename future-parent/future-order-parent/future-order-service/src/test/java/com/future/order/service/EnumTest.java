package com.future.order.service;

import com.future.instrument.api.vo.ExchangeName;
import com.future.order.api.vo.Direction;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(com.future.trade.api.vo.Direction.ofCode(Direction.SELL.getCode()));
        
        System.out.println(ExchangeName.SHFE.getExchangeCode().equals("SHFE"));
    }
}
