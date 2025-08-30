package com.recursion_1;

public class Reverse2 {
    public static void main(String[] args) {
        int n = 12304;
        System.out.println(reverse(n));
    }
    static int reverse(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    static int helper(int n, int digits){
        int rem = n % 10;
        if(n % 10 == n){
            return n;
        }
        return rem * (int)(Math.pow(10, digits - 1)) + helper(n / 10, digits - 1);
    }
}
