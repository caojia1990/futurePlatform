package com.future.order.service;

import com.future.order.api.vo.Direction;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(com.future.trade.api.vo.Direction.ofCode(Direction.SELL.getCode()));
    }
}
