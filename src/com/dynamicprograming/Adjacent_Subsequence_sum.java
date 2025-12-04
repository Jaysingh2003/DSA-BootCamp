package com.dynamicprograming;

import java.util.Arrays;

//You are given an array/list of N integers.
//You must return the maximum possible sum of a subsequence
// such that no two selected elements are adjacent in the array.
public class Adjacent_Subsequence_sum {
    public static int maximum_sum(int ind, int[] nums) {
        if (ind == 0) return nums[0];
        if (ind < 0) return 0;

        int pick = nums[ind] + maximum_sum(ind - 2, nums);
        int notPick = 0 + maximum_sum(ind - 1, nums);

        return Math.max(pick, notPick);
    }

    // Memoization
    public static int maximum_sum1(int ind, int[] nums, int[] dp) {
        if (ind == 0) return nums[ind];
        if (ind < 0) return 0;
        if (dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + maximum_sum(ind - 2, nums);
        int notPick = 0 + maximum_sum(ind - 1, nums);

        return dp[ind]= Math.max(pick, notPick);
    }

    public int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maximum_sum1(n - 1, nums, dp);
    }

    // Tabulation
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


    // Space Optimization
    public int maximumNonAdjacentSum2(int[] nums) {
        int n = nums.length;
        int prev = nums[0];//the pick is like the xurrent element
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return  prev;
    }

}
