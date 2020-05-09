package com.zy.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.common.Service.impl.ArticleServiceImpl;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.vo.ArticleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ArticleServiceImpl articleServiceImpl;

//    @PostMapping("/add")
//    public ReturnResult add(@RequestParam("vo") String vo){
//        ArticleVo stu= JSON.parseObject(vo, ArticleVo.class);
//        log.info(stu.toString());
//        return articleServiceImpl.add(stu);
//    }

    @PostMapping("/add")
    @Transactional(readOnly = false)
    public ReturnResult add(@RequestBody ArticleVo vo){
//        ArticleVo stu= JSON.parseObject(vo, ArticleVo.class);
        log.info(vo.toString());
//        return null;
        ReturnResult returnResult = articleServiceImpl.saveArticle(vo);
//        ReturnResult returnResult=articleServiceImpl.demo();
        return returnResult;
    }
}
