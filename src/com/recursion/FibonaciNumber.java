package com.recursion;

public class FibonaciNumber {
    public static void main(String[] args) {
           // System.out.println(fib(50)); // Output: 8

            System.out.println(fiboNachiformula(60));

    }

    // Using Binet's formula to calculate Fibonacci numbers
    static  int  fiboNachiformula(int n){
       return (int)(Math.pow(((1 + Math.sqrt(5)) / 2),n)  / (Math.sqrt(5)));

    }

    // Recursive function to calculate Fibonacci numbers
    public static int fib(int n) {
        if (n < 2) {// Because we already know that we aktBase case: fib(0) = 0, fib(1) = 1
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
// it is the sum of previous two no
//fibonacchi(0) = 0
//fibonacchi(1) = 1
//fibonacchi(2) = 1
//fibonacchi(3) = 2
//fibonacchi(4) = 3
//fibonacchi(5) = 5 etc.

// Time complexity: O(2^n) - Exponential time complexity due to the recursive calls
//and if we have to print 50 fibonacci numbers then it will take a lot of time