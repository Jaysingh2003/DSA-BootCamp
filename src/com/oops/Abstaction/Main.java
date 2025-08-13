package com.oops.Abstaction;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(30);
        son.carreer();
        son.partner(son.age); // This will print the age

        Doughter doughter = new Doughter(40);
        doughter.carreer();
        doughter.partner(doughter.age); // This will print the age
    }
}