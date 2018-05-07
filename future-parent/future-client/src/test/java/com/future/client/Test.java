package com.future.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParseException {
        
        if("09:04:59".compareTo("09:00:00") > -1 && "08:59:00".compareTo("09:04:59") < 1){
            System.out.println("在区间内");
        }else {
            System.out.println("不在区间内");
        }
        
        System.out.println("rb1810".replaceAll("[^a-z^A-Z]", ""));
        
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse("14:59:00", formatter);
            System.out.println(time);
        }
        
        double d = 1.9;
        System.out.println(Double.valueOf(d).intValue());
        
        
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
