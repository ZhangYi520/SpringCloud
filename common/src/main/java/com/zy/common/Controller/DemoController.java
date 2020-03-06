package com.zy.common.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RefreshScope
public class DemoController {

    @Value("${server.port}")
    String port;

    @Value("${foo}")
    String foo;

    @GetMapping("/demo")
    public User demo(@RequestParam(value = "name", defaultValue = "小毅毅") String name) {
        User u = new User();
        u.setName(name);
        u.setAge(Integer.valueOf(port));
        return u;
    }

    @GetMapping("/hi")
    public String hi1() {
        return foo;
    }
}

@Data
class User implements Serializable {
    private String name;
    private Integer age;
}
