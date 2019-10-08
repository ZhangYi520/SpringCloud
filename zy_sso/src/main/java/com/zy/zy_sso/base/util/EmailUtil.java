package com.zy.zy_sso.base.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @program: SpringCloud
 * @description: 邮件发送工具类
 * @author: zhang yi
 * @create: 2019-10-08 10:54
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
     * @param to
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

}
