package ru.kadetch.prospring;

import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import ru.kadetch.prospring.ch5.*;

// Comparing Proxy Performance
public class Application {
    public static void main(String... args) {

        SimpleBean target = new DefaultSimpleBean();

        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(),
                new NoOpBeforeAdvice());
        ProxyPerfTest proxyPerfTest = new ProxyPerfTest();
        proxyPerfTest.runCglibTests(advisor, target);
        proxyPerfTest.runCglibFrozenTests(advisor, target);
        proxyPerfTest.runJdkTests(advisor, target);
    }

}
