package com.zy.zy_sso.login.Controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.zy.zy_sso.base.result.Result;
import com.zy.zy_sso.base.util.RedisTemplateUtil;
import com.zy.zy_sso.systemManage.menu.entity.Menu;
import com.zy.zy_sso.systemManage.menu.service.impl.MenuServiceImpl;
import com.zy.zy_sso.systemManage.user.entity.UserEntity;

@Controller
public class ToViewController {
	@Autowired
	private MenuServiceImpl menuServiceImpl;
	
	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap model) {
	    Subject subject = SecurityUtils.getSubject();
	    String usernName = (String) subject.getPrincipal();
	    System.out.println("退出登录的用户："+usernName);
	    RedisTemplateUtil.redisTemplate.opsForHash().delete("login",usernName);
	    subject.logout();
	    model.put("msg","安全退出！");
	    return "login";
	}
	
	@GetMapping("/index")
	public String toIndex(ModelMap mmap,String userName) {
		//进入主页时获取菜单、用户等信息
//		userName="zy";
		UserEntity u=(UserEntity)RedisTemplateUtil.redisTemplate.opsForHash().get("login",userName);//获取redis中保存的用户信息
		Result<List<Menu>> resList = menuServiceImpl.selectList(userName);
		System.out.println(resList);
		mmap.put("user", u);
		mmap.put("menus", resList.getData());//从结果集中获取数据
		return "index";
	}
	
	@GetMapping("/main")
	public String toMain() {
		return "main";
	}
}
