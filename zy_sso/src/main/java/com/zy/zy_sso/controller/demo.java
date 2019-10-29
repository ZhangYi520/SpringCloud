package com.zy.zy_sso.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;


@RestController
public class demo {
    @GetMapping("/test")
    @RequiresRoles("超级管理员")//shiro角色注解，拥有该角色才能访问
    @RequiresPermissions("/select")//shiro权限注解，拥有该权限才能访问
    public String to() {
        return "idea";
    }

    @GetMapping("/test2")
    @RequiresPermissions("/delete")
    public String to2() {
        return "2019年4月28日11:21:48";
    }

    @GetMapping("/test3")
    @RequiresRoles("超级管理员")//shiro角色注解，拥有该角色才能访问
    @RequiresPermissions("/s")
    public String to3() {
        return "2019年4月28日11:21:48";
    }

    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //速率是每秒只有5个许可
        final RateLimiter rateLimiter = RateLimiter.create(5.0);
        for (int i = 0; i < 50; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取许可
                        rateLimiter.acquire();
                        System.out.println("Accessing: " + no + ",time:"
                                + new SimpleDateFormat("yy-MM-dd HH:mm:ss:SSS").format(new Date()));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            //执行线程
            exec.execute(runnable);
        }
        //退出线程池
        exec.shutdown();
    }
}

class 类 {
    public static void main(String[] args) throws Exception {
        Calendar 日历 = Calendar.getInstance();
        日历.set(Calendar.HOUR_OF_DAY, 17);
        日历.set(Calendar.MINUTE, 30);
        日历.set(Calendar.SECOND, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String 下班时间=sdf.format(日历.getTime());
        SimpleDateFormat 格式化=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Date 下班时间新格式=格式化.parse(下班时间);
        while(true){
            Thread.sleep(1000);
            Date 当前时间 = new Date();
            long 相差的时间 = (下班时间新格式.getTime() - 当前时间.getTime()) / 1000;
            long 时=相差的时间/60/60;
            long 分=(相差的时间-时*60*60)/60;
            long 秒=相差的时间-时*60*60-分*60;
            //会打印出相差3秒
            System.out.println("倒计时:"+时+"时"+分+"分"+秒+"秒。"+"离下班还差" + 相差的时间 + "秒");
            if(相差的时间 ==0){
                break;
            }
        }
        Runtime.getRuntime().exec("cmd.exe/C start shutdown -s -t 00");
    }

}
//
//@Data
//class Person{
//    Integer id;
//    String name;
//
//    public Person() {
//    }
//
//    public Person(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//}

