package com.zy.socket;


import com.zy.socket.base.util.email.EmailUtil;
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
public class TestDemo {

    @Autowired
    private EmailUtil mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("spring.mail.username")
    private String fromAddress;
    @Test
    public void sendSimpleMail() throws MessagingException {
        //编辑邮件内容
        String content="Hello，我正在用SpringBoot给你发邮件，祝你生活愉快！";
        mailService.sendSimpleMail("3517026634@qq.com","我是一封邮件",content);
    }

    @Test
    public void sendHtmlMail() throws MessagingException {
        // 编辑HTML内容
        String content="<html>\n"+
                "<body>\n"+
                "<h2>Hello!这是一封SpringBoot发送的HTML邮件。</h2>"+
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail("3517026634@qq.com","我是一封邮件",content);
    }

    @Test
    public void sendAttachmentMail() throws MessagingException {
        // 文件的路径
        String filePath="C:\\Users\\Administrator\\Desktop\\木马.bat";
        String content="<html>\n"+
                "<body>\n"+
                "<h2>你的电脑已经被我攻占，请运行下面的程序，才能确保你电脑的安全，不然我把你电脑文件全删了。。。。哈哈哈哈哈哈</h2>"+
                "</body>\n"+
                "</html>";
        for (int i = 0; i < 3; i++) {
            mailService.sendAttachmentMail(
                    "3517026634@qq.com",
                    "您的电脑已中病毒！",
                    content,
                    filePath
            );
        }

    }

    @Test
    public void TestTemplateMailTest() throws MessagingException {
        //向Thymeleaf模板传值，并解析成字符串,是导这个包import org.thymeleaf.context.Context;
        Context context = new Context();
        context.setVariable("id", "001");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(
                "3517026634@qq.com",
                "您的电脑已中病毒！",
                // 邮件正文
                emailContent);
    }
}
