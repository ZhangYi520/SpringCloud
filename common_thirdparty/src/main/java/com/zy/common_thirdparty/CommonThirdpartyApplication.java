package com.zy.common_thirdparty;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient
public class CommonThirdpartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonThirdpartyApplication.class, args);
    }

}
