package com.future.client;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse("20:50:06", formatter);
        
        if((time.isAfter(LocalTime.parse("21:00:05")) && time.isBefore(LocalTime.parse("23:59:59"))) || 
                (time.isAfter(LocalTime.parse("09:00:05")) && time.isBefore(LocalTime.parse("14:59:59")))){
            
            System.out.println(time.isAfter(LocalTime.parse("21:00:05")));
            System.out.println(time.isBefore(LocalTime.parse("23:59:59")));
            System.out.println(time.isAfter(LocalTime.parse("09:00:05")));
            System.out.println(time.isBefore(LocalTime.parse("14:59:59")));
        }
    }
}
