package ru.kadetch.prospring.ch4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import ru.kadetch.prospring.ch2.decoupled.ConfigurableMessageProvider;
import ru.kadetch.prospring.ch2.decoupled.MessageProvider;
import ru.kadetch.prospring.ch2.decoupled.MessageRenderer;
import ru.kadetch.prospring.ch2.decoupled.StandardOutMessageRenderer;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class AppConfig {

    @Autowired
    Environment environment;

    @Bean
    @Lazy
    public MessageProvider messageProvider(){
        return new ConfigurableMessageProvider(
                environment.getProperty("message")
        );
    }

    @Bean
    @Scope(value = "prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider());
        return messageRenderer;
    }
}
