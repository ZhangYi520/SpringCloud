package com.zy.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: SpringCloud
 * @description: 消息管理实现类
 * @author: zhang yi
 * @create: 2019-09-19 17:11
 */
@Controller
public class WebsocketMsgController {

    @GetMapping("/index")
    public void index(String uuid) {
        MyWebSocket.pushMessage("群主", "你们好", uuid);
    }
}
