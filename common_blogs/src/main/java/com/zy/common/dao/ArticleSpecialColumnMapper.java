package com.zy.common.dao;

import com.zy.common.entity.Article;
import com.zy.common.entity.ArticleSpecialColumn;

import java.util.List;

public interface ArticleSpecialColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleSpecialColumn record);

    int insertSelective(ArticleSpecialColumn record);

    ArticleSpecialColumn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleSpecialColumn record);

    int updateByPrimaryKey(ArticleSpecialColumn record);

    /**
     * 批量插入
     * @param sc
     */
    void insertAll(List<ArticleSpecialColumn> sc);
}