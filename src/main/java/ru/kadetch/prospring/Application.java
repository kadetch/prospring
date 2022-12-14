package ru.kadetch.prospring;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import ru.kadetch.prospring.ch2.common.Guitar;
import ru.kadetch.prospring.ch5.*;

// Using Simple Name Matching
public class Application {
    public static void main(String... args) {

        GrammyGuitarist johnMayer = new GrammyGuitarist();

        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("sing");
        pc.addMethodName("rest");

        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

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
