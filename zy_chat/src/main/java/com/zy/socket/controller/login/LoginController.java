package com.zy.socket.controller.login;

import com.zy.socket.base.result.CodeMsg;
import com.zy.socket.base.result.Result;
import com.zy.socket.entity.User;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: SpringCloud
 * @description: 登录控制器
 * @author: zhang yi
 * @create: 2019-10-10 16:54
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @PostMapping("/login")
    @ResponseBody
    public Object demo(@RequestBody  User user) {
        System.out.println("登录用户："+user.getUserName());
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try {
//            token.setRememberMe(true);
            //这里
            subject.login(token);

//            Result<UserEntity> result = userServiceImpl.queryUserByUserName(user.getUserName());
//            UserEntity userEntity=result.getData();
////	        String tokenId = (String) subject.getSession().getId();
//            String tokenId = JWTUtil.sign(userEntity.getUserName(), userEntity.getPassword());
//            System.out.println("当前登录用户的sessionId:"+tokenId);
//            userEntity.setToken(tokenId);
//            userEntity.setPassword(null);
//            //把用户信息保存进redis，采用hash
//            RedisTemplateUtil.redisTemplate.opsForHash().put("login:",user.getUserName(),userEntity);
//            log.info("成功写入缓存:"+userEntity.toString());
////			subject.getSession().setAttribute("user", userEntity);

//            return Result.success(userEntity);

        }catch (Exception e) {
            e.printStackTrace();
            return Result.error(CodeMsg.BASE_SERVER_ERROR);
        }
        return Result.success();
    }
    @GetMapping("/main")
    public String tomain(){
        return "main";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
