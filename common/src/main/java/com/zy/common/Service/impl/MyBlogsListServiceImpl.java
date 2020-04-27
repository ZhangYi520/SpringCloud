package com.zy.common.Service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zy.common.Service.MyBlogsListService;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.dao.MyBlogsListMapper;
import com.zy.common.vo.MyBlogsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: SpringCloud
 * @description: 我的博客列表界面service层
 * @author: zhang yi
 * @create: 2020-04-21 11:43
 */
@Service
public class MyBlogsListServiceImpl implements MyBlogsListService {

    @Autowired
    private MyBlogsListMapper myBlogsListMapper;

    @Override
    public ReturnResult getList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<MyBlogsListVo> list=myBlogsListMapper.getList();
        PageInfo<MyBlogsListVo> shopPageInfo = new PageInfo<>(list);
        return ReturnResult.ok(shopPageInfo);
    }
}
