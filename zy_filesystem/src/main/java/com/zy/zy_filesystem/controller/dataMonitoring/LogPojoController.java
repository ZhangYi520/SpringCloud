package com.zy.zy_filesystem.controller.dataMonitoring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zy.zy_filesystem.aop.Log;
import com.zy.zy_filesystem.pojo.LogPojo;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.service.impl.LogPojoServiceImpl;

/**  
*   
* 项目名称：bookSystem  
* 类名称：LogPojoController  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月14日 下午5:03:43  
* 修改人：zhangyi  
* 修改时间：2019年2月14日 下午5:03:43  
* 修改备注：  
* @version   
*   
*/
@Controller
public class LogPojoController {
	private Result<User> result = null;
	@Autowired
	private LogPojoServiceImpl logPojoServiceImpl;
	@GetMapping("/toLogList")
	public String toUserManageList() {
		return "dataMonitoring/logList";
	}
	
	//查询数据
	@GetMapping("/queryLogPojoAll")
	@ResponseBody
	@Log(operationName="查询日志")
	public Result<LogPojo> queryUserAll(Integer page,Integer limit) {
		System.out.println("------------------------------------"+page+limit);
		return logPojoServiceImpl.queryLogPojo(page,limit);
	}
	
	//删除
	@PostMapping("/delLogPojo")
	@ResponseBody
	@Log(operationName="删除日志")
	public Result<LogPojo> delUser(@RequestBody LogPojo logPojo) {
		
		return logPojoServiceImpl.delLogPojo(logPojo);
	}
	
	//批量删除
	@PostMapping("/delLogPojoAll")
	@ResponseBody
	@Log(operationName="批量删除日志")
	public Result<LogPojo> delUserAll(@RequestBody List<LogPojo> logPojoList) {
		//System.out.println(user);
		return logPojoServiceImpl.delLogPojoAll(logPojoList);
	}
}
