package com.zy.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 测试
 * @author: zhang yi
 * @create: 2019-09-19 16:58
 */
@Controller
public class DemoController {

    @GetMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

}


