package com.tengen1.mongosecondweek;

import com.mongodb.*;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/01/14
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */
public class FindClass {
    public static void main(String[] args) throws Exception{
        MongoClient client = new MongoClient();
        DB db = client.getDB("User");
        DBCollection users = db.getCollection("users");
        users.drop();

        DBObject doc = new BasicDBObject();
        DBObject doc2 = new BasicDBObject();
        doc.put("username", "yusoof");
        doc.put("password", "password");
        doc2.put("username", "yusoof1");
        doc2.put("password", "password");
        users.insert(Arrays.asList(doc, doc2));
        System.out.println("find one");
        DBObject obj = users.findOne();
        System.out.println(obj);

        System.out.println("find all");
        DBCursor cursor = users.find();
        try {
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }
        }finally{
            cursor.close();
            }

        System.out.println("count the document");
        System.out.println(users.count());

    }

}
