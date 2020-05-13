package com.zy.common_thirdparty.controller;

import com.alibaba.fastjson.JSONObject;
import com.zy.common_thirdparty.base.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.HashMap;

/**
 * @program: SpringCloud
 * @description: 验证码发送接口
 * @author: zhang yi
 * @create: 2020-05-13 15:20
 */
@RestController
@RequestMapping("/sendVCode")
public class SendVCodeController {

    @Autowired
    private EmailUtil mailService;

    @PostMapping("/send")
    public Object send(@RequestBody HashMap<String,Object> map){
        JSONObject j=new JSONObject();
        System.err.println(map.get("email"));
        String email = (String)map.get("email");
        try {
            mailService.sendVCode(email);
            j.put("msg","发送成功");
            j.put("code",200);
            return j;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        j.put("msg","发送失败");
        j.put("code",500);
        return j;
    }
}
