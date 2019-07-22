package com.zy.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 草拟吗，代码结构终于改完了，狗日的
 */
@SpringBootApplication //spring-boot 启动注解
@EnableEurekaServer // spring-cloud 服务注解
//@EnableEurekaClient
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
