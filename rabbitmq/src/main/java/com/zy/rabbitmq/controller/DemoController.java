package com.zy.rabbitmq.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloud
 * @description: test
 * @author: zhang yi
 * @create: 2019-08-13 11:44
 */
@RestController
public class DemoController {

    @PostMapping("/demo")
    public String demo(){
        return "aaa";
    }
}
