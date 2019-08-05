package com.zy.zy_filesystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.zy_filesystem.pojo.Action;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.Role;
import com.zy.zy_filesystem.pojo.User;

public interface UserMapper {
	//id查询用户
	public User queryUserById(Integer id);
	public User queryUserByUserName(String userName);
	//求数量 
	public Integer count();
	//查询所有
	public List<User> queryUserAll();
	//修改
	public Integer updateUser(User user);
	//删除
	public Integer delUser(Integer id);
	//批量删除
	public Integer delUserAll(List<User> userList);
	//添加
	public Integer addUser(User user);
	
	public List<User> userList();
	//查询用户角色
	public List<User> getUserRole();
	public List<Role> getRoleSelect();
	//修改role
	public int updateRole(@Param("userId") String userId,@Param("roleName") String roleName);
	//根据用户Id获取对应的权限
	public List<String> getActionById(String userId);
	public User findByUsername(@Param("userId") String userId);
}
