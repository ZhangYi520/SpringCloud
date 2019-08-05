package com.zy.zy_filesystem.service.impl;

import org.springframework.stereotype.Service;

import com.zy.zy_filesystem.pojo.Result;
import com.zy.zy_filesystem.pojo.Writ;

/**  
*   
* 项目名称：bookSystem  
* 类名称：WritI  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年3月29日 下午2:46:03  
* 修改人：zhangyi  
* 修改时间：2019年3月29日 下午2:46:03  
* 修改备注：  
* @version   
*   
*/
@Service
public interface WritI {
	
	public Result<Writ> getWritList();
}
