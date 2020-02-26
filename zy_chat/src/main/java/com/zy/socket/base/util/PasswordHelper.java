package com.zy.socket.base.util;


import com.zy.socket.entity.User;
import org.apache.shiro.crypto.hash.SimpleHash;


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
	private static final int hashIterations = 2;

	public static String encryptPassword(User e) {
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String newPassword = new SimpleHash(algorithmName,e.getPassword(),e.getName(),hashIterations).toHex();
		//String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
		e.setPassword(newPassword);
		return newPassword;
	}
	public static void main(String[] args) {
		User user = new User();
		user.setName("zy");
		user.setPassword("1234");
		PasswordHelper.encryptPassword(user);
		System.out.println(user.toString());
	}
}
