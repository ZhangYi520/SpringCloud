package com.zy.common.serviceCall;

import com.alibaba.fastjson.JSON;
import com.zy.common.serviceCall.CallInterface.DemoInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 服务调用demo
 * @author: zhang yi
 * @create: 2020-04-27 16:24
 */
@Component
public class CallDemo {

    @Autowired
    DemoInter feign;

    public void demo(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","zy");
        map.put("age",12);

        String msg = feign.feignDemo(JSON.toJSONString(map));
        System.err.println(msg);
    }
}
