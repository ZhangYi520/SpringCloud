package com.zy.zy_sso.controller;

import org.apache.http.entity.StringEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

}

class 类 {
//    ReentrantLock r=new ReentrantLock();
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(T.class).toPrintable());
    }
}

class Test{
//    int len=10;
//    int duan=5;
    public static void main(String[] args) {

    }
}


