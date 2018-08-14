package com.future.quota.service.common;

import java.util.LinkedList;

public class LinkedListTest {
    
    public static void main(String[] args) {
        
        
        LinkedList<Double> l = new LinkedList<>();
        
        l.push(1.0);
        l.push(2.0);
        l.push(3.0);
        l.push(4.0);
        System.out.println(l);
        
        l.pollLast();;
        System.out.println(l);
    }

}
