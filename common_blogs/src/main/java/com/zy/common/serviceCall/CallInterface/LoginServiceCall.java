package com.zy.common.serviceCall.CallInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: SpringCloud
 * @description: 登录服务调用接口(入口)
 * @author: zhang yi
 * @create: 2020-5-8 14:22:18
 */
@Service
@FeignClient(value = "spring-cloud-common-login")
public interface LoginServiceCall {

    @PostMapping("/sso/login/into")
    public String login(@RequestParam("vo") String vo);
}
