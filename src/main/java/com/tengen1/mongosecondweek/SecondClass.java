package com.tengen1.mongosecondweek;

import com.mongodb.*;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/01/14
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class SecondClass {
    public static void main(String[] args) throws Exception{
        MongoClient client = new MongoClient();
        DB db = client.getDB("User");
        DBCollection hacker = db.getCollection("Hacker");
        hacker.drop();

        for(int i = 0; i <10; i ++){
            DBObject obj = new BasicDBObject();
            obj.put("x", new Random().nextInt(2));
            obj.put("y", new Random().nextInt(100));
            hacker.insert(obj);
        }
        DBCursor cursor = hacker.find();
        try {while (cursor.hasNext()){

            System.out.println(cursor.next());
        }    }finally {
            cursor.close();
        }
        DBObject query = new BasicDBObject("x", 0).append("y", new BasicDBObject("$gt", 10).append("$lt", 90));
        QueryBuilder builder = QueryBuilder.start("x").is(0)
                .and("y").greaterThan(10).lessThan(90);
        System.out.println(hacker.count(builder.get()));
        System.out.println(hacker.count());
    }
}
