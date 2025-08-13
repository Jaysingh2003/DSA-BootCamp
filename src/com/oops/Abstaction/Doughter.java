package com.oops.Abstaction;

public class Doughter extends Parent {

    // Constructor to initialize age
    Doughter(int age) {
        super(age);
    }

    @Override
    void carreer() {
        System.out.println(" radha is a doctor");
    }

    @Override
    void partner( int age) {
        System.out.println ("  radha  is married at the age of " + this.age);
    }
}
