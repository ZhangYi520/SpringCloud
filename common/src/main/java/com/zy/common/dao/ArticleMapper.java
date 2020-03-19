package com.zy.common.dao;

import com.zy.common.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}