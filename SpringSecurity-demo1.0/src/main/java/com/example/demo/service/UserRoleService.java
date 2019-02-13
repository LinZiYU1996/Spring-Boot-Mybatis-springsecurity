package com.example.demo.service;

import com.example.demo.common.JsonData;
import com.example.demo.mapper.UserAndRoleMapper;
import com.example.demo.model.UserAndRole;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by linziyu on 2019/2/12.
 *
 * 处理用户角色
 */

@Service("UserRoleService")
public class UserRoleService {

    @Resource
    private UserAndRoleMapper userAndRoleMapper;

    public void  save(UserAndRole userAndRole){
            userAndRoleMapper.insert(userAndRole);
    }

    public void setUserAdmin(Integer userID){
        userAndRoleMapper.setUserAdmin(userID);
    }

    public JsonData setUser(Integer userID){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        List<String> the_roles = new ArrayList<String>();
//        for (GrantedAuthority authority : authorities) {
//            the_roles.add(authority.getAuthority());
//        }
//        if (the_roles.contains("ROLE_ADMIN")){
//            userAndRoleMapper.setUser(userID);
//            return new JsonData(200,"OK");
//        } else {
//            return new JsonData(500,"NO");
//        }
        userAndRoleMapper.setUser(userID);
        return new JsonData(200,"ok");


    }
}
