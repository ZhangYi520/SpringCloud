package com.zy.common.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${server.port}")
    String port;

    @GetMapping("/demo")
    public String demo(@RequestParam(value = "name", defaultValue = "小毅毅") String name) {
        return "name:" + name + " ,端口:" + port;
    }
}
