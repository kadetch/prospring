package ru.kadetch.prospring.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250)
                ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }

}
