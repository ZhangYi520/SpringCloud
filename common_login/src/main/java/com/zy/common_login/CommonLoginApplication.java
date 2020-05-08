package com.zy.common_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CommonLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonLoginApplication.class, args);
    }

}
