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

import com.alibaba.fastjson.JSONObject;
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

    }

//    public  static String a(){
//
//    }
}

class 类 {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        change(a);
        System.out.println(a);
    }

    static void change(List<String> a) {
        a.add("zy");
    }

}
@Data
class A{
    Integer id;
    String name;
}

