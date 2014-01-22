package com.tengen1;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 09/01/14
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkStyle {
    static HelloWorldFreeMarker freeMarker = new HelloWorldFreeMarker();
    public static void main(String []args){
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
//                return "Hello world from Spark";  //To change body of implemented methods use File | Settings | File Templates.
                try {

                    return freeMarker.writerOutput();
                }
                catch (Exception e){
                    halt(500);
                    return e;
                }
            }
        });
    }

}
