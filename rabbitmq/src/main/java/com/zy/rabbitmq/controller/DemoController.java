package com.zy.rabbitmq.controller;

import com.zy.rabbitmq.base.util.RedisUtil;
import com.zy.rabbitmq.mq.MessageProvider;
import com.zy.rabbitmq.pojo.MessagePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringCloud
 * @description: test
 * @author: zhang yi
 * @create: 2019-08-13 11:44
 */
@RestController
public class DemoController {
    @Autowired
    private MessageProvider messageProvider;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/put")
    public String demo(){
        redisUtil.set("name","zhangyi",10);
        return "aaa";
    }

    @GetMapping("/get")
    public Map<String,Object> get(){
        Map<String,Object> m =new HashMap<>();
        m.put("time",redisUtil.getExpire("name"));
        m.put("val",redisUtil.get("name"));
        return m;
    }
    @GetMapping("/demo1")
    public void hello1(@RequestParam("time") Integer time,@RequestParam("name") String name) throws Exception {
        MessagePojo m =new MessagePojo();
        m.setDelay(time);
        m.setClassName(name);

        messageProvider.sendMessage(m);
    }

}
