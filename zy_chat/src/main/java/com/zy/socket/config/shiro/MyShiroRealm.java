//package com.zy.socket.config.shiro;
//
//import com.zy.socket.entity.User;
//import lombok.Data;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**  
//*   
//* 项目名称：bookSystem  
//* 类名称：UserRealm  
//* 类描述：  
//* 创建人：zhangyi  
//* 创建时间：2019年4月20日 下午9:05:03  
//* 修改人：zhangyi  
//* 修改时间：2019年4月20日 下午9:05:03  
//* 修改备注：  
//* @version   
//*   
//*/
//public class MyShiroRealm extends AuthorizingRealm{
//	// 用户对应的角色信息与权限信息都保存在数据库中，通过UserService获取数据
////	@Autowired
////    private UserManageService userService;
////	@Autowired
////    private UserMapper userMapper;
//    /**
//     * 提供用户信息返回权限信息
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//    	System.out.println("进入shiro权限认证。。");
//        String userId = (String) principals.getPrimaryPrincipal();
//        System.out.println("进入shiro权限认证。。");
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        // 根据用户名查询当前用户拥有的角色
//
////        User user=userMapper.queryUserByUserName(userId);
////        authorizationInfo.addRole(user.getRole().getRoleName());//设置角色名称
//        authorizationInfo.addRole("role");//设置角色名称
////        user.getRole().getAction().stream().forEach(Action->{
////        	authorizationInfo.addStringPermission(Action.getActionDesc());
////        });
//        authorizationInfo.addStringPermission("permission");
//
//        return authorizationInfo;
//    }
//
//    /**
//     * 提供账户信息返回认证信息
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//    	System.out.println("进入用户认证信息");
//    	if (token.getPrincipal() == null) {
//            return null;
//        }
//        String userId = (String) token.getPrincipal();
////        User user=
//        User user =new User();
//        user.setName("zy");
//        user.setPassword("84cf6dca79368f77c46fb7630507f0d9");
////        if (user == null) {
////            // 用户名不存在抛出异常
////            throw new UnknownAccountException();
////        }
////        if (user.getLocked() == 0) {
////            // 用户被管理员锁定抛出异常
////            throw new LockedAccountException();
////        }
//        ByteSource salt = ByteSource.Util.bytes(user.getName());
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//        		user,
//                user.getPassword(),
//                salt,
//                getName());
//        return authenticationInfo;
//    }
//
//}
