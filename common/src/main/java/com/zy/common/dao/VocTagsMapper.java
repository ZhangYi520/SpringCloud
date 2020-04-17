package com.zy.common.dao;

import com.zy.common.entity.VocTags;

import java.util.List;

public interface VocTagsMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(VocTags record);

    int insertSelective(VocTags record);

    VocTags selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(VocTags record);

    int updateByPrimaryKey(VocTags record);

    /**
     * 插入标签表，id存在则不插入
     * @param tags
     */
    void insertNotExist(List<VocTags> tags);

    /**
     * 查询所有标签
     * @return
     */
    List<VocTags> getAll();
}