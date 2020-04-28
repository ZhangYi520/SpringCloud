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
        System.out.println(calcString("HC11N2"));
    }


    /**
     * 已知四种原子的质量，C/H/O/N分别为12/1/16/14,输入分子式，计算分子量。
     * 例如"H2O"，分子量为1*2+16=18，有如HC11N2，分子量为1+12*11+14*2=161
     * 输入异常数据时返回0
     * 数字的ascII码范围是48~57
     * A~Z:65~90
     * @param str
     * @return
     */
    public static int calcString(String str){
        char[] chars = str.toCharArray();
        //用于记录前一个字符是不是字母
        boolean flag=true;
        //判断是否合法
        for (int j = 0; j < chars.length; j++) {
            int i=(int)chars[j];
            //第一个是否是字母
            if(j==0){
                if(!(i>=65 && i<=90)){
                    return 0;
                }
            }
            //其余的是否是规范的字符
            if( !((i>=48 && i<=57)||(i>=65 && i<=90))){
                return 0;
            }
        }
        /**
         * 挨个拆分出来，如果是字母，则添加进list集合，如果是数字，先记录拼接，
         * 直到下一个出现字母，则把拼接好的数字添加起来，在添加字母。
         */
        //用于组装数字
        String numStr="";
        //用于把字母 数字单独存储下来
        List<Object> list=new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            flag = isStr(chars[i]);
            if(flag){
                if(!"".equals(numStr)){
                    list.add(numStr);
                    numStr="";
                }
                list.add(chars[i]);
            }else{
                numStr+=chars[i];
            }
            if(i==chars.length-1){
                if(!"".equals(numStr)){
                    list.add(numStr);
                }
            }
        }


        /**根据整理好的list进行计算，
         * 如果挨着的两个都是字母，则计算第一个，然后从第二个位置开始计算
         * 如果挨着的两个，前一个是字母，后一个是数字，则把它们相乘，然后从第三个位置开始计算，这样可以顾虑掉前一个数字，后一个字母的情况
         * 特殊情况，如果最后只存在一个字母，则直接相加
         * HC2  H2C
         * */
        System.out.println(list);
        int res=0;
        int index=1;
        for (int i = 0; i < list.size(); i+=index) {

            if(i==list.size()-1){
                String s1 = list.get(i).toString();
                int num=0;
                switch (s1){
                    case "C":num=12;break;
                    case "H":num=1;break;
                    case "O":num=16;break;
                    case "N":num=14;break;
                    default:num=0;
                }
                res+=num;
                break;
            }

            String s1 = list.get(i).toString();
            String s2 = list.get(i+1).toString();
            boolean str1 = isStr(s1.charAt(0));
            boolean str2 = isStr(s2.charAt(0));
            if(str1 && str2){
                int num=0;
                switch (s1){
                    case "C":num=12;break;
                    case "H":num=1;break;
                    case "O":num=16;break;
                    case "N":num=14;break;
                    default:num=0;
                }
                res+=num;
                index=1;
                continue;
            }else if(str1 && !str2){
                int num=0;
                switch (s1){
                    case "C":num=12;break;
                    case "H":num=1;break;
                    case "O":num=16;break;
                    case "N":num=14;break;
                    default:num=0;
                }
                res+=(num*Integer.parseInt(s2));
                index=2;
            }

        }
        return res;
    }


    public static boolean isStr(char c){
        int i=(int)c;
        if(i>=65 && i<=90){
            return true;
        }
        return false;
    }
}
