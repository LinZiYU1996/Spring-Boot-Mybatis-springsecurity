package com.example.demo.controller;

import com.example.demo.common.JsonData;
import com.example.demo.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by linziyu on 2019/2/12.
 *
 * 用户角色处理视图
 */

@Controller
@Slf4j
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    //设置为管理员
    @RequestMapping(value = "/setUserAdmin")
    @ResponseBody
    public JsonData changeUserRole(Integer id){
        userRoleService.setUserAdmin(id);
        return new JsonData(200,"ok");

    }
    //设置为普通用户
    @RequestMapping(value = "/setUser")
    @ResponseBody
    public JsonData setUser(Integer id){
        return userRoleService.setUser(id);
    }




}
