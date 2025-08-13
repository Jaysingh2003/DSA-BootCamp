package com.oops.interfaces.nestedinterface;

interface Outer {

    interface Inner {
            void greet();
        }


    class MyClass implements Outer.Inner {
        public void greet() {
            System.out.println("Nested interface inside another interface");
        }
    }
    public static void main(String[] args) {
        Outer.Inner inner = new MyClass();
        inner.greet();
    }
}

