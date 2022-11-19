package ru.kadetch.prospring.ch5;

import ru.kadetch.prospring.ch2.common.Singer;

public class Guitarist implements Singer {
    private String lyric = "You're gonna live forever in me";
    @Override
    public void sing() {
        System.out.println(lyric);
    }
}
