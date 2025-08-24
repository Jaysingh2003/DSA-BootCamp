package com.mathsfordsa;

public class AllPrimeNoUsingArray {
    public static void main(String[] args) {

        int n = 20;
        boolean[] prime = new boolean[n + 1];//note boolena array intially all values are false
        isPrime(n, prime);
    }
        //false → means prime
    static boolean isPrime(int n, boolean[] prime) {
      //false in array means no is prime prime
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {    // Or (prime[i] == false)
                for (int j = i * 2; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                System.out.print(i + " ");
            }
        }

    return true;
    }

}

//complxity O(n log (log n))