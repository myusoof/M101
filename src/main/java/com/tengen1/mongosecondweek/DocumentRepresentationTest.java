package com.tengen1.mongosecondweek;

import com.mongodb.BasicDBObject;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 18/01/14
 * Time: 22:32
 * To change this template use File | Settings | File Templates.
 */
public class DocumentRepresentationTest {
    public static void main(String[] args) {
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("username", "yusoof") ;
        basicDBObject.put("age", "28") ;
        basicDBObject.put("profession", "Tester") ;
        basicDBObject.put("toolknown", Arrays.asList("Selenium", "RestClient", "grinder", "QTP") );
        basicDBObject.put("subdoc", new BasicDBObject("street", "20 foundry country")
               .append("postcode", "SL2 5FY"));
        System.out.println(basicDBObject);
    }


}
