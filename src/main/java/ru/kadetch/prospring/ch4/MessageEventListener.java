package ru.kadetch.prospring.ch4;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        MessageEvent msgEvnt = (MessageEvent) event;
        System.out.println("Received: " + msgEvnt.getMessage());
    }

}
