package com.zy.common.Service.impl;

import com.zy.common.Service.BlogLookService;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.dao.BlogLookMapper;
import com.zy.common.vo.ArticleLookVo;
import com.zy.common.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    public ReturnResult blogLook(String id) {
        Map<String,Object> map=new HashMap<>();
        blogLookMapper.addRedNum(id);
        ArticleLookVo article=blogLookMapper.blogLook(id);
        map.put("article",article);
        return ReturnResult.ok(map);
    }
}
