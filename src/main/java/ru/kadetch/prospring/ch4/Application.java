package ru.kadetch.prospring.ch4;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        MessageDigester messageDigester = ctx.getBean("digester", MessageDigester.class);
        messageDigester.digest("Hello World!");

        ctx.close();

    }

}
