package com.zy.rabbitmq.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloud
 * @description: 消息消费者
 * @author: zhang yi
 * @create: 2019-08-12 16:12
 */
@Component
@RabbitListener(queues = "hello")   //对hello队列进行监听
public class Receiver {

    @RabbitHandler  //消费消息
    public void process(String hello) {
        System.out.println("Receiver : "+ hello);
    }
}
