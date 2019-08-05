package com.zy.zy_filesystem.dao;

import java.util.List;

import com.zy.zy_filesystem.pojo.Writ;

/**  
*   
* 项目名称：bookSystem  
* 类名称：WritDao  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年3月29日 下午2:47:24  
* 修改人：zhangyi  
* 修改时间：2019年3月29日 下午2:47:24  
* 修改备注：  
* @version   
*   
*/
public interface WritMapper {

	public List<Writ> getWritList();
	
	public int saveWrit(Writ writ);

	public void deleteWrit(Integer id);
}
