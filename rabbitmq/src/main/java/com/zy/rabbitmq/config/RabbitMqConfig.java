package com.zy.rabbitmq.config;

import org.springframework.amqp.core.Queue;
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
}
