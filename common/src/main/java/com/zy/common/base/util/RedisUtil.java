package com.zy.common.base.util;

import com.zy.common.Service.impl.DemoServiceImpl;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作工具类
 * @Author qiang
 * 2018年10月29日16:27:51
 */
@Component
public class RedisUtil{
    @Resource
    RedisTemplate<String, String> redisTemplate;

      public String get(String key) {
            if (StringUtils.isEmpty(key)) {
                  return null;
            }
            return redisTemplate.opsForValue().get(key);
      }
 
      public void set(String key, String value) {
            System.out.println("1:"+redisTemplate);
            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
                  return;
            }
            redisTemplate.opsForValue().set(key, value);
      }



}

