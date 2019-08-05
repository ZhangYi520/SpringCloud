package com.zy.zy_filesystem.controller.userManage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.zy_filesystem.aop.Log;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.service.impl.UserManageServiceImpl;

@Controller
public class UserManageController {

	private Result<User> result = null;
	@Autowired
	private UserManageServiceImpl userManageServiceImpl;
	@GetMapping("/toUserManageList")
	public String toUserManageList() {
		return "userManage/userList";
	}
	
	//查询数据
	@GetMapping("/queryUserAll")
	@ResponseBody
	@Log(operationName="查询用户")
	public Result<User> queryUserAll() {
		
		return userManageServiceImpl.queryUserAll();
	}

	//添加
	@PostMapping("/addUser")
	@ResponseBody
	@Log(operationName="添加用户")
	public Result<User> addUser(@RequestBody User user) {
		System.out.println(user);
		return userManageServiceImpl.addUser(user);
	}
	//修改
	@PostMapping("/updateUser")
	@ResponseBody
	@Log(operationName="修改用户")
	public Result<User> updateUser(@RequestBody User user) {
		System.out.println(user);
		return userManageServiceImpl.updateUser(user);
	}
	//删除
	@PostMapping("/delUser")
	@ResponseBody
	@Log(operationName="删除用户")
	public Result<User> delUser(@RequestBody User user) {
		
		return userManageServiceImpl.delUser(user);
	}
	
	//批量删除
	@PostMapping("/delUserAll")
	@ResponseBody
	@Log(operationName="批量删除用户")
	public Result<User> delUserAll(@RequestBody List<User> userList) {
		//System.out.println(user);
		return userManageServiceImpl.delUserAll(userList);
	}
	
}
