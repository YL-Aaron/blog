package com.example.listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.example.bean.ClientInfo;
import com.example.bean.MessageInfo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class MessageEventHandler {
    private final SocketIOServer server;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        this.server = server;
    }

    public MongoDatabase getconn(){
        MongoClient mongoClient=new MongoClient();
        MongoDatabase mongoDatabase=mongoClient.getDatabase("test");
        return mongoDatabase;
    }

    @OnConnect
    public void onConnect(SocketIOClient client){
        String clientId=client.getHandshakeData().getSingleUrlParam("clientid");
        MongoDatabase mongoDatabase=getconn();
        MongoCollection<Document> c = mongoDatabase.getCollection("clientInfo");
        FindIterable<Document> documents=c.find(Filters.eq("clientId", clientId));
        MongoCursor<Document> iterator=documents.iterator();
        if (iterator.hasNext()){
            Date nowTime=new Date(System.currentTimeMillis());
            /*Document d1=new Document();
            d1.append("clientId",clientId).append("connected", 1).append("mostsignbits", client.getSessionId().getMostSignificantBits()).append("leastsignbits", client.getSessionId().getLeastSignificantBits()).append("lastconnecteddate", nowTime);
            c.insertOne(d1);*/
            Map<String,Object> map=new HashMap<>();
            map.put("connected", 1);
            map.put("mostsignbits", client.getSessionId().getMostSignificantBits());
            map.put("leastsignbts", client.getSessionId().getLeastSignificantBits());
            map.put("lastconnecteddate", nowTime);
            c.updateOne(Filters.eq("clientId",clientId), new Document("$set",new Document(map)));
        }
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client){
        String clientId=client.getHandshakeData().getSingleUrlParam("clientid");
        MongoDatabase mongoDatabase=getconn();
        MongoCollection<Document> c = mongoDatabase.getCollection("clientInfo");
        FindIterable<Document> documents=c.find(Filters.eq("clientId", clientId));
        MongoCursor<Document> iterator=documents.iterator();
        if (iterator.hasNext()){
            Map<String,Object> map=new HashMap<>();
            map.put("connected",0);
            map.put("mostsignbits",null);
            map.put("leastsignbits",null);
            c.updateOne(Filters.eq("clientId", clientId), new Document("$set",new Document("name",map)));
        }
    }

    @OnEvent(value = "messageEvent")
    public void onEvent(SocketIOClient client, AckRequest request, MessageInfo data){
        String targetClientId=data.getTargetClientId();
        Query query=new Query(Criteria.where("clientId").is(targetClientId));
        ClientInfo clientInfo = mongoTemplate.findOne(query, ClientInfo.class);


        if (clientInfo!=null&&clientInfo.getConnected()!=0){
            UUID uuid=new UUID(clientInfo.getMostsignbits(),clientInfo.getLeastsignbts());
            System.out.println(uuid.toString());
            MessageInfo sendData=new MessageInfo();
            sendData.setSourceClientId(data.getSourceClientId());
            sendData.setTargetClientId(data.getTargetClientId());
            sendData.setMsgType("chat");
            sendData.setMsgContent(data.getMsgContent());
            client.sendEvent("messageEvent", sendData);
            server.getClient(uuid).sendEvent("messageEvent",sendData);
        }
    }
}
