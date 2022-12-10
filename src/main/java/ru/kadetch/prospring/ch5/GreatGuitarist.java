package ru.kadetch.prospring.ch5;

import ru.kadetch.prospring.ch2.common.Singer;

public class GreatGuitarist implements Singer {
    @Override
    public void sing() {
        System.out.println("I shot the sheriff, \n"
                + "But I did not shoot the deputy");
    }
}
