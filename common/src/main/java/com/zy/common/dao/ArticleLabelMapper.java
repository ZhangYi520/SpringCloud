package com.zy.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zy.common.entity.ArticleLabel;

public interface ArticleLabelMapper extends BaseMapper<ArticleLabel> {
    int deleteByPrimaryKey(String id);

    int insert(ArticleLabel record);

    int insertSelective(ArticleLabel record);

    ArticleLabel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleLabel record);

    int updateByPrimaryKey(ArticleLabel record);
}