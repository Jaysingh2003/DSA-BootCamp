package com.mathsfordsa;

//find all the prime numbers between 1 to n
public class AllPrimeNo {
    public static void main(String[] args) {
        int n=20;
        for(int i=1; i<=n; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }
    static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }

}
