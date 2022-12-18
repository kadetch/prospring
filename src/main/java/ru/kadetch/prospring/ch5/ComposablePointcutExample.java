package ru.kadetch.prospring.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcher;
import ru.kadetch.prospring.ch2.common.Guitar;

import java.lang.reflect.Method;

public class ComposablePointcutExample {
    public GrammyGuitarist getProxy(ComposablePointcut pc, GrammyGuitarist target){
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget( target);
        pf.addAdvisor(advisor);
        return (GrammyGuitarist) pf.getProxy();
    }

    public void testInvoke(GrammyGuitarist proxy){
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();
    }

    public static class SingMethodMatcher extends StaticMethodMatcher{

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return (method.getName().startsWith("si"));
        }
    }

    public static class TalkMethodMatcher extends StaticMethodMatcher{

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return "talk".equals(method.getName());
        }
    }

    public static class RestMethodMatcher extends StaticMethodMatcher{

        @Override
        public boolean matches(Method method, Class<?> targetClass) {
            return method.getName().endsWith("st");
        }
    }
}
