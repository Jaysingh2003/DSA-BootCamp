package com.recursion_1;

public class ProductIfDigit {
    public static void main(String[] args) {
        System.out.println(products(06));
    }
         static  int products ( int n ){
            if (n % 10 == n) {
                return n;
            }
            return n % 10 * products(n / 10);
        }

    }

