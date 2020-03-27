package com.zy.rabbitmq.service.impl;

import com.zy.rabbitmq.service.Strategy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: SpringCloud
 * @description:
 * @author: zhang yi
 * @create: 2020-03-24 10:59
 */

@Component("A")
public class A implements Strategy {

    /**
     * @param params 接口所需参数
     */
    @Override
    public void doJob(Map<String, Object> params) {
        System.out.println("用A方法处理");
    }

}
