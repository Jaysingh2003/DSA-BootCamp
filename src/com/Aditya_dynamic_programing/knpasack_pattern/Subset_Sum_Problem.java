package com.Aditya_dynamic_programing.knpasack_pattern;


/// ek array h have usko divide karna h 2 differnt subset me and dono element ka sum equal ho individually
public class Subset_Sum_Problem {

    /// look the solution of 0/1/ knapsack
    public static boolean subsetSum(int[] arr, int sum) {

        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // main logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {///include or not include case
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {             /// if arr[i-1] > j means we can't include that element
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }


}
