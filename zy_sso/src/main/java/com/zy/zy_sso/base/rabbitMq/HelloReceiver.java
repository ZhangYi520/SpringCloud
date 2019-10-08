package com.zy.zy_sso.base.rabbitMq;

import com.zy.zy_sso.base.util.EmailUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * @program: SpringCloud
 * @description: 消息接收方法
 * @author: zhang yi
 * @create: 2019-10-08 15:47
 */
@Component
public class HelloReceiver {

    @Autowired
    private EmailUtil mailService;

//    public void sendSimpleMail() throws MessagingException {
//        //编辑邮件内容
//        String content="Hello，我正在用SpringBoot给你发邮件，祝你生活愉快！";
//        mailService.sendSimpleMail("3517026634@qq.com","我是一封邮件",content);
//    }

    @RabbitListener(queues="queue",containerFactory ="customContainerFactory")    //监听器监听指定的Queue
    public void processC(String s) throws InterruptedException {
        Thread.sleep(500);
        if("se".equals(s)){
            String content="Hello，我正在用SpringBoot给你发邮件，祝你生活愉快！";
            mailService.sendSimpleMail("3517026634@qq.com","我是一封邮件",content);
        }else{
            System.out.println("接受到的消息:"+s);
        }
//        System.out.println("消费消息："+s);
    }
}
