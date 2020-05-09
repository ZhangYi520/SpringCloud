package com.zy.common_login.controller;

import com.zy.common_login.vo.LoginVo;
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
    public String login(@RequestBody LoginVo vo){
        System.err.println(vo);
        return "json:"+vo;
    }
}
