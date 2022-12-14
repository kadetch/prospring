package ru.kadetch.prospring.ch5;

import ru.kadetch.prospring.ch2.common.Singer;
import ru.kadetch.prospring.ch2.common.Guitar;

public class GrammyGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("sing: Gravity is working against me\n "
                + "And gravity wants to bring me down");
    }

    public void sing(Guitar guitar){
        System.out.println("play: " + guitar.play());
    }

    public void rest(){
        System.out.println("Zzzz");
    }

    public void talk(){
        System.out.println("talk");
    }
}
