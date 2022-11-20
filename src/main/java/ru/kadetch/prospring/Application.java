package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch5.*;
import ru.kadetch.prospring.ch5.SecurityManager;

public class Application {
    public static void main(String... args) throws Exception {
        SecurityManager manager = new SecurityManager();

        SecureBean bean = getSecureBean();

        manager.login("John", "pwd");
        bean.writeSecureMessage();
        manager.logout();

        try {
            manager.login("invalid_user", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException ex){
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            manager.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex){
            System.out.println("Exception Caught: " + ex.getMessage());
        }

    }

    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();

        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        SecureBean proxy = (SecureBean) factory.getProxy();

        return proxy;
    }
}
