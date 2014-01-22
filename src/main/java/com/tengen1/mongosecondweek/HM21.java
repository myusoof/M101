package com.tengen1.mongosecondweek;

import com.mongodb.*;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 19/01/14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class HM21 {
    public static void main(String[] args) throws Exception {
        MongoClient client = new MongoClient();
        DB database = client.getDB("students");
        DBCollection grades = database.getCollection("grades");

        DBCursor cur1 = grades.find(new BasicDBObject("type", "homework")).
                sort(new BasicDBObject("student_id", 1).append("score", 1));
        //DBCursor cur1 = cur.sort(new BasicDBObject("student", 1));
        DBCursor cur2 = grades.find(new BasicDBObject("type", "homework")).
                sort(new BasicDBObject("score",1));
        cur2.sort(new BasicDBObject("student_id", 1));
        System.out.println(cur1);
        System.out.println(cur2);
        assert cur1 == cur2;
        try {

            while(cur1.hasNext()){
                System.out.println(cur1.next());
            }
            /*while (cur1.hasNext()) {
                DBObject document1 = cur1.next();
                DBObject document2 = cur1.next();
                if (document1.get("student_id").equals(document2.get("student_id"))) {
                    Double score1 = (Double) document1.get("score");
                    Double score2 = (Double) document2.get("score");
                    int val = Double.compare(score1, score2);
                    if (val < 0) {
                        grades.remove(document1);
                    } else {
                        grades.remove(document2);
                    }
                }
            }*/
            System.out.println(cur1.count());
        } finally {
            cur1.close();
        }
        System.out.println("------------------------------------");
        try {
            while (cur2.hasNext()){
                System.out.println(cur2.next());
            }
        }finally {
            cur2.close();
        }
    }
}
