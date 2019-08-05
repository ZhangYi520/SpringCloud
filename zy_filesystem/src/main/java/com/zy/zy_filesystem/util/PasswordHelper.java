package com.zy.zy_filesystem.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.zy.zy_filesystem.pojo.User;

/**  
*   
* 项目名称：bookSystem  
* 类名称：PasswordHelper  
* 类描述：  
* 创建人：zhangyi  
* 创建时间：2019年4月20日 下午8:26:03  
* 修改人：zhangyi  
* 修改时间：2019年4月20日 下午8:26:03  
* 修改备注：  
* @version   
*   
*/
public class PasswordHelper {
	//private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;

    public String encryptPassword(User user) {
        // User对象包含最基本的字段Username和Password
        user.setUserId(user.getUserId());//将用户名设置为盐
        // 将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，散列过程使用了盐
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),user.getUserId(), hashIterations).toHex();
        user.setPassword(newPassword);
        return newPassword;
    }
    
    public static void main(String[] args) {
    	User user = new User();
    	user.setUserId("zy");
    	user.setPassword("1234");
    	new PasswordHelper().encryptPassword(user);
    	System.out.println(user.getPassword());
	}
}
