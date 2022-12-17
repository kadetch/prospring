package ru.kadetch.prospring;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import ru.kadetch.prospring.ch2.common.Guitar;
import ru.kadetch.prospring.ch5.*;

// Creating Annotation Matching Pointcuts
public class Application {
    public static void main(String... args) {

        Guitarist johnMayer = new Guitarist();

        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);

        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);

        Guitarist proxy = (Guitarist) pf.getProxy();

        proxy.sing(new Guitar());
        proxy.rest();

    }

}
