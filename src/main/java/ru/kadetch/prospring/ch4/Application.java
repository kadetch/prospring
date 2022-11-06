package ru.kadetch.prospring.ch4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import ru.kadetch.prospring.ch4.custom.CustomEditorExample;

import java.io.File;
import java.util.Locale;

public class Application {
    public static void main(String... args) throws Exception {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayes"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[]{"John", "Mayes"}, german));

        ctx.close();
    }

}
