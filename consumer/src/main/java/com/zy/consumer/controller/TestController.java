package com.zy.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class TestController {
    //    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    Feign feign;  //依赖注入的接口
//    private static final String MALL_CRUD_USERS_URL = "http://spring-cloud-common/";

    @GetMapping("/demo")
    public String getCommon(@RequestParam String name) {
        new HashMap<>();
        System.out.println("调用服务开始---------");
//        String s = restTemplate.getForObject(MALL_CRUD_USERS_URL+"demo?name="+name, String.class);
        String s = feign.feignDemo(name);
        System.out.println("调用服务结束---------调用取得的值为：" + s);
        return s;
    }
}

/*
 * 这个接口就是为了调用别的服务
 * */
@Service
@FeignClient(value = "spring-cloud-common", fallback = SchedualServiceHiHystric.class)
        //Feign会根据注解上的value值找到具体的服务名，然后再根据接口上的Mapping找到当前服务对应的接口
interface Feign {
    @GetMapping("/demo")
        //这里的路径和生产者的路径一致，所以才能对应上
    String feignDemo(@RequestParam(value = "name") String name);
}

@Component
class SchedualServiceHiHystric implements Feign {

    @Override
    public String feignDemo(String name) {
        return "error," + name;
    }
}

