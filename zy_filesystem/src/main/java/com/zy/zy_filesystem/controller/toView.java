package com.zy.zy_filesystem.controller;
/**  
*   
* 项目名称：bookSystem  
* 类名称：toView  
* 类描述：  用于返回试图的路径集合类
* 创建人：zhangyi  
* 创建时间：2019年2月24日 下午8:02:04  
* 修改人：zhangyi  
* 修改时间：2019年2月24日 下午8:02:04  
* 修改备注：  
* @version   
*   
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class toView {
	
	@GetMapping("/toMyDesktop")
	public String toMyDesktop() {
		return "pages/welcome";
	}
	
	@GetMapping("/toRole")
	public String toRoleList() {
		return "userManage/roleList";
	}
	
	@GetMapping("/toAuthority")
	public String toAuthority() {
		return "userManage/authorityList";
	}
	@GetMapping("/toWrit")
	public String toWrit() {
		return "writ/writ";
	}
}
