package com.zy.zy_sso.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
//	
//	@GetMapping("/t")
//	public Result<List<Menu>> to4() {
//		Menu vo=new Menu();
//		vo.setMenu_id(1L);
//		vo.setPage(1);
//		vo.setPageSize(5);
//		PageHelper.startPage(vo.getPage(), vo.getPageSize());
//		QueryWrapper
//		List<Menu> l=menuMapper.sele
//		System.out.println(l);
//		return Result.success(l);
//	}
//	@GetMapping("/t1")
//	public Object to5() {
//		System.out.println(11111);
////		Menu vo=new Menu();
////		vo.setPage(1);
////		vo.setPageSize(5);
////		PageHelper.startPage(vo.getPage(), vo.getPageSize());
////		List<Menu> selectList = menuMapper.selectList(null);
////		System.out.println(selectList);
//		return 1;
//	}
}

class 类 {
    public static void main(String[] args) throws Exception {
        String 下班时间="2019-9-30 17:30:00";
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
        }


    }

}

@Data
class Person{
    Integer id;
    String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}