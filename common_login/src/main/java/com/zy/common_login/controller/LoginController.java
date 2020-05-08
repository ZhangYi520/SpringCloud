package com.zy.common_login.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringCloud
 * @description: 登录服务 接口控制层
 * @author: zhang yi
 * @create: 2020-05-08 14:23
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/into")
    public String login(@RequestParam(value = "json") String json){
        System.err.println(json);
        return "json:"+json;
    }
}
