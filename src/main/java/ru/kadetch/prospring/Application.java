package ru.kadetch.prospring;

import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kadetch.prospring.ch2.common.Contact;
import ru.kadetch.prospring.ch5.introduction.IsModified;

// Framework Services for AOP- Using ProxyFactoryBean for Introductions
public class Application {
    public static void main(String... args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("spring/app-context-xml-03.xml");
        ctx.refresh();

        Contact bean = (Contact) ctx.getBean("bean");
        IsModified mod = (IsModified) bean;

        System.out.printf("%s:%n", bean.getClass().getSimpleName());
        System.out.printf("Is Contact? - %s%n", (bean instanceof Contact));
        System.out.printf("Is Modified? - %s%n", (bean instanceof IsModified));
        System.out.println(mod.getClass().getSimpleName() +":");
        System.out.println("Has been modified? " + mod.isModified() );
        bean.setName("John Mayer");
        System.out.println("Has been modified? " + mod.isModified() );
        bean.setName("Eric Clapton");
        System.out.println("Has been modified? " + mod.isModified() );

    }

}
