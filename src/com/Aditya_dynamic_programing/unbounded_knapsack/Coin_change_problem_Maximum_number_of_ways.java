package com.Aditya_dynamic_programing.unbounded_knapsack;


// Type 1:
// In this problem, we are given an array of coins and a target sum.
// We have an unlimited supply of each coin.
// The task is to find the total number of ways to make the given sum using these coins.

public class Coin_change_problem_Maximum_number_of_ways {
    public static int maxCoinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // First row: no coins → 0 ways to make any positive amount
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = 0;
        }

        // First column: amount = 0 → 1 way (choose nothing)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];//unbounded knapsack me i-1 ki jagah pa i use karte h

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
       return dp[n][amount];

    }
}