package com.Aditya_dynamic_programing.unbounded_knapsack;


public class Rod_Cutting_problem {

    public static int cuttingRod(int[] length, int[] price, int N) {

        int n = length.length;
        int[][] dp = new int[n + 1][N + 1];

        /// “I initialize the first row and column to represent base cases — no items or zero capacity gives
        /// zero profit — and then build the solution bottom-up.”
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= N; j++) {
            dp[0][j] = 0;
        }

        // Fill remaining table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {

                if (length[i - 1] <= j) {//this condition will check if the current
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);/// add the price and then we have two chociu either take (can take repeatdlyy) or not
                } else {/// if the length of the rod is greater than the current length of the rod then we will not take it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][N];
    }
}