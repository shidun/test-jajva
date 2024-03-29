package com.imooc.testjava.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
@ServerEndpoint("/webSocket")
public class WebSocket {

    private Session session;

    ///线程安全数组
    private static CopyOnWriteArrayList<WebSocket> webSocketSet = new CopyOnWriteArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【websocket消息】有新的连接，总数：{}", webSocketSet.size());
    }

    @OnClose
    public void OnClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】 连接断开，总数：{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】 收到客户端消息：{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            log.info("【webscoket】 广播消息：{}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
