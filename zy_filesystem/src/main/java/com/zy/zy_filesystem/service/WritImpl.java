package com.zy.zy_filesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.zy_filesystem.dao.WritMapper;
import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.Writ;
import com.zy.zy_filesystem.service.impl.WritI;

/**  
*   
* 项目名称：bookSystem  
* 类名称：WritImpl  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年3月29日 下午2:46:55  
* 修改人：zhangyi  
* 修改时间：2019年3月29日 下午2:46:55  
* 修改备注：  
* @version   
*   
*/
@Service
public class WritImpl implements WritI {

	@Autowired
	private WritMapper writMapper;
	@Override
	public Result<Writ> getWritList() {

		List<Writ> l=writMapper.getWritList();
		Result<Writ> r=new Result<Writ>();
		r.setData(l);
		r.setMessage("查询成功");
		r.setStatus(0);
		r.setTotal(l.size());
		return r;
	}

}
