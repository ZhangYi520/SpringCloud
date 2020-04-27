package com.zy.common_thirdparty.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 服务接口
 * @author: zhang yi
 * @create: 2020-04-27 16:32
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo(@RequestParam(value = "json")String json) {
        System.err.println("我接受到参数了，参数是："+ json);
        return "OK";
    }

}
