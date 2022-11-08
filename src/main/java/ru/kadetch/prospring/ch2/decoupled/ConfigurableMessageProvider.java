package ru.kadetch.prospring.ch2.decoupled;

public class ConfigurableMessageProvider implements MessageProvider{
    private String message = "Default message";
    @Override
    public String getMessage() {
        return message;
    }

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
