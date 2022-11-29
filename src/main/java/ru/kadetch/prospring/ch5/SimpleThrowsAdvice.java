package ru.kadetch.prospring.ch5;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class SimpleThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception exception) throws Throwable {
        System.out.println("***");
        System.out.println("Generic Exception Capture");
        System.out.println("Caught: " +
                exception.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method, Object[] args,
                              Object target, IllegalArgumentException exception)
            throws Throwable {
        System.out.println("***");
        System.out.println("IllegalArgument Capture");
        System.out.println("Caught: " +
                exception.getClass().getName());
        System.out.println("Method: " + method.getName());
        System.out.println("***\n");
    }
}
