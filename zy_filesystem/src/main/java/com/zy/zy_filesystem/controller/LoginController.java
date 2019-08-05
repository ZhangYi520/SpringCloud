package com.zy.zy_filesystem.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import com.zy.zy_filesystem.aop.Log;
import com.zy.zy_filesystem.dao.UserMapper;
import com.zy.zy_filesystem.pojo.Action;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.util.PasswordHelper;

@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserMapper userMapper;
	
	PasswordHelper newPwd=new PasswordHelper();
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// 成功页面展示
	@GetMapping("/main")
	public String error() {
		return "main";
	}
	
	@PostMapping(value="/login")
	@Log(operationName="登录")
//	@ResponseBody
	public String login(@RequestParam("username") String userId,
			@RequestParam("password") String password,Map<String, Object> map,
			HttpSession session) {
		System.out.println("进入登录界面,账号:"+userId+",密码:"+password);
		Subject subject = SecurityUtils.getSubject();
//		String pws="84cf6dca79368f77c46fb7630507f0d9";
		UsernamePasswordToken token = new UsernamePasswordToken(userId,password);
		try {
			subject.login(token);
			User user=userMapper.queryUserByUserName(userId);
			System.out.println("登陆成功");
			 subject.getSession().setAttribute("user", user);
			return "login";
		} catch (LockedAccountException lae) {
			lae.printStackTrace();

		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return "登录失败";
//		if(u.getPassword().equals(user.getPassword())) {
//			//System.out.println("--------"+user+"------");
//			List<String> actionList=userMapper.getActionById(userId);
//			System.out.println("权限有-----:"+actionList);
//			//登录成功后，防止表单提交，所以需要重定向
//			session.setAttribute("loginUser",user);
//			session.setAttribute("action", actionList);
//			return "redirect:/main.html";
//		}
//		else{
//		map.put("msg", "用户名密码错误");
//		return "login";
//		}
	}
}
