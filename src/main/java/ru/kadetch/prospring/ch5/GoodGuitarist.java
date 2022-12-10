package ru.kadetch.prospring.ch5;

import ru.kadetch.prospring.ch2.common.Singer;

public class GoodGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("Who says I can't be free \n"
                + "From all of the things that I used to be");
    }
}
