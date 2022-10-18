package ru.kadetch.prospring.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface)
                ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }

}
