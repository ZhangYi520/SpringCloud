package com.zy.socket.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: SpringCloud
 * @description: 登录控制器
 * @author: zhang yi
 * @create: 2019-10-10 16:54
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/main")
    public String tomain(){
        return "main";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
