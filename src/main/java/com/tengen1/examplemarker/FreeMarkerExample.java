package com.tengen1.examplemarker;

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

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 21/01/14
 * Time: 19:24
 * To change this template use File | Settings | File Templates.
 */
public class FreeMarkerExample {
    static Configuration configuration = new Configuration();
    public static void main(String[] args) {

        Spark.get(new Route("/signIn") {
            @Override
            public Object handle(Request request, Response response)  {

                configuration.setClassForTemplateLoading(FreeMarkerExample.class, "/");
                StringWriter writer = new StringWriter();
                Template template = null;
                try {
                    template = configuration.getTemplate("hello.ftl");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("name", "Yusoof");
                try {
                    template.process(map, writer);
                } catch (TemplateException e) {
                    System.out.println(e);
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                return writer;
            }
        });
    }
}
