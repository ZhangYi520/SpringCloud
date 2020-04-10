package com.zy.common.controller;

import com.zy.common.Service.impl.DemoServiceImpl;
import com.zy.common.base.util.RedisUtil;
import com.zy.common.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)//就是这个注解
public class DemoController {

    @Autowired
    private DemoServiceImpl demoServiceImpl;
    @Autowired
    RedisUtil redisUtil;

    @Value("${server.port}")
    String port;

    @Value("${foo}")
    String foo;


    @GetMapping("/hi")
    public User hi1(@RequestParam("uuid") String uuid) {
        System.out.println(redisUtil);
        System.out.println(demoServiceImpl);
        return demoServiceImpl.getUser(uuid);
    }

}

