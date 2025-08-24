package com.mathsfordsa;

public class CheckprimeNo {
    public static void main(String[] args) {
        int n = 2;
        if (isPrime(n)) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }
    }
    // Naive approach to check prime number
//    static boolean isPrime(long n){
//        if(n<=1){// 1 and negative numbers are not prime numbers
//            return false;
//        }
//        for(int i=2; i<n;i++){// check till square root of n
//            if(n % i == 0){
//                return false;
//            }
//        }
//        return true;
//
//    }
    // Optimized approach to check prime number
    static boolean isPrime(int n){
        if(n<=1){// 1 and negative numbers are not prime numbers
            return false;
        }
        int i=2;
        while(i*i<=n){// check till square root of n
            if(n%i==0){
                return false;
            }
            i++;
        }
        return true;
    }

}
