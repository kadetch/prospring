package ru.kadetch.prospring;

import org.springframework.aop.framework.ProxyFactory;
import ru.kadetch.prospring.ch5.*;

//Creating the surrounding advice
public class Application {
    public static void main(String... args) throws Exception {
        WorkerBean workerBean = getWorkerBean();
        workerBean.doSomeWork(10000000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new ProfilingInterceptor());
        factory.setTarget(target);
        return (WorkerBean) factory.getProxy();
    }
}
