package com.zy.rabbitmq.base;

/**
 * @program: SpringCloud
 * @description:
 * @author: zhang yi
 * @create: 2020-03-24 10:57
 */
public enum Action {

    ACCEPT,  // 处理成功
    RETRY,   // 可以重试的错误
    REJECT,  // 无需重试的错误
}
