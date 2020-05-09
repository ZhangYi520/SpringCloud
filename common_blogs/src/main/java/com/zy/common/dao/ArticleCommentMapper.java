package com.zy.common.dao;

import com.zy.common.entity.ArticleColleat;
import com.zy.common.entity.ArticleComment;

public interface ArticleCommentMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ArticleComment record);

    int insertSelective(ArticleComment record);

    ArticleComment selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ArticleComment record);

    int updateByPrimaryKeyWithBLOBs(ArticleComment record);

    int updateByPrimaryKey(ArticleComment record);
}