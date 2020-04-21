package com.zy.common.Service.impl;

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
        List<MyBlogsListVo> list=myBlogsListMapper.getList();
        return ReturnResult.ok(list);
    }
}
