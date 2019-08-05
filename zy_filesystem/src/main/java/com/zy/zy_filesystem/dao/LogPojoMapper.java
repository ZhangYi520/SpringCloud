package com.zy.zy_filesystem.dao;
/**  
*   
* 项目名称：bookSystem  
* 类名称：LogPojoMapper  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年2月14日 下午2:30:55  
* 修改人：zhangyi  
* 修改时间：2019年2月14日 下午2:30:55  
* 修改备注：  
* @version   
*   
*/

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zy.zy_filesystem.pojo.LogPojo;
import com.zy.zy_filesystem.pojo.User;

public interface LogPojoMapper {
	//查询数量
	public Integer count();
	//查询
	public List<LogPojo> queryLogPojo(@Param("s") Integer s,@Param("e") Integer e);
	//插入
	public Integer insertLogPojo(LogPojo logPojo);
	//删除
	public Integer delLogPojo(Integer id);
	//批量删除
	public Integer delLogPojoAll(List<LogPojo> logPojoList);
}
