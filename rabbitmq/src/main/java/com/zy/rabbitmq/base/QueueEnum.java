package com.zy.rabbitmq.base;

import lombok.Getter;

/**
 * @program: SpringCloud
 * @description: 队列枚举类
 * @author: zhang yi
 * @create: 2020-03-24 10:46
 */
@Getter
public enum QueueEnum {

    /**
     * 消息通知队列
     */
    MESSAGE_QUEUE(QueueContent.DIRECT_EXCHANGE_NAME, QueueContent.MESSAGE_QUEUE_NAME, QueueContent.MESSAGE_QUEUE_NAME),
    /**
     * 消息通知ttl队列
     */
    MESSAGE_TTL_QUEUE(QueueContent.TOPIC_EXCHANGE_NAME, QueueContent.MESSAGE_TTL_QUEUE_NAME, QueueContent.MESSAGE_TTL_QUEUE_NAME);
    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }

}

