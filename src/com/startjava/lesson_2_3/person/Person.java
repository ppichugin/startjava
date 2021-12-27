package com.startjava.lesson_2_3.person;

public class Person {

    boolean isMale = true;
    String name = "Pavel";
    int height = 180;
    int weight = 80;
    int age = 35;

    public void walk() {
        System.out.println("I'm walking.");
    }

    public boolean seat() {
        return true;
    }

    public void run() {
        System.out.println("I'm running.");
    }

    public void speak() {
        System.out.println("I'm speaking.");
    }

    public void learnJava() {
        System.out.println("I'm learning Java.");
    }
}