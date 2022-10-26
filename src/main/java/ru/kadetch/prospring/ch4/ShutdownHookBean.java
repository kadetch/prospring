package ru.kadetch.prospring.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean implements ApplicationContextAware {
    private ApplicationContext ctx;
    /** @Implements (@link ApplicationContextAware#setApplicationContext(ApplicationContext)}}*/
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if ( ctx instanceof GenericApplicationContext){
            ((GenericApplicationContext) ctx).registerShutdownHook();
        }
    }
}
