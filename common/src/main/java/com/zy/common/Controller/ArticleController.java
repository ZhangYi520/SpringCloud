package com.zy.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.vo.ArticleVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: SpringCloud
 * @description: 文章
 * @author: zhang yi
 * @create: 2020-04-10 16:33
 */
@Controller
@RequestMapping("/article")
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)//就是这个注解
public class ArticleController {

    @PostMapping("/add")
    public ReturnResult add(@RequestParam("vo") String vo){
        ArticleVo stu= JSON.parseObject(vo, ArticleVo.class);
        System.out.println(stu.toString());
        return ReturnResult.ok();
    }
}
