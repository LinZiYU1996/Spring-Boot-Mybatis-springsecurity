package com.example.demo.controller;

import com.example.demo.common.JsonData;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by linziyu on 2019/2/13.
 *
 * 用户处理视图
 */

@Controller
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/deleteUserById")
    @ResponseBody
    public JsonData deleteUserById(Integer id,String role){
        return userService.deleteUserById(id,role);
    }

}
