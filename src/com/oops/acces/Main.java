package com.oops.acces;

public class Main {
    public static void main(String[] args) {
        A obj = new A(10, "jaysingh");
        int n = obj.num; // Accessing public variable directly
        System.out.println(obj.getName()); // Accessing public method

    }
}
