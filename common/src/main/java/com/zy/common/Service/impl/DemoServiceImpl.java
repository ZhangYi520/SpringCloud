package com.zy.common.Service.impl;

import com.zy.common.Service.DemoService;
import com.zy.common.dao.UserMapper;
import com.zy.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String uuid) {
        return userMapper.selectByPrimaryKey(uuid);
    }
}
