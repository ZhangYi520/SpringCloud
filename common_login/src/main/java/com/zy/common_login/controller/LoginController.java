package com.zy.common_login.controller;

import com.zy.common_login.base.utils.JsonToMap;
import com.zy.common_login.base.utils.JsonUtil;
import com.zy.common_login.vo.LoginVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 登录服务 接口控制层
 * @author: zhang yi
 * @create: 2020-05-08 14:23
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private static String jsonStr = "{\"list\":[{\"aNum\":3,\"bNum\":1}],\"resCode\":\"0\",\"resMessage\":\"成功\"}";
    @PostMapping("/into")
    public String login(@RequestParam("vo") String vo){
        System.err.println(vo);

        Map<String, Object> stringObjectMap = JsonUtil.strJson2Map(jsonStr);
        System.out.println(stringObjectMap);
        System.out.println(stringObjectMap.get("list"));
        System.out.println(stringObjectMap.get("resCode"));
        System.out.println(stringObjectMap.get("resMessage"));
        List<Object> list =(List)stringObjectMap.get("list");


        return "json:"+vo;
    }
}
