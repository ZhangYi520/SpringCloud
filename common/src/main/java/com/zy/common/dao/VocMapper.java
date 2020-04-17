package com.zy.common.dao;

import com.zy.common.entity.User;
import com.zy.common.entity.Voc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VocMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Voc record);

    int insertSelective(Voc record);

    Voc selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Voc record);

    int updateByPrimaryKey(Voc record);

    /**
     * 根据vocCode获取当前分类旗下的所有子分类
     * @param vocCode 分类代码
     * @return
     */
    List<Voc> getSonListByVocCode(@Param("code") String vocCode);
}