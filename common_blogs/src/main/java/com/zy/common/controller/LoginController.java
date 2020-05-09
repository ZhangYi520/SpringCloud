package com.zy.common.controller;

import com.alibaba.fastjson.JSON;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.serviceCall.CallInterface.LoginServiceCall;
import com.zy.common.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringCloud
 * @description: 登录接口(调用第三方登录服务)
 * @author: zhang yi
 * @create: 2020-05-08 14:08
 */
@RestController
@RequestMapping("/blogs")
public class LoginController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginServiceCall loginServiceCall;

    @PostMapping("/login")
    public ReturnResult login(@RequestParam("json") String json){
        System.err.println(json);
        String login = loginServiceCall.login(json);
        return ReturnResult.ok(login);
    }

}
