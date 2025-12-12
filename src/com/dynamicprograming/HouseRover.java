package com.dynamicprograming;


//https://leetcode.com/problems/house-robber/
public class HouseRover {
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

    public  int rob1(int[] nums) {
        int n = nums.length;
        int prev = nums[0];//the pick is like the current element
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
