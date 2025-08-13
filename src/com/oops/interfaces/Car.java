package com.oops.interfaces;

public class Car implements Engine, Media, Brake {

    int age;

    @Override
    public void brake() {
        System.out.println("I am braking like a normal car");
    }

    @Override
    public void start() {
        System.out.println("media starting");
    }

    @Override
    public void stop() {
        System.out.println("media  stopping");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate like a normal car");
    }
}
