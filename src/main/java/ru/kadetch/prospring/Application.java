package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch5.Guitarist;
import ru.kadetch.prospring.ch5.SimpleBeforeAdvice;

public class Application {
    public static void main(String... args) throws Exception {
        Guitarist johnMayer = new Guitarist();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);

        Guitarist proxy = (Guitarist) pf.getProxy();

        proxy.sing();

    }

}
