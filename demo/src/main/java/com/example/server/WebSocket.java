package com.example.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@ServerEndpoint("/webSocket/{username}")
public class WebSocket {
    private static Map<String, Session> sessionMap = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessionMap.put(username, session);
        System.err.println("有新的连接，总数为" + sessionMap.size());
    }

    @OnClose
    public void onClose(Session session) {
        for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
            if (entry.getValue() == session) {
                sessionMap.remove(entry.getKey());
                break;
            }
        }
        System.err.println("断开连接了，总数为" + sessionMap.size());
    }

    @SuppressWarnings("AlibabaSwitchStatement")
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            HashMap hashMap = new ObjectMapper().readValue(message, HashMap.class);
            String type = hashMap.get("type").toString();
            String info = hashMap.get("info").toString();
            System.err.println("消息为" + info);
            switch (type) {
                case "0":
                    System.err.println("群聊");
                    send(info);
                    break;
                case "1":
                    String toUser = hashMap.get("toUser").toString();
                    System.err.println("私聊");
                    privateSend(toUser, info);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //send(message);
    }

    /**
     * 群聊
     *
     * @author YL
     * @date 11:02 2019/7/8
     */
    public void send(String message) {
        for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
            try {
                entry.getValue().getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 私聊
     *
     * @author YL
     * @date 11:11 2019/7/8
     */
    public void privateSend(String toUser, String message) {
        try {
            sessionMap.get(toUser).getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
