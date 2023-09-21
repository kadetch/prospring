package ru.kadetch.prospring.ch5.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kadetch.prospring.ch2.common.Contact;
import ru.kadetch.prospring.ch5.introduction.IsModifiedAdvisor;

@Configuration
public class IntroductionAopConfig {

    @Bean
    public Contact guitarist(){
        var contact = new Contact();
        contact.setName("John Mayer");
        return contact;
    }

    @Bean
    public IsModifiedAdvisor advisor(){
        return new IsModifiedAdvisor();
    }

    @Bean
    public Contact proxy(){
        ProxyFactoryBean pfb = new ProxyFactoryBean();
        pfb.setProxyTargetClass(true);
        pfb.setTarget(guitarist());
        pfb.addAdvisor(advisor());
        pfb.setFrozen(true);
        return (Contact) pfb.getObject();
    }
}
