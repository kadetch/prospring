package ru.kadetch.prospring.ch5;

public class ErrorBean {
    public void errorProneMethod() throws Exception{
        throw new Exception("Generic Exception");
    }

    public void otherProneMethod() throws IllegalArgumentException{
        throw new IllegalArgumentException("IllegalArgumentException");
    }
}
