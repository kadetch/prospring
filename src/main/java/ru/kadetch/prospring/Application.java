package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch5.*;

public class Application {
    public static void main(String... args) throws Exception {
        KeyGenerator keyGen = getKeyGenerator();
        for (int x =0; x < 10; x++){
            try {
                long key = keyGen.getKey();
                System.out.println("Key: " + key);
            } catch (SecurityException ex){
                System.out.println("Weak Key Generated!");
            }
        }
    }

    private static KeyGenerator getKeyGenerator(){
        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new WeakKeyCheckAdvice());
        factory.setTarget(target);
        return (KeyGenerator) factory.getProxy();
    }
}
