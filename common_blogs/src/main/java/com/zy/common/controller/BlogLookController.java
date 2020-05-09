package com.zy.common.controller;

import com.zy.common.Service.impl.BlogLookServiceImpl;
import com.zy.common.base.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloud
 * @description: 查看博客界面控制层
 * @author: zhang yi
 * @create: 2020-04-21 16:30
 */
@RestController
@RequestMapping("/blogLook")
public class BlogLookController {

    @Autowired
    private BlogLookServiceImpl blogLookServiceImpl;

    @GetMapping("/get")
    public ReturnResult blogLook(@RequestParam(value = "id",required = true) String id){
        return blogLookServiceImpl.blogLook(id);
    }
}
