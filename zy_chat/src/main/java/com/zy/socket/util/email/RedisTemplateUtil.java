package com.zy.socket.util.email;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//RedisTemplate实例化类，这个类是单例的，所以得这样实例化
@Component
public class RedisTemplateUtil {

	public static RedisTemplate<String, Object> redisTemplate;
	
	@Resource
	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		RedisTemplateUtil.redisTemplate = redisTemplate;
	}
}
