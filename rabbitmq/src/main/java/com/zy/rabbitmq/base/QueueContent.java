package com.zy.rabbitmq.base;

/**
 * @program: SpringCloud
 * @description: 队列常量类
 * @author: zhang yi
 * @create: 2020-03-24 10:46
 */
public class QueueContent {
    /**
     * 普通消息通知队列名称
     */
    public static final String MESSAGE_QUEUE_NAME="message.ordinary.queue";

    /**
     * ttl(延时)消息通知队列名称
     */
    public static final String MESSAGE_TTL_QUEUE_NAME="message.ttl.queue";

    /**
     * 普通交换机名称
     */

    public static final String DIRECT_EXCHANGE_NAME="message.ordinary.exchange";


    /**
     * ttl(延时)交换机名称
     */
    public static final String TOPIC_EXCHANGE_NAME="message.ttl.exchange";

}
