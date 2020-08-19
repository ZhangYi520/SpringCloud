package com.zy.common_thirdparty.controller;

import com.zy.common_thirdparty.base.Cons;
import com.zy.common_thirdparty.base.ReturnResult;
import com.zy.common_thirdparty.base.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 各种验证，如验证码、等
 * @author: zhang yi
 * @create: 2020-05-14 09:33
 */
@RestController
@RequestMapping("/check")
public class CheckController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/checkVcode")
    public ReturnResult checkVcode(@RequestBody Map<String,Object> map){
        String email = (String)map.get("email");
        String vcode = (String)map.get("vcode");
        String o = (String)redisUtil.get(Cons.REDIS_PREFIX.VCODE + email);
        if(o==null || "".equals(o)){
            return ReturnResult.error("未收到验证码或已过期，请重新发送！");
        }else if(!o.equals(vcode)){
            return ReturnResult.error("验证码错误！");
        }else if(o.equals(vcode)){
            return ReturnResult.ok("验证成功");
        }else{
            return ReturnResult.ok("异常");
        }
    }
}
