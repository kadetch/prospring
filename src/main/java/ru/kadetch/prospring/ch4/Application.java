package ru.kadetch.prospring.ch4;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String... args) {
        GenericApplicationContext ctx =
                new GenericXmlApplicationContext("classpath:spring/app-context-xml.xml");

        NamedSinger bean = (NamedSinger)ctx.getBean("johnMayer");
        bean.sing();

        ctx.close();
    }

}
