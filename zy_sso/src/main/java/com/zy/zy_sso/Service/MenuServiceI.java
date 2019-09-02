package com.zy.zy_sso.Service;

import java.util.List;

import com.zy.zy_sso.base.result.Result;
import com.zy.zy_sso.entity.Menu;

public interface MenuServiceI {
	//根据用户名查询当前用户的角色信息
	Result<List<Menu>> selectList(String userName);

}
