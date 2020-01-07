package com.example.websocket;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;


public class WebsocketApplicationTests {

    public MongoDatabase getconn() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        return mongoDatabase;
    }

    @Test
    public void contextLoads() {
        MongoDatabase mongoDatabase = getconn();
        MongoCollection<Document> c = mongoDatabase.getCollection("c1");
        FindIterable<Document> documents2 = c.find(Filters.or(Filters.eq("author", "罗贯中"), Filters.eq("name", "三国演义3333")));

        FindIterable<Document> documents3 = c.find(Filters.and(Filters.eq("author", "罗贯中"), Filters.eq("name", "三国演义3333")));
        MongoCursor<Document> iterator = documents3.iterator();
        while (iterator.hasNext()) {
            System.err.println(iterator.next());
        }
    }
}
