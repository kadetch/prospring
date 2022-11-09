package ru.kadetch.prospring.ch4.mixed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import ru.kadetch.prospring.ch2.decoupled.MessageProvider;
import ru.kadetch.prospring.ch2.decoupled.MessageRenderer;
import ru.kadetch.prospring.ch2.decoupled.StandardOutMessageRenderer;

@Configuration
@ImportResource(value = "classpath:spring/app-context-xml-01.xml")
public class AppConfigFive {
    @Autowired
    MessageProvider provider;

    @Bean(name="messageRenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer renderer=new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
