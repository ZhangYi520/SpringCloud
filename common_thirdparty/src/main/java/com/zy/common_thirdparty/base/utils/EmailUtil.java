package com.zy.common_thirdparty.base.utils;

import com.zy.common_thirdparty.base.Cons;
import com.zy.common_thirdparty.base.ProjectVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Random;

/**
 * @program: SpringCloud
 * @description: 邮件工具类
 * @author: zhang yi
 * @create: 2020-04-29 11:38
 */
@Component
public class EmailUtil {

    /**
     * 使用该类的send()方法发送邮件
     */
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromAddress;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ProjectVersion projectVersion;

    @Value("${myblog.name}")
    private String name;

    @Autowired
    private RedisUtil redisUtil;

    private final static Long VCODE_EXP_TIME=60*5L;
    /**
     * 发送文本邮件
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String to, String subject, String content) {
        // 编辑发送邮件的一些信息，有-->发件人地址，收件人地址，邮件标题，邮件正文
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人地址
        message.setFrom(fromAddress);
        // 收件人地址
        message.setTo(to);
        // 邮件标题
        message.setSubject(subject);
        // 邮件正文
        message.setText(content);
        try {
            mailSender.send(message);
            System.out.println("发送成功！");
        } catch (Exception e) {
            System.out.println("发送失败！");
            System.out.println(e.getMessage());
        }
    }

    /**
     * 发送HTML邮件
     *
     * @param to 收件人邮箱
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        // 这里与发送文本邮件有所不同
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromAddress);
        helper.setTo(to);
        helper.setSubject(subject);
        // 发送HTML邮件，也就是将邮件正文使用HTML的格式书写
        helper.setText(content, true);
        try {
            mailSender.send(message);
            System.out.println("发送成功！");
        } catch (Exception e) {
            System.out.println("发送失败！");
            System.out.println(e.getMessage());
        }
    }

    /**
     * 发送附件邮件
     *
     * @param to       收件人
     * @param subject  标题
     * @param content  内容
     * @param filePath 文件地址
     * @throws MessagingException
     */
    public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        System.out.println(fromAddress);
        helper.setFrom(fromAddress);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);
        // 读取文件
        FileSystemResource file = new FileSystemResource(new File(filePath));
        // 取得文件名
        String fileName = file.getFilename();
        //添加附件，可多次调用该方法添加多个附件
        helper.addAttachment(fileName, file);
        try {
            mailSender.send(message);
            System.out.println("发送成功！");
        } catch (Exception e) {
            System.out.println("发送失败！");
            System.out.println(e.getMessage());
        }
    }



    /**
     * 发送短信验证码
     *
     * @param to 收件人邮箱
     * @throws MessagingException
     */
    public void sendVCode(String to) throws MessagingException {
        //向Thymeleaf模板传值，并解析成字符串,是导这个包import org.thymeleaf.context.Context;
        Context context = new Context();
        //当前项目信息
        System.err.println(name);
        System.err.println(projectVersion);
        context.setVariable("name", name);
        //验证码
        String vcode = String.valueOf(new Random().nextInt(899999) + 100000);
        context.setVariable("vcode", vcode);
        //这个名字就是html文件的名字
        String emailContent = templateEngine.process("VCodeTemp", context);

        MimeMessage message = mailSender.createMimeMessage();
        // 这里与发送文本邮件有所不同
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromAddress);
        helper.setTo(to);
        helper.setSubject("验证码");
        // 发送HTML邮件，也就是将邮件正文使用HTML的格式书写
        helper.setText(emailContent, true);
        try {
            mailSender.send(message);

            redisUtil.set(Cons.REDIS_PREFIX.VCODE+to,vcode,VCODE_EXP_TIME);
//            System.out.println(redisUtil.get("vcode:"+to));
            System.out.println("发送成功！");
        } catch (Exception e) {
            System.out.println("发送失败！");
            System.out.println(e.getMessage());
        }
    }

}

