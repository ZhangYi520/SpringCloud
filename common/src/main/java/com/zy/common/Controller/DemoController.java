package com.zy.common.controller;

import com.zy.common.Service.impl.DemoServiceImpl;
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

    @Value("${server.port}")
    String port;

    @Value("${foo}")
    String foo;

    @GetMapping("/demo")
    public User1 demo(@RequestParam(value = "name", defaultValue = "小毅毅") String name) {
        User1 u = new User1();
        u.setName(name);
        u.setAge(Integer.valueOf(port));
        return u;
    }

    @GetMapping("/hi")
    public User hi1(@RequestParam("uuid") String uuid) {
        return demoServiceImpl.getUser(uuid);
    }
}

@Data
class User1 implements Serializable {
    private String name;
    private Integer age;
}
