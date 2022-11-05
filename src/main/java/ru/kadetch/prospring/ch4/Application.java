package ru.kadetch.prospring.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kadetch.prospring.ch4.custom.CustomEditorExample;

import java.io.File;

public class Application {
    public static void main(String... args) throws Exception{
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-02.xml");
        ctx.refresh();

        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
        ctx.close();
    }

}
