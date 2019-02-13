package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linziyu on 2019/2/11.
 *
 * 分页处理视图
 */

@Controller
@Slf4j
public class PageController {

    @Resource
    private UserService userService;

    //用户资料分页
    @RequestMapping(value = "/getAllUser")
    @ResponseBody
    public Map<String,Object> page(int page, int limit){
        //引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
//        log.info("{}","page");
        PageHelper.startPage(page,limit);
        //startPage后紧跟的这个查询就是分页查询
        List<User> users = userService.getAllUsers();
        for(User user:users){
            user.setRole(user.getRoles().get(0).getName());//用户角色包装 方便处理
        }
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<User>(users, 5);
        Map<String,Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        data.put("count", pageInfo.getPages()*5);
        //将分页后的数据返回（每页要显示的数据）
        data.put("data", users);
        //返回给前端
        return data;

    }

}
