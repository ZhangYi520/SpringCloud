package com.zy.common.dao;

import com.zy.common.entity.ArticleLabel;

import java.util.List;

public interface ArticleLabelMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleLabel record);

    int insertSelective(ArticleLabel record);

    ArticleLabel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleLabel record);

    int updateByPrimaryKey(ArticleLabel record);

    /**
     * 批量插入
     * @param labels
     */
    void insertAll(List<ArticleLabel> labels);
}