package com.zy.zy_sso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zy.zy_sso.base.result.Result;
import com.zy.zy_sso.base.util.RedisTemplateUtil;
import com.zy.zy_sso.vo.UserPara;
import com.zy.zy_sso.entity.UserEntity;
import com.zy.zy_sso.Service.impl.UserServiceImpl;

/**
 * @author 用户管理
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/getUser")
	public Result<UserEntity> getUser(){
		UserEntity u=(UserEntity)RedisTemplateUtil.redisTemplate.opsForHash().get("login","zy");//获取redis
		return Result.success(u);
	}
	
	@GetMapping("/delUser")
	public Result<UserEntity> delUser(){
		RedisTemplateUtil.redisTemplate.opsForHash().delete("login","zy");
		return Result.success();
	}
	
	@GetMapping("/getUserList")
	public Result<List<UserEntity>> getUserList(/* @RequestBody */ UserPara u){
		Result<List<UserEntity>> l=userServiceImpl.getUserList(u);
		System.out.println(l.toString());
		System.out.println(l.getData().toString());
		return l;
	}
}
