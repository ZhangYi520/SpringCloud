package com.zy.zy_sso.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public static void main(String[] args) {


        List<Person> list = new ArrayList();
        list.add(new Person(1, "haha"));
        list.add(new Person(1, "rere"));
        list.add(new Person(2, "fefe"));

        Map<Integer,List<Person>> ss=list.stream()
                .collect(Collectors.groupingBy(Person::getId));

//        System.out.println(ss);

//        List<Person> aa=ss.get(1);
//        System.out.println(aa);

        //方式二：
        Map<Boolean,List<Person>> gg=list.stream()
                .collect(Collectors.partitioningBy(p->p.getId()==1));

        System.out.println(gg);
//
//        List<Person> ff=gg.get(true);

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