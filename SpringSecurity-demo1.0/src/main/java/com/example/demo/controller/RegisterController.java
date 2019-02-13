package com.example.demo.controller;

import com.example.demo.common.JsonData;
import com.example.demo.model.User;
import com.example.demo.model.UserAndRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by linziyu on 2019/2/12.
 *
 * 注册视图
 */

@Controller
public class RegisterController {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @RequestMapping(value ="/register" )
    @ResponseBody
    public JsonData register(User user){
        String rawPasswod = user.getPassword();
        String encodePassword = ENCODER.encode(rawPasswod);
        user.setPassword(encodePassword);
        userService.saveUser(user);
        Integer userID = userService.getUserId(user.getUsername());
        Integer roleID = 2;//每个新注册用户默认设置角色为普通用户
        UserAndRole userAndRole = new UserAndRole(userID,roleID);
        userRoleService.save(userAndRole);
        return new JsonData(200,"注册成功");
    }

}
