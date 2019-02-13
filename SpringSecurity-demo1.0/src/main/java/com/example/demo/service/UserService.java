package com.example.demo.service;

import com.example.demo.common.JsonData;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by linziyu on 2019/2/9.
 *
 * 处理用户
 *
 */

@Service("UserService")
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    public  User findByUserName(String userName){
        return userMapper.findByUserName(userName);
    }

    public void saveUser(User user){
            userMapper.insert(user);
    }

    public List<User> getAllUsers(){
     return userMapper.getAllUsers();
    }

    public Integer getUserId(String username){
            return userMapper.getUserId(username);
    }

    public JsonData deleteUserById(Integer id,String delete_user_role){
        if (delete_user_role.equals("ROLE_ADMIN")){
            return new JsonData(501,"NO");
        }
        userMapper.deleteUserById(id);
        return new JsonData(200,"OK");



    }

}
