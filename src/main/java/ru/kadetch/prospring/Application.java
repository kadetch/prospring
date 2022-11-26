package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch5.*;

public class Application {
    public static void main(String... args) throws Exception {
        Guitarist target = new Guitarist();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);

        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }

}
