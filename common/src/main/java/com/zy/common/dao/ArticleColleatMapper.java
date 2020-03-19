package com.zy.common.dao;

import com.zy.common.entity.ArticleColleat;

public interface ArticleColleatMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ArticleColleat record);

    int insertSelective(ArticleColleat record);

    ArticleColleat selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ArticleColleat record);

    int updateByPrimaryKey(ArticleColleat record);
}