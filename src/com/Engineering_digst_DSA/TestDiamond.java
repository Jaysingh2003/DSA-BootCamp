package com.Engineering_digst_DSA;

interface A {
    default void sayHello() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void sayHello() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    public void sayHello() {
        // Need to resolve the ambiguity
        System.out.println("Hello from C");
        A.super.sayHello(); // optional: call A's method
        B.super.sayHello(); // optional: call B's method
    }
}

public class TestDiamond {
    public static void main(String[] args) {
        C obj = new C();
        obj.sayHello();
    }
}