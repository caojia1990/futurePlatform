package com.future.risk.consumer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        
        String p1 = new BCryptPasswordEncoder().encode("caojia");
        System.out.println(p1);
        String p2 = new BCryptPasswordEncoder().encode("caojia");
        System.out.println(p2);
        System.out.println(new BCryptPasswordEncoder().matches("caojia", p1));
        System.out.println(new BCryptPasswordEncoder().matches("caojia", p2));
    }
}
