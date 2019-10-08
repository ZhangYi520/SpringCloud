package com.zy.zy_sso.base.rabbitMq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloud
 * @description: 配置发送消息的方
 * @author: zhang yi
 * @create: 2019-10-08 15:42
 */
@Component
public class HelloSender {
    /**
     * boot集成了一个类可以发送消息，特方便
     */
    @Autowired
    private AmqpTemplate template;

    public void send(String msg) {
//        String msg = "内容";
        template.convertAndSend("queue", msg);
    }
}

