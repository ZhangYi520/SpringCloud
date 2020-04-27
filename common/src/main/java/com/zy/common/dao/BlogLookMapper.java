package com.zy.common.dao;

import com.zy.common.vo.ArticleLookVo;
import com.zy.common.vo.ArticleVo;
import org.apache.ibatis.annotations.Param;

/**
 * @program: SpringCloud
 * @description: 查看博客dao层
 * @author: zhang yi
 * @create: 2020-04-21 16:31
 */
public interface BlogLookMapper {
    /**查看博客内容*/
    ArticleLookVo blogLook(@Param("uuid") String id);

    /**阅读数+1*/
    void addRedNum(String id);
}
