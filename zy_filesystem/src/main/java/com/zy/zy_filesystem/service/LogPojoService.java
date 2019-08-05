package com.zy.zy_filesystem.service;

import java.util.List;

import com.zy.zy_filesystem.pojo.LogPojo;
import com.zy.zy_filesystem.pojo.Result;

/**  
*   
* 项目名称：bookSystem  
* 类名称：LogPojoService  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月14日 下午4:21:04  
* 修改人：zhangyi  
* 修改时间：2019年2月14日 下午4:21:04  
* 修改备注：  
* @version   
*   
*/
public interface LogPojoService {
		//查询数量
		//public Integer count();
		//查询
		public Result<LogPojo> queryLogPojo(Integer page,Integer limit);
		//插入
		public Result<LogPojo> insertLogPojo(LogPojo logPojo);
		//删除
		public Result<LogPojo> delLogPojo(LogPojo logPojo);
		//批量删除
		public Result<LogPojo> delLogPojoAll(List<LogPojo> logPojoList);
}
