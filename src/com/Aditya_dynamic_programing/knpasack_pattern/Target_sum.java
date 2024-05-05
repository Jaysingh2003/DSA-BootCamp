package com.Aditya_dynamic_programing.knpasack_pattern;

public class Target_sum {

    public static int findTargetSumWays(int[] arr, int target) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        // Important fix
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }

        int sum1 = (target + sum) / 2;
        return countSubset(arr, sum1);
    }

    public static int countSubset(int[] arr, int sum){
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = 0;
        }

        // DP
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}