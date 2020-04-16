package com.zy.common.dao;

import com.zy.common.entity.ArticleSpecialColumn;

public interface ArticleSpecialColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleSpecialColumn record);

    int insertSelective(ArticleSpecialColumn record);

    ArticleSpecialColumn selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleSpecialColumn record);

    int updateByPrimaryKey(ArticleSpecialColumn record);
}