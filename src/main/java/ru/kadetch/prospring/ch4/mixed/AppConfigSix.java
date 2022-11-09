package ru.kadetch.prospring.ch4.mixed;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kadetch.prospring.ch2.decoupled.ConfigurableMessageProvider;
import ru.kadetch.prospring.ch2.decoupled.MessageProvider;

@Configuration
public class AppConfigSix {
    @Bean
    public MessageProvider provider(){
        return new ConfigurableMessageProvider("Love on the weekend!!");
    }
}
