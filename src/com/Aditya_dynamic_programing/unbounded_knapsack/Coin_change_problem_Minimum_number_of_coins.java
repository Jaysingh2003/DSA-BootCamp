package com.Aditya_dynamic_programing.unbounded_knapsack;

public class Coin_change_problem_Minimum_number_of_coins {

    public int minimumCoinRequired(int[] coins, int amount) {

        int n = coins.length;
        if (coins.length == 0) return -1;
        int[][] dp = new int[n + 1][amount + 1];

        int INF = Integer.MAX_VALUE - 1;//to avoid overflow when we add 1 to it later
        /// to understand see the therory lecture

        for (int i = 0; i <= n; i++) {/// for the row fill
            dp[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {/// for the column fill
            dp[0][j] = INF;
        }
        /// this the the way to fill the second row
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = INF;
            }

        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);///in this we add the 1 in the case when we take the coin "DHAYN SE DEKHO"
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount] == INF ? -1 : dp[n][amount];


    }
}
