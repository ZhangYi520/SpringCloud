package com.zy.zy_filesystem.controller.userManage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.Role;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.service.UserManageService;

/**  
*   
* 项目名称：bookSystem  
* 类名称：AuthorityController  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月13日 下午5:05:01  
* 修改人：zhangyi  
* 修改时间：2019年2月13日 下午5:05:01  
* 修改备注：  
* @version   
*   
*/
@RestController
public class RoleController {
	
	/*@GetMapping("/toAuthority")
	public String toUserManageList() {
		return "userManage/authorityList";
	}*/
	@Autowired
	private UserManageService userManageService;
	
	
	@GetMapping("/getAuthority")
	public Result<User> getUserRole(){
	return userManageService.getUserRole();
	}
	
	@GetMapping("/querySelectRoleValue")
	public Result<User> getRoleSelect(){
		return userManageService.getRoleSelect();
	} 
	//修改role
	@GetMapping("/updateRole")
	public  Result<User> updateRole(String userId, String roleName){
		System.out.println(userId+"-----"+roleName);
 		return userManageService.updateRole(userId,"管理员");
	}
}
