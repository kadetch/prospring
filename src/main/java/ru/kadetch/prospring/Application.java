package ru.kadetch.prospring;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch2.common.Contact;
import ru.kadetch.prospring.ch5.introduction.IsModified;
import ru.kadetch.prospring.ch5.introduction.IsModifiedAdvisor;

// Comparing Proxy Performance
public class Application {
    public static void main(String... args) {

        Contact target = new Contact();
        target.setName("John Mayer");

        IntroductionAdvisor advisor = new IsModifiedAdvisor();
        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setOptimize(true);

        Contact proxy = (Contact) pf.getProxy();
        IsModified proxyInterface = (IsModified) proxy;

        System.out.printf("%s:%n", target.getClass().getSimpleName());
        System.out.printf("Is Contact? - %s%n", (target instanceof Contact));
        System.out.printf("Is Modified? - %s%n", (target instanceof IsModified));
        System.out.println(proxy.getClass().getSimpleName() +":");
        System.out.println("Is Contact? - " + (proxy instanceof Contact));
        System.out.println("Is Modified? - " + (proxy instanceof IsModified));
        System.out.println("Has been modified? " + proxyInterface.isModified() );
        proxy.setName("John Mayer");
        System.out.println("Has been modified? " + proxyInterface.isModified() );
        proxy.setName("Eric Clapton");
        System.out.println("Has been modified? " + proxyInterface.isModified() );
    }

}
