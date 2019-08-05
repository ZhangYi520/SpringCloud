package com.zy.zy_filesystem.service;

import java.util.List;

import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;

public interface UserManageService {
	
	public User findByUsername(String userId);
	
	public Result<User> queryUserAll();//查询所有
	
	public Result<User> updateUser(User result);//修改
	
	public Result<User> delUser(User user);//删除
	public Result<User> delUserAll(List<User> userList);//批量删除
	public Result<User> addUser(User user);//添加
	////查询用户角色
	public Result<User> getUserRole();
	//获取修改role下拉框值
	public Result<User> getRoleSelect();
	//修改角色
	public Result<User> updateRole(String userId,String roleName);
}
