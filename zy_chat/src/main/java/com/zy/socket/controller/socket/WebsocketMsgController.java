package com.zy.socket.controller.socket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: SpringCloud
 * @description: 消息管理实现类
 * @author: zhang yi
 * @create: 2019-09-19 17:11
 */
@Controller
public class WebsocketMsgController {

    @GetMapping("/qunzhu")
    public void index(String uuid) {
        MyWebSocket.pushMessage("群主", "你们好", uuid);
    }
}
