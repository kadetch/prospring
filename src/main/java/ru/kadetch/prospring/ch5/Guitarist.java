package ru.kadetch.prospring.ch5;

import ru.kadetch.prospring.ch2.common.Singer;

public class Guitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2(){
        System.out.println("Oh gravity, stay the hall from me");
    }

    public void rest(){
        System.out.println("zzz");
    }

}
