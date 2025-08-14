package com.recursion;

public class PrintNaturalNumber {
    public static void main(String[] args) {
        print(1);
    }
    public static void print(int n) {
        if (n > 10) {
            return; // Base case: stop when n exceeds 10
        }
        System.out.println(n); // Print the current number
        print(n + 1); // Recursive call with the next number
    }
}
