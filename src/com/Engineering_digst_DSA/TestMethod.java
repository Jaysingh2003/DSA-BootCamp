package com.Engineering_digst_DSA;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }

    void printSound() {
        super.sound(); // Calls Animal's sound()
    }
}

public class TestMethod {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.printSound();
    }
}