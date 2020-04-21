package com.zy.common.Service.impl;

import com.zy.common.Service.BlogLookService;
import com.zy.common.dao.BlogLookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: SpringCloud
 * @description: 查看博客service层
 * @author: zhang yi
 * @create: 2020-04-21 16:32
 */
@Service
public class BlogLookServiceImpl implements BlogLookService {

    @Autowired
    private BlogLookMapper blogLookMapper;
    @Override
    public Object blogLook(String id) {
        blogLookMapper.blogLook(id);
        return null;
    }
}
