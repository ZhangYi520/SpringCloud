package com.zy.zy_filesystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zy.zy_filesystem.dao.WritMapper;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.pojo.Writ;
import com.zy.zy_filesystem.service.WritImpl;

/**  
*   
* 项目名称：bookSystem  
* 类名称：WritController  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年3月29日 下午2:44:14  
* 修改人：zhangyi  
* 修改时间：2019年3月29日 下午2:44:14  
* 修改备注：  
* @version   
*   
*/
@RestController
public class WritController {
	@Autowired
	private WritImpl writImpl;
	@Autowired
	private WritMapper writMapper;
	@GetMapping("/getWritList")
	public Result<Writ> getWritList(){
		
		return writImpl.getWritList();
	}
	
	@PostMapping("/deleteWrit")
	public Result deleteWrit(@RequestBody Writ writ){
		writMapper.deleteWrit(writ.getId());
		System.out.println(writ.getId());
		Result r=new Result();
		r.setMessage("成功");
		r.setStatus(0);
		r.setSuccess(true);
		return r;
	}
	
	@PostMapping("/saveWrit")
	public Result saveWrit(@RequestBody Writ writ,HttpServletRequest request) {
		
		User user=(User) request.getSession().getAttribute("loginUser");
		writ.setUserId(user.getUserId());
		writMapper.saveWrit(writ);
		
		Result r=new Result();
		r.setMessage("成功");
		r.setStatus(0);
		r.setSuccess(true);
		return r;
	}
}
