package com.zy.rabbitmq.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.rabbitmq.tools.json.JSONUtil;
import com.zy.rabbitmq.base.Action;
import com.zy.rabbitmq.base.QueueContent;
import com.zy.rabbitmq.base.util.SpringContextUtil;
import com.zy.rabbitmq.pojo.MessagePojo;
import com.zy.rabbitmq.service.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: SpringCloud
 * @description: 消息消费者类
 * @author: zhang yi
 * @create: 2020-03-24 10:55
 */
@Component
@RabbitListener(queues = QueueContent.MESSAGE_QUEUE_NAME)
public class MessageConsumer {

    static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

//    @RabbitHandler
//    public void handler(String hello) {
//        System.out.println("Receiver : "+ hello);
//    }

    @RabbitHandler
    public void handler(String msg, Channel channel, Message message) throws IOException {
        if (!StringUtils.isEmpty(msg)) {
            MessagePojo messagePojo = JSONObject.parseObject(msg, MessagePojo.class);
            Action action = Action.RETRY;
            try {
                //这里使用策略模式和springboot的结合使用，
                Strategy s =  (Strategy) SpringContextUtil.getBean(messagePojo.getClassName());
                s.doJob(messagePojo.getParams());
                channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
                logger.info("[MessageConsumer延时消息消费时间]"+new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + JSON.toJSONString(messagePojo) + ",消息ID：" + messagePojo.getMessageId());
                action = Action.ACCEPT;
            } catch (Exception e) {
                logger.error("确认消费异常",e);
                //记录下这条消息
//                redisService.hmSet("failedMsg",messagePojo.getMessageId(),msg);
                action = Action.RETRY;
            }finally {
                // 通过finally块来保证Ack/Nack会且只会执行一次
                if (action == Action.ACCEPT) {
                    channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
                } else if (action == Action.RETRY) {
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                } else {
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                }

            }

        }
    }


}

