package ru.kadetch.prospring.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class Application {
    public static void main(String... args) throws Exception{
        File file = File.createTempFile("test",".txt");
        file.deleteOnExit();

        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-01.xml");
        ctx.refresh();

        PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("buildInSample");

        ctx.close();
    }

}
