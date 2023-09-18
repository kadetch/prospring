package ru.kadetch.prospring;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kadetch.prospring.ch5.Documentarist;

// Framework Services for AOP- Using ProxyFactoryBean
public class Application {
    public static void main(String... args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("spring/app-context-xml-03.xml");
        ctx.refresh();

        Documentarist documentaristOne = ctx.getBean("documentaristOne", Documentarist.class);
        Documentarist documentaristTwo = ctx.getBean("documentaristTwo", Documentarist.class);

        System.out.println("\n".repeat(2));
        System.out.println("Documentarist One >>");
        documentaristOne.execute();
        System.out.println();
        System.out.println("Documentarist Two >>");
        documentaristTwo.execute();
    }

}
