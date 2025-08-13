package com.oops.Abstaction;

public abstract class Parent {

    int age;

    // Constructor to initialize age
    Parent(int age) {
        this.age = age;
    }

    abstract void carreer( );
    abstract void partner( int age );
}
