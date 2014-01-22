package com.tengen1;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/01/14
 * Time: 19:40
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldMongoDBStyle {
    public static Object Id() throws Exception{
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost" ,27017));
        DB database = mongoClient.getDB("yusoof");
        DBCollection collection = database.getCollection("products");
        return collection.findOne().get("_id");
    }
}
