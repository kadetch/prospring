package ru.kadetch.prospring.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kadetch.prospring.ch2.decoupled.MessageRenderer;
import ru.kadetch.prospring.ch4.mixed.AppConfigFive;
import ru.kadetch.prospring.ch4.multiple.AppConfigThree;

public class Application {
    public static void main(String... args) throws Exception {
        ApplicationContext ctx =
//                new AnnotationConfigApplicationContext(AppConfigFive.class);
                new ClassPathXmlApplicationContext("classpath:spring/app-context-xml-02.xml");
        MessageRenderer renderer = (MessageRenderer) ctx.getBean("messageRenderer",
                MessageRenderer.class);
        renderer.render();
    }

}
