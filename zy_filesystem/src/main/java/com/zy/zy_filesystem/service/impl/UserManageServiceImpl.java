package com.zy.zy_filesystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.zy_filesystem.dao.UserMapper;
import com.zy.zy_filesystem.pojo.MyFile;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.Role;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.service.UserManageService;
import com.zy.zy_filesystem.util.PasswordHelper;
@Service
public class UserManageServiceImpl implements UserManageService {
	@Autowired
	private UserMapper userMapper;
	Result<User> result = null;
	PasswordHelper newPwd=new PasswordHelper();
	@Override
	public Result<User> queryUserAll() {
		List<User> userList=userMapper.queryUserAll();//获取所有用户数据
		result=new Result<User>();
		if(!userList.isEmpty()) {
			result.setStatus(0);
			result.setData(userList);
			result.setTotal(userMapper.count());//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("查询成功");
		}else {
			result.setStatus(200);
			result.setTotal(0);
//			result.setData(userList);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("查询失败");
		}
		return result;
	}
	@Override
	public Result<User> updateUser(User user) {
		result=new Result<User>();
		int i = userMapper.updateUser(user);
		if(i>0) {
			result.setStatus(0);
			result.setTotal(i);//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("修改成功");
		}else {
			result.setStatus(200);
			result.setTotal(i);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("修改失败");
		}
		return result;
	}
	@Override
	public Result<User> delUser(User user) {
		result=new Result<User>();
		int i = userMapper.delUser(user.getId());
		if(i>0) {
			result.setStatus(0);
			result.setTotal(i);//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("删除成功");
		}else {
			result.setStatus(200);
			result.setTotal(i);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("删除失败");
		}
		return result;
	}
	@Override
	public Result<User> addUser(User user) {
		result=new Result<User>();
		user.setDate(new Date());//设置创建时间
		newPwd.encryptPassword(user);//加密
		int i=userMapper.addUser(user);
		if(i>0) {
			result.setStatus(0);
			result.setTotal(i);//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("添加成功");
		}else {
			result.setStatus(200);
			result.setTotal(i);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("添加失败");
		}
		return result;
	}
	@Override
	public Result<User> delUserAll(List<User> userList) {
		result=new Result<User>();
		int i = userMapper.delUserAll(userList);
		if(i>0) {
			result.setStatus(0);
			result.setTotal(i);//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("批量删除成功");
		}else {
			result.setStatus(200);
			result.setTotal(i);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("批量删除失败");
		}
		return result;
	}
	@Override
	public Result<User> getUserRole() {
		result=new Result<User>();
		List<User> userList=userMapper.getUserRole();//获取所有用户数据
		if(!userList.isEmpty()) {
			result.setStatus(0);
			result.setData(userList);
			result.setTotal(userMapper.count());//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("查询成功");
		}else {
			result.setStatus(200);
			result.setTotal(0);
//			result.setData(userList);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("查询失败");
		}
		return result;
	}
	@Override
	public Result<User> getRoleSelect() {
		result=new Result<User>();
		List<Role> arrayList=userMapper.getRoleSelect();
		ArrayList<String> roleNameList = new ArrayList<String>();
		arrayList.stream().forEach(Role->{
			roleNameList.add(Role.getRoleName());
		});
		System.out.println(roleNameList);
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		map.put("role", roleNameList);
		result.setSelectCondition(map);
		result.setDate(new Date());
		result.setMessage("条件获取成功");
		result.setStatus(0);
		result.setTotal(0);//记录删除条数
		result.setSuccess(true);
		
		return result;
	}
	//修改角色
	@Override
	public Result<User> updateRole(String userId,String roleName) {
		result=new Result<User>();
		int i = userMapper.updateRole(userId,roleName);
		if(i>0) {
			result.setStatus(0);
			result.setTotal(i);//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("修改成功");
		}else {
			result.setStatus(200);
			result.setTotal(i);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("修改失败");
		}
		return result;
	}
	@Override
	public User findByUsername(String userId) {
		return userMapper.findByUsername(userId);
	}

}
