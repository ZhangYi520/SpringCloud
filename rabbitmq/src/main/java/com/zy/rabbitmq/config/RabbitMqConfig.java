package com.zy.rabbitmq.config;

import com.zy.rabbitmq.base.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: SpringCloud
 * @description: mq配置类
 * @author: zhang yi
 * @create: 2019-08-12 16:17
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    /**
     * 普通消息交换机配置
     *
     * @return
     */
    @Bean
    DirectExchange messageDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.MESSAGE_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 延时消息交换机配置
     *
     * @return
     */
    @Bean
    DirectExchange messageTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.MESSAGE_TTL_QUEUE.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 普通消息队列配置
     *
     * @return
     */
    @Bean
    public Queue messageQueue() {
        return new Queue(QueueEnum.MESSAGE_QUEUE.getName());
    }


    /**
     * TTL消息队列配置
     *
     * @return
     */
    @Bean
    Queue messageTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.MESSAGE_TTL_QUEUE.getName())
                // 配置到期后转发的交换
                .withArgument("x-dead-letter-exchange", QueueEnum.MESSAGE_QUEUE.getExchange())
                // 配置到期后转发的路由键
                .withArgument("x-dead-letter-routing-key", QueueEnum.MESSAGE_QUEUE.getRouteKey())
                .build();
    }

    /**
     * 普通队列和普通交换机的绑定-routekey
     *
     * @param messageDirect 消息中心交换配置
     * @param messageQueue  消息中心队列
     * @return
     */
    @Bean
    Binding messageBinding(DirectExchange messageDirect, Queue messageQueue) {
        return BindingBuilder
                .bind(messageQueue)
                .to(messageDirect)
                .with(QueueEnum.MESSAGE_QUEUE.getRouteKey());
    }

    /**
     * ttl队列和ttl交换机的绑定-routekey
     *
     * @param messageTtlQueue
     * @param messageTtlDirect
     * @return
     */
    @Bean
    public Binding messageTtlBinding(Queue messageTtlQueue, DirectExchange messageTtlDirect) {
        return BindingBuilder
                .bind(messageTtlQueue)
                .to(messageTtlDirect)
                .with(QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey());
    }

}
