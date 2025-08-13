package com.oops.interfaces;

interface A {
     default void show() {
        System.out.println("A's show");
    }

    static void showStatic() {
        System.out.println("A's static show");
    }
}

interface B {
    default void show() {
        System.out.println("B's show");
    }
}

class MyClass implements A, B {
    // Error unless show() is overridden
    // Must override to resolve conflict
    public void show() {
        A.super.show();  // or B.super.show();
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.show();  // Calls the overridden method

        // Calling the static method from interface A
        //this is the static method which must have the body and not need to be  overridden
        A.showStatic();
    }

}