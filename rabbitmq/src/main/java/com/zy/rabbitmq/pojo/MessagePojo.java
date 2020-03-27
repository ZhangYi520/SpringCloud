package com.zy.rabbitmq.pojo;

import lombok.Data;
import java.io.Serializable;
import java.util.Map;

/**
 * @program: SpringCloud
 * @description: 消息实体类
 * @author: zhang yi
 * @create: 2020-03-24 10:49
 */
@Data
public class MessagePojo implements Serializable {

    //定时过期时间（单位：秒）马上消费,设置为0
    private int delay;

    //处理类名（必填项）
    private String className;

    //消息参数
    private Map<String, Object> params;

    private String createTime;

    private String messageId;

    public MessagePojo() {

    }

    public MessagePojo(int delay, String className,Map<String, Object> params) {
        this.delay = delay;
        this.className = className;
        this.params = params;
    }


}


