package ru.kadetch.prospring.ch5;

import ru.kadetch.prospring.ch2.common.Guitar;
import ru.kadetch.prospring.ch2.common.Singer;

public class Guitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Dream of ways tho throw it all away");
    }

    @AdviceRequired
    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }

}
