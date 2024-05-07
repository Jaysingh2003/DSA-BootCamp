package com.Aditya_dynamic_programing.unbounded_knapsack;

/*
 Unbounded Knapsack:
 We can take the same item multiple times.
 Goal: Maximize total value within given capacity.
*/

public class Unbounded_knapsck {

    public static int unbound_knapsack_tabulation(int[] value, int[] weight, int capacity, int n) {

        // dp[i][j] = maximum value using first i items with capacity j
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {

                // Base Case:
                // If no items OR capacity is 0 → profit is 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                // If current item's weight is less than or equal to current capacity
                else if (weight[i - 1] <= j) {

                    /*
                     Choice 1: Include the current item
                     - Add its value
                     - Reduce capacity by its weight
                     - Stay on same index (i) because we can reuse the same item
                    */
                    int include = value[i - 1] + dp[i][j - weight[i - 1]];

                    /*
                     Choice 2: Exclude the current item
                     - Move to previous item (i-1)
                    */
                    int exclude = dp[i - 1][j];

                    // Take maximum of both choices
                    dp[i][j] = Math.max(include, exclude);
                }

                // If current item cannot be included (weight > capacity)
                else {
                    // Simply exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Final answer: max value using all items within full capacity
        return dp[n][capacity];
    }
}