package com.Engineering_digst_DSA;

interface A1{
    default void greet() {
        System.out.println("Hello from A");
    }
}

interface B1 {
    default void greet() {
        System.out.println("Hello from B");
    }
}

 class C1 implements A1, B1 {
     public void greet() {
         System.out.println("Resolved in class C");
     }


     public static void main(String[] args) {
         C1 c = new C1();
         c.greet();
         c.greet(); // This will call the greet method in class C
     }
 }