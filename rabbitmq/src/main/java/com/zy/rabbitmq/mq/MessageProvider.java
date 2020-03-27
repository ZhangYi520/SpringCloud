package com.zy.rabbitmq.mq;

import com.alibaba.fastjson.JSON;
import com.zy.rabbitmq.base.QueueEnum;
import com.zy.rabbitmq.pojo.MessagePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @program: SpringCloud
 * @description: 消息提供者
 * @author: zhang yi
 * @create: 2020-03-24 10:49
 */

@Component
public class MessageProvider implements RabbitTemplate.ConfirmCallback {

    static Logger logger = LoggerFactory.getLogger(MessageProvider.class);

    /**
     * RabbitMQ 模版消息实现类
     */
    protected RabbitTemplate rabbitTemplate;

    public MessageProvider(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMandatory(true);
        this.rabbitTemplate.setConfirmCallback(this);
    }

    private String msgPojoStr;

    /**
     * 发送延迟消息
     *
     * @param messageContent
     */
    public void sendMessage(MessagePojo messageContent) {
        if (messageContent != null) {
            //这里用于消费者消费消息的时候处理具体业务
            if (StringUtils.isEmpty(messageContent.getClassName())) {
                logger.error("处理业务的类名不能为空");
                return;
            }

            messageContent.setMessageId(UUID.randomUUID().toString());
            messageContent.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            String msg = JSON.toJSONString(messageContent);
            msgPojoStr = msg;
            logger.info("延迟：{}秒写入消息队列：{}，消息内容：{}", messageContent.getDelay(), QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(), msg);
            // 执行发送消息到指定队列
            CorrelationData correlationData = new CorrelationData(messageContent.getMessageId());
            rabbitTemplate.convertAndSend(QueueEnum.MESSAGE_TTL_QUEUE.getExchange(), QueueEnum.MESSAGE_TTL_QUEUE.getRouteKey(), msg, message -> {
                // 设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(messageContent.getDelay() * 1000));
                return message;
            }, correlationData);
        } else {
            logger.warn("消息内容为空！！！！！");
        }

    }

    /**
     * 发送确认
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println(" 回调id:" + correlationData);
        if (b) {
            System.out.println(msgPojoStr + ":消息发送成功");
        } else {
            logger.warn(msgPojoStr + ":消息发送失败:" + s);
        }
    }
}