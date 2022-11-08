package ru.kadetch.prospring.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kadetch.prospring.ch2.decoupled.MessageRenderer;

public class Application {
    public static void main(String... args) throws Exception {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:spring/app-context-xml.xml");

        MessageRenderer renderer = (MessageRenderer) ctx.getBean("messageRenderer");
        renderer.render();
    }

}
