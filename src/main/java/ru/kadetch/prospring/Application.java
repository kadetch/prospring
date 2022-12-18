package ru.kadetch.prospring;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.ComposablePointcut;
import ru.kadetch.prospring.ch5.*;

// Comparing Proxy Performance
public class Application {
    public static void main(String... args) {

        GrammyGuitarist johnMayer = new GrammyGuitarist();

        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE,
                new ComposablePointcutExample.SingMethodMatcher());

        System.out.println("Test 1 >> ");
        GrammyGuitarist proxy = new ComposablePointcutExample().getProxy(pc, johnMayer);
        new ComposablePointcutExample().testInvoke(proxy);
        System.out.println();

        System.out.println("Test 2 >>");
        pc.union(new ComposablePointcutExample.TalkMethodMatcher());
        proxy = new ComposablePointcutExample().getProxy(pc, johnMayer);
        new ComposablePointcutExample().testInvoke(proxy);
        System.out.println();

        System.out.println("Test 3 >>");
        pc.intersection(new ComposablePointcutExample.RestMethodMatcher());
        proxy = new ComposablePointcutExample().getProxy(pc, johnMayer);
        new ComposablePointcutExample().testInvoke(proxy);
    }

}
