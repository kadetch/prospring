package ru.kadetch.prospring.ch4.multiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.kadetch.prospring.ch2.decoupled.MessageProvider;
import ru.kadetch.prospring.ch2.decoupled.MessageRenderer;
import ru.kadetch.prospring.ch2.decoupled.StandardOutMessageRenderer;

@Configuration
@Import(AppConfigFour.class)
public class AppConfigThree {
    @Autowired
    MessageProvider provider;

    @Bean(name="messageRenderer")
    public MessageRenderer messageRenderer(){
        MessageRenderer messageRenderer = new StandardOutMessageRenderer();
        messageRenderer.setMessageProvider(provider);
        return messageRenderer;
    }

}
