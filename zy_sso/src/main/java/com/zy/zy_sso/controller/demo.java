package com.zy.zy_sso.controller;

import java.util.*;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



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

class 类{
	public static void main(String [] args){
		int index;
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		Integer [] arr=new Integer[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		Set<Integer> staffsSet = new HashSet<Integer>(Arrays.asList(arr));
		Object[] result = staffsSet.toArray();
//		System.out.println("处理前:"+Arrays.toString(result));
		//排序
		Arrays.sort(result);
//		System.out.println("处理中:"+Arrays.toString(result));
		for (int i = 0; i <result.length -1; i++) {
				if((Integer)result[i+1]-(Integer)result[i]!=1){
					flag=false;
				}
		}
//		for (Object o : result) {
//			int i=(Integer)o;
//
//		}
		if(flag){
			System.out.println(result.length);
		}
//		else{
//			System.out.println("0:"+Arrays.toString(result));
//		}
	}
}

