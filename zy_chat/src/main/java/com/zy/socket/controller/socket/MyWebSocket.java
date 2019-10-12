package com.zy.socket.controller.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: SpringCloud
 * @description: websocket具体实现类
 * @author: zhang yi
 * @create: 2019-09-19 17:13
 */
@ServerEndpoint(value = "/websocket/{user}")
@Component
public class MyWebSocket {
    // 通过类似GET请求方式传递参数的方法（服务端采用第二种方法"WebSocketHandler"实现）
//    websocket = new WebSocket("ws://127.0.0.1:18080/testWebsocket?id=23&name=Lebron");
    /**
     * 在线人数
     */
    public static AtomicInteger onlineNumber = new AtomicInteger(0);

    /**
     * 所有的对象，每次连接建立，都会将我们自己定义的MyWebSocket存放到List中，
     */
    public static List<MyWebSocket> webSockets = new CopyOnWriteArrayList<MyWebSocket>();

    /**
     * 会话，与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 每个会话的用户
     */
    private String user;

    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user) {
        if (user == null || "".equals(user)) {
            try {
                session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        onlineNumber.incrementAndGet();
        for (MyWebSocket myWebSocket : webSockets) {
            if (user.equals(myWebSocket.user)) {
                try {
                    session.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
        }
        this.session = session;
        this.user = user;
        webSockets.add(this);
        System.out.println("有新连接加入！ 当前在线人数" + onlineNumber.get());
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber.decrementAndGet();
        webSockets.remove(this);
        System.out.println("有连接关闭！ 当前在线人数" + onlineNumber.get());
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("user") String user) {
        System.out.println("来自" + user + "消息：" + message);
        pushMessage(user, message, null);
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息推送
     *
     * @param message
     * @param uuid    uuid为空则推送全部人员
     */
    public static void pushMessage(String user, String message, String uuid) {
        if (uuid == null || "".equals(uuid)) {
            for (MyWebSocket myWebSocket : webSockets) {
                myWebSocket.sendMessage(user + ":" + message);
            }
        } else {
            for (MyWebSocket myWebSocket : webSockets) {
                if (uuid.equals(myWebSocket.user)) {
                    myWebSocket.sendMessage(message);
                }
            }
        }

    }

}
