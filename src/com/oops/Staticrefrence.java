package com.oops;

public class Staticrefrence {
    public static void main(String[] args) {

        Staticrefrence s = new Staticrefrence();
         s.greeting();
    }
    void fun(){
        greeting();
    }
     void greeting(){
        System.out.println("hello");
    }
}
