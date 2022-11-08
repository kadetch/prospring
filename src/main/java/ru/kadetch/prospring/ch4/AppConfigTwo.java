package ru.kadetch.prospring.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kadetch.prospring.ch2.decoupled.MessageProvider;
import ru.kadetch.prospring.ch2.decoupled.MessageRenderer;
import ru.kadetch.prospring.ch2.decoupled.StandardOutMessageRenderer;

@Configuration
@ComponentScan(basePackages = "ru.kadetch.prospring.ch4.annotated")
public class AppConfigTwo {
    @Autowired
    MessageProvider provider;

    @Bean(name="messageRenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(provider);
        return messageRenderer;
    }
}
