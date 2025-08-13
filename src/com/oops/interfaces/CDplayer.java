package com.oops.interfaces;

public class CDplayer implements Media {

    @Override
    public void start() {
        System.out.println("CD player starting");
    }

    @Override
    public void stop() {
        System.out.println("CD player stopping");
    }

}
