package com.zy.zy_sso.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zy.zy_sso.entity.Menu;

@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
    List<Menu> selectList();
}