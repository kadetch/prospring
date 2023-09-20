package ru.kadetch.prospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kadetch.prospring.ch5.Documentarist;
import ru.kadetch.prospring.ch5.config.AopConfig;

// Using ProxyFactoryBean (ProSpring6)
public class Application {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(AopConfig.class);

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
