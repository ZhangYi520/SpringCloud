package com.zy.common_login.controller;

import com.zy.common_login.base.utils.JsonToMap;
import com.zy.common_login.base.utils.JsonUtil;
import com.zy.common_login.vo.LoginVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Map<String,Object> login(@RequestBody Map<String,Object> json){
        System.err.println(json);
        return json;
    }
}
