package ru.kadetch.prospring.ch4;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.registerShutdownHook();
        ctx.refresh();
        ctx.getBean("destructiveBean",DestructiveBeanWithInterface.class);
    }

}
