package com.zy.zy_sso;

import com.zy.zy_sso.base.rabbitMq.HelloSender;
import com.zy.zy_sso.base.util.EmailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

/**
 * @program: SpringCloud
 * @description: 测试
 * @author: zhang yi
 * @create: 2019-10-08 11:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTestDemo {
    @Autowired
    private HelloSender helloSender;



    @Test
    public void sendTEst() throws InterruptedException {
        System.out.println("开始发送消息！");
        helloSender.send("se");
        System.out.println("消息发送完成！");
        Thread.sleep(5000);
    }

}
