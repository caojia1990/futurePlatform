package com.future.risk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;


/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class Console{
    
    public static void main(String[] args) {
        SpringApplication.run(Console.class,args);
    }
}
