package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import ru.kadetch.prospring.ch2.common.Guitar;
import ru.kadetch.prospring.ch5.*;

// Convenience Advisor Implementations
public class Application {
    public static void main(String... args) {

        GrammyGuitarist johnMayer = new GrammyGuitarist();

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.addMethodName("sing");
        advisor.addMethodName("rest");

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);

        GrammyGuitarist proxy = (GrammyGuitarist) pf.getProxy();

        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();

    }

}
