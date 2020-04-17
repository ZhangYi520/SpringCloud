package com.zy.common.dao;

import com.zy.common.base.util.ReturnResult;
import com.zy.common.entity.Article;
import org.apache.ibatis.annotations.Insert;

public interface ArticleMapper {
    @Insert("insert into article(uuid,title) values('1','2222')")
    ReturnResult testq();

    int deleteByPrimaryKey(String uuid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}