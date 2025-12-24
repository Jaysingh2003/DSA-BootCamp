package com.dynamicprograming.subsequence;

import java.util.Arrays;

public class Sum_Target {
    int[][] dp;
    public boolean targetSum(int target, int[] arr) {
        int n = arr.length;
        dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n - 1, target, arr);


    }
    private  boolean helper(int n, int target, int[] arr) {
        if(target==0) return true;//if target is 0 we found the subset
        if(n==0) return arr[0]==target;//when we reach the first elemnt then we havon only one option
                                        //to check if that element is equal to target or not if yes return true else false
        if(dp[n][target]!=-1){
            return dp[n][target]==1;
        }
        boolean notTake = helper(n - 1, target, arr);//not take the element
        boolean take = false;
        if(target>=arr[n]){
            take = helper(n - 1, target - arr[n], arr);//take the element
        }
        dp[n][target]= (take || notTake)?1:0;
        return take || notTake;
    }
    //tabulation
    public boolean targetSumTabulation(int target, int[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];

        // Base case: target 0 can always be achieved with empty subset
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // If first element is less than or equal to target
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= target; t++) {
                boolean notTake = dp[i - 1][t];
                boolean take = false;
                if (t >= arr[i]) {
                    take = dp[i - 1][t - arr[i]];
                }
                dp[i][t] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }

}
