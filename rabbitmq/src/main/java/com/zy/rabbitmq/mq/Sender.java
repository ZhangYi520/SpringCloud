package com.zy.rabbitmq.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: SpringCloud
 * @description: 消息生产者
 * @author: zhang yi
 * @create: 2019-08-12 16:10
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    public void send() {
        String context = "hello "+ new Date();
        System.out.println("Sender : "+ context);
        this.amqpTemplate.convertAndSend("hello", context);
    }
}
