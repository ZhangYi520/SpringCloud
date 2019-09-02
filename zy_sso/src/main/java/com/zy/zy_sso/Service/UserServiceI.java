package com.zy.zy_sso.Service;

import java.util.List;

import com.zy.zy_sso.base.result.Result;
import com.zy.zy_sso.vo.UserPara;
import com.zy.zy_sso.entity.UserEntity;

public interface UserServiceI {
	
	/** 根据用户名获取用户所有信息
	 * @param name
	 * @return 
	 */
	public Result<UserEntity> queryUserByUserName(String name);

	/**查询用户列表
	 * @return
	 */
	Result<List<UserEntity>> getUserList(UserPara u);
}
