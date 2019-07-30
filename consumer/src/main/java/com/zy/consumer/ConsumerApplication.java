package com.zy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //Eureka 客户端，只适用于Eureka作为注册中心，和下面那个用法一样
@EnableDiscoveryClient //Eureka 客户端，注册中心是其他的，不只是Eureka
@EnableFeignClients //开启Feign的功能
@EnableHystrix
@EnableHystrixDashboard//开启熔断仪表盘
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
