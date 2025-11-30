package com.dynamicprograming;


//https://leetcode.com/problems/house-robber/
public class Robbery {
    public int rob(int[] nums) {
        int n = nums.length;

        // Edge case: only one house
        if (n == 1) return nums[0];

        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];                          // best for first house
        dp[1] = Math.max(nums[0], nums[1]);       // best for first two

        for (int i = 2; i < n; i++) {
            int pick = nums[i] + dp[i - 2];       // rob this house + best till i-2
            int notPick = dp[i - 1];              // skip this house → best till i-1
            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];                         // best till last house
    }
}
