package ru.kadetch.prospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kadetch.prospring.ch2.common.Contact;
import ru.kadetch.prospring.ch5.config.IntroductionAopConfig;
import ru.kadetch.prospring.ch5.introduction.IsModified;

// Using ProxyFactoryBean for Introductions (ProSpring6)
public class Application {
    public static void main(String... args) {
        var ctx = new AnnotationConfigApplicationContext(IntroductionAopConfig.class);

        Contact proxy = (Contact) ctx.getBean("proxy");
        IsModified mod = (IsModified) proxy;

        System.out.printf("%s:%n", proxy.getClass().getSimpleName());
        System.out.printf("Is Contact? - %s%n", (proxy instanceof Contact));
        System.out.printf("Is Modified? - %s%n", (proxy instanceof IsModified));
        System.out.println(mod.getClass().getSimpleName() +":");
        System.out.println("Has been modified? " + mod.isModified() );
        proxy.setName("John Mayer");
        System.out.println("Has been modified? " + mod.isModified() );
        proxy.setName("Eric Clapton");
        System.out.println("Has been modified? " + mod.isModified() );

    }

}
