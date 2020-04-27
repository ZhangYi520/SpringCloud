package com.zy.common.controller;

import com.zy.common.Service.impl.MyBlogsListServiceImpl;
import com.zy.common.base.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: SpringCloud
 * @description: 我的博客列表界面
 * @author: zhang yi
 * @create: 2020-04-21 11:32
 */
@RestController
@RequestMapping("/myBlogsList")
public class MyBlogsListController {

    @Autowired
    private MyBlogsListServiceImpl myBlogsListServiceImpl;

    @GetMapping("/getList")
    public ReturnResult getList(@RequestParam(name = "page",required = false) Integer page,
                                @RequestParam(name = "pageSize",required = false) Integer pageSize){
        page=page==null?0:page;
        pageSize=pageSize==null?0:pageSize;
        return myBlogsListServiceImpl.getList(page,pageSize);
    }
}
