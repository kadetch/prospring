package ru.kadetch.prospring.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kadetch.prospring.ch4.custom.CustomEditorExample;

import java.io.File;
import java.util.Locale;

public class Application {
    public static void main(String... args) throws Exception {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:spring/app-context-xml.xml");

        Publisher publisher = (Publisher) ctx.getBean("publisher");
        publisher.publisher("I send an SOS to the world...");
        publisher.publisher("...I hope that someonegets my ...");
        publisher.publisher("... Mesage in s bottle");
    }

}
