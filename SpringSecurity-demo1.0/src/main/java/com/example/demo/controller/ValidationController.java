package com.example.demo.controller;

import com.example.demo.common.JsonData;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by linziyu on 2019/2/13.
 *
 * 校验处理视图
 */

@Controller
@Slf4j
public class ValidationController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/checkNameIsExistOrNot")
    @ResponseBody
    public JsonData checkUserNameISExistOrNot(String username){
        User user = userService.findByUserName(username);
//        log.info("{}",user+"******");
        if (user != null){
            return new JsonData(301,"用户名被占有了");

        } else {
            return new JsonData(200,"用户名可以使用");
        }
    }



}
