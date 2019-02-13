//package com.example.demo.controller;
//
//import com.example.demo.model.User;
//import com.example.demo.service.UserService;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.Resource;
//
///**
// * Created by linziyu on 2019/2/8.
// */
//
//
//@Controller
//public class IndexController {
//
//    @Resource
//    private UserService userService;
//    private final static BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
//
////    @RequestMapping(value = "/")
////    public String index(){
////        return "home";
////    }
//
//    @RequestMapping(value = "/sa")
//    public String sace(){
//        String name = "1";
//        String rawpwd = "1";
//        String encodepwd = ENCODER.encode(rawpwd);
//        User user = new User(name,encodepwd);
//        userService.saveUser(user);
//        return "OK";
//    }
//
//    @RequestMapping(value = "myerror")
//    public String error(){
//        return "error";
//    }
//
////
//    @RequestMapping(value = "/hello")
//    public String hello(){
//        return "hello";
//    }
//
//    @Secured("ROLE_USER")
//    @RequestMapping(value = "/user")
//    public String user(){
//        return "user";
//    }
//
//    @Secured("ROLE_ADMIN")
//    @RequestMapping(value = "/admin")
//    public String admin(){
//        return "admin";
//    }
//
//}
