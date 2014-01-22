package com.tengen1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 11/01/14
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class YusoofFormHandling {
    static Configuration configuration = new Configuration();
    public static void main(String ...args) throws Exception{
        configuration.setClassForTemplateLoading(YusoofFormHandling.class ,"/");
        final Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("test", "Yusoof");
        Spark.get(new Route("/login") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {

                    Template template = configuration.getTemplate("yusoofform.ftl");
                    template.process(map1, writer);
                } catch (Exception e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                return writer;
            }

            
        });
        
        Spark.post(new Route("/homepage") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                Map<String, Object> map2 = new HashMap<String, Object>();
                String username = request.queryParams("username");
                    try {
                        map2.put("username", username);
                        Template template = configuration.getTemplate("homepage.ftl");
                        template.process(map2, writer);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                return "you have logged in as " +username;
            }});
    }
}
