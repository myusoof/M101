package com.tengen1;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yusoof
 * Date: 10/01/14
 * Time: 00:07
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldFreeMarker {
    public StringWriter writerOutput() throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarker.class, "/");

        Template template = configuration.getTemplate("hello.ftl");
        StringWriter writer = new StringWriter();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "Yusoof");
        template.process(map1, writer);
        return writer;
    }

}
