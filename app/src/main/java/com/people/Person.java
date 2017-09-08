package com.people;

/**
 * Created by josue on 06/09/17.
 */

public abstract class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return name + "\n" + phoneNumber;
    }
}
