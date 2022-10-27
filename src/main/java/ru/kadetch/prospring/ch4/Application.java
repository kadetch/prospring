package ru.kadetch.prospring.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(MessageDigesterConfig.class);

        MessageDigester messageDigester = (MessageDigester) ctx.getBean("digester");
        messageDigester.digest("Hello World!");

        ctx.close();

    }

}
