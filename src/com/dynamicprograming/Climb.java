package com.dynamicprograming;

import java.util.Arrays;

public class Climb {
    static int[] dp;
    static int climb(int n){

        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = climb(n-1)+climb(n-2);
        return dp[n];

    }
    // Bottom-up approach
    static long climb1(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // Space-optimized version
    public int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        int prev2 = 1; // ways to reach step 0
        int prev1 = 1; // ways to reach step 1

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int n=5;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climb(n));
    }
}
