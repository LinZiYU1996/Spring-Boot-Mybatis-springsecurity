package com.example.demo.service;

import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linziyu on 2019/2/9.
 *
 *
 */

@Component("MyUserDetailService")
@Slf4j
public class MyUserDetailService implements UserDetailsService{



    @Autowired
    private UserService userService;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "admin";
            }
        });
//        log.info("{}","传进来的名字"+s);
//        log.info("{}","验证。。。。。");
        User user = userService.findByUserName(s);//数据库查询操作
        if (user == null){
            throw new UsernameNotFoundException("");
        }
        return user;

    }
}
