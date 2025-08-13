package com.oops.interfaces;

public class Electricengine implements  Engine {
    @Override
    public void start() {
        System.out.println("Electric engine starting");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine stopping");
    }

    @Override
    public void acc() {
        System.out.println("Electric engine accelerating");
    }
}
