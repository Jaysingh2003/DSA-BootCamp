package com.dynamicprograming;

//https://leetcode.com/problems/house-robber-ii/
public class Robery2 {
    public int helper(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0]; // best up to i-1
        int prev2 = 0;      // best up to i-2

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2; // rob this house
            int notPick = prev;         // skip this house
            int current = Math.max(pick, notPick);

            prev2 = prev;
            prev = current;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] temp1 = new int[n - 1]; // exclude first
        int[] temp2 = new int[n - 1]; // exclude last

        for (int i = 0; i < n; i++) {
            if (i != 0) temp1[i - 1] = nums[i];
            if (i != n - 1) temp2[i] = nums[i];
        }

        return Math.max(helper(temp1), helper(temp2));
    }
}
