package com.recursion;

public class PrimeNo {
    public static void main(String[] args) {
        int n = 5;
        if (isPrime(n, 2)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
    static boolean isPrime(int n, int i){
        if(n==2){
            return true;
        }
        if(n%i==0){
            return false;
        }
        if(i*i>n) {
            return true;
        }
        return isPrime(n, i + 1);

        }
    }


