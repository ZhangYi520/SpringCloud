package com.zy.zy_sso.base.util;


import org.apache.shiro.crypto.hash.SimpleHash;

import com.zy.zy_sso.entity.UserEntity;



/**
 * 
 **************************************************
 * @Description:后台密码util
 * @author:ZY
 * @date:2019年01月14日
 **************************************************
 */
public class PasswordHelper {
	private static final String algorithmName = "md5";
	private static final int hashIterations = 1;

	public static String encryptPassword(UserEntity e) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName,e.getPassword(),e.getUserName(),hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		e.setPassword(newPassword);
		return newPassword;
	}
	public static void main(String[] args) {
		UserEntity user = new UserEntity();
		user.setUserName("zy");
		user.setPassword("1234");
		PasswordHelper.encryptPassword(user);
		System.out.println(user.toString());
	}
}
