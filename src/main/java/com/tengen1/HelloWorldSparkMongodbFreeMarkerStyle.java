package com.tengen1;

import com.mongodb.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.*;

import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 10/01/14
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkMongodbFreeMarkerStyle {
    static MongoClient client;
    final static StringWriter writer = new StringWriter();
    public static void main(String ...args) throws Exception{
        final Configuration configuration = new Configuration();

        client = new MongoClient(new ServerAddress("localhost", 27017));
        DB mongodb = client.getDB("yusoof");
        DBCollection collection = mongodb.getCollection("products");
        final DBObject document = collection.findOne();

        Spark.get(new Route("/test") {
            @Override
            public Object handle(final Request request, final Response response) {
               try{ configuration.setClassForTemplateLoading(HelloWorldSparkMongodbFreeMarkerStyle.class, "/");
                Template template = configuration.getTemplate("hello.ftl");
                template.process(document, writer);
               }catch (Exception e){
                 halt(500);
               }
                return writer;
            }
        });

        Spark.get(new Route("/test/device") {
            @Override
            public Object handle(final Request request,final Response response) {
                return "This is a device page";  
            }
        });
        
        Spark.get(new Route("/test/:productType") {
            @Override
            public Object handle(final Request request,final Response response) {
                return request.params(":productType");
            }
        });
        
    }
    
}
