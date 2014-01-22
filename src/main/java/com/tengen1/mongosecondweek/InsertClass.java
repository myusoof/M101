package com.tengen1.mongosecondweek;

import com.mongodb.*;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/01/14
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class InsertClass {
    public static void main(String[] args) throws Exception {
        MongoClient client = new MongoClient();
        DB db = client.getDB("User");
        DBCollection users = db.getCollection("users");

        DBObject doc = new BasicDBObject();
        DBObject doc2 = new BasicDBObject();
        doc.put("username", "yusoof");
        doc.put("password", "password");
        doc2.put("username", "yusoof1");
        doc2.put("password", "password");

        users.drop();
        System.out.println(doc);
        users.insert(Arrays.asList(doc, doc2));
        System.out.println(doc);
    }
}
