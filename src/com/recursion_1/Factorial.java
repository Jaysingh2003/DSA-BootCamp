package com.recursion_1;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5)); // Output: 120
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // Base case: 0! = 1
        }
        return n * factorial(n - 1); // Recursive case
    }
    static int sumofnos(int n) {
        if (n == 1) {
            return 1; // Base case: sum of first 1 number is 1
        }
        return n + sumofnos(n - 1); // Recursive case
    }
}
