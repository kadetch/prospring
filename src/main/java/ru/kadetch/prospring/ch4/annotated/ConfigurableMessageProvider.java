package ru.kadetch.prospring.ch4.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.kadetch.prospring.ch2.decoupled.MessageProvider;

@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;
    @Override
    public String getMessage() {
        return message;
    }

    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }
}
