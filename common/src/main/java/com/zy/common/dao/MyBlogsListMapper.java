package com.zy.common.dao;

import com.zy.common.vo.MyBlogsListVo;

import java.util.List;

/**
 * @program: SpringCloud
 * @description: dao层
 * @author: zhang yi
 * @create: 2020-04-21 11:44
 */
public interface MyBlogsListMapper {
    /**我的博客界面 文章列表查询*/
    List<MyBlogsListVo> getList();
}
