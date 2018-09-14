package com.future.risk.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.future.member.api.service.MemberService;

@Component
public class UserService implements UserDetailsService {
    
    @Reference(check = false)
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        return new User("caojia", new BCryptPasswordEncoder().encode("caojia"), authorities);
    }

}
