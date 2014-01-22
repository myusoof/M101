package com.tengen1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 10/01/14
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkFreeMarkerDBStyle {
    public static void main(String ...args) throws Exception{
        final StringWriter writer = new StringWriter();
        final Configuration configuration = new Configuration();
        Spark.get(new Route("/yusoof/test") {
            @Override
            public Object handle(Request request, Response response) {
                try{configuration.setClassForTemplateLoading(HelloWorldSparkFreeMarkerDBStyle.class,"/");
                final Template template = configuration.getTemplate("hello.ftl");
                final Map<String, Object> map1 = new HashMap<String, Object>();
                map1.put("name", "Freemarker");
                template.process(map1, writer);
                }catch (Exception e){
                    halt(5000);
                }
                return writer;
            }
        });
    }
}
