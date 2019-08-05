package com.zy.zy_filesystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.zy_filesystem.dao.LogPojoMapper;
import com.zy.zy_filesystem.dao.LogPojoMapper;
import com.zy.zy_filesystem.pojo.LogPojo;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.User;
import com.zy.zy_filesystem.pojo.LogPojo;
import com.zy.zy_filesystem.service.LogPojoService;

/**  
*   
* 项目名称：bookSystem  
* 类名称：LogPojoServiceImpl  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月14日 下午4:21:44  
* 修改人：zhangyi  
* 修改时间：2019年2月14日 下午4:21:44  
* 修改备注：  
* @version   
*   
*/
@Service
public class LogPojoServiceImpl implements LogPojoService {
	@Autowired
	private LogPojoMapper logPojoMapper;
	Result<LogPojo> result = null;

	@Override
	public Result<LogPojo> queryLogPojo(Integer page,Integer limit) {  //当前页数，数量
		List<LogPojo> logPojoList=logPojoMapper.queryLogPojo((page-1)*limit,limit);//获取所有日志数据
		System.out.println(logPojoList);
		result=new Result<LogPojo>();
		if(!logPojoList.isEmpty()) {
			result.setStatus(0);
			result.setData(logPojoList);
			result.setTotal(logPojoMapper.count());//获取数据总数
			result.setSuccess(true);
			result.setDate(new Date());
			result.setMessage("查询成功");
		}else {
			result.setStatus(200);
			result.setTotal(0);
//			result.setData(LogPojoList);
			result.setSuccess(false);
			result.setDate(new Date());
			result.setMessage("查询失败");
		}
		return result;
	}

	@Override
	public  Result<LogPojo> insertLogPojo(LogPojo logPojo) {
		result=new Result<LogPojo>();
		int i=logPojoMapper.insertLogPojo(logPojo);
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

	/**
	 * 单个删除
	 */
	@Override
	public  Result<LogPojo> delLogPojo(LogPojo logPojo) {
		result=new Result<LogPojo>();
		int i = logPojoMapper.delLogPojo(logPojo.getId());
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

	/**
	 * 批量删除
	 */
	@Override
	public Result<LogPojo> delLogPojoAll(List<LogPojo> logPojoList) {
		result=new Result<LogPojo>();
		int i = logPojoMapper.delLogPojoAll(logPojoList);
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

}
