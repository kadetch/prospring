package ru.kadetch.prospring.ch4;

import javax.annotation.PostConstruct;

public class SingerWithJSR250 {

    private static final String DEFAULT_NAME = "Eric Clapton";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "\tName: " + name + "\n\tAge: " + age;
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Initializing bean by PostConstruct");

        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set "
                    + "the age property of any beans of type "
                    + SingerWithJSR250.class);

        }
    }
}
