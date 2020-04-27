package com.zy.common.serviceCall.CallInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 服务调用接口(入口)
 * @author: zhang yi
 * @create: 2020-04-27 16:28
 */
@Service
@FeignClient(value = "spring-cloud-common-thirdparty")
public interface DemoInter {

    @GetMapping("/demo")
    String feignDemo(@RequestParam(value = "json")String json);
}
