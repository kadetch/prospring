package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch5.*;

//Creating the intercepting advice
public class Application {
    public static void main(String... args) throws Exception {
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(errorBean);
        factory.addAdvice(new SimpleThrowsAdvice());
        ErrorBean proxy = (ErrorBean) factory.getProxy();
        try {
            proxy.errorProneMethod();
        } catch (Exception ex) {

        }
        try {
            proxy.otherProneMethod();
        } catch (Exception ex) {

        }
    }

}
