package com.dynamicprograming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Fibonacchi {
    static int[] dp;// memoization array by default all values are 0

    static int fib(int n){//we can also take the array as a parameter iof be have not to declare it globally

        if(n<=1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        int n = 5;
        dp = new int[n + 1]; // initialize memoization array
        Arrays.fill(dp,-1); // fill with -1 to indicate uncomputed values
        System.out.println(fib(n));
    }
// Space-optimized tabulation O(n) time, O(1) space
    static  int fibSpaceOpt(int n){
        if(n<=1){
            return n;
        }
        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        for(int i=2;i<=n;i++){
            int curr = prev1 + prev2; // F(n) = F(n-1) + F(n-2)
            prev2 = prev1; // update F(n-2)
            prev1 = curr; // update F(n-1)
        }
        return prev1; // F(n)
    }
}
