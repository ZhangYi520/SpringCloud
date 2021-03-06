package com.zy.common.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.netflix.discovery.converters.Auto;
import com.zy.common.Service.impl.DemoServiceImpl;
import com.zy.common.base.util.RedisUtil;
import com.zy.common.base.util.qrCode.QRCodeUtil;
import com.zy.common.entity.Article;
import com.zy.common.entity.User;
import com.zy.common.serviceCall.CallDemo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.*;

@RestController
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)//就是这个注解
public class DemoController {

    @Autowired
    private DemoServiceImpl demoServiceImpl;
    @Autowired
    RedisUtil redisUtil;

    @Value("${server.port}")
    String port;

    @Value("${foo}")
    String foo;

    @Autowired
    private CallDemo callDemo;

    @GetMapping("/hi")
    public Object hi1(@RequestParam("uuid") String uuid) {
        /**服务调用*/
        callDemo.demo();
        return "0";
    }


    public static void main ( String[] args ) {
        System.out.println(toCamelCase("u_nme"));
    }
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '_') {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}
