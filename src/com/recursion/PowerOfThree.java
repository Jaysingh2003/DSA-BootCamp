package com.recursion;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 25; // Example input
        boolean result = isPowerOfThree(n);
        System.out.println(n + " is a power of three: " + result);
    }
    static boolean isPowerOfThree(int n) {
        // Base case: if n is less than or equal to 0, it cannot be a power of three
        if (n <= 0) {
            return false;
        }
        // If n is 1, it is a power of three (3^0)
        if (n == 1) {
            return true;
        }
        // If n is divisible by 3, recursively check the quotient
        if(n % 3 !=0) return false;

        return isPowerOfThree(n / 3);
        }
    }


