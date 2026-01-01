package com.dynamicprograming.subsequence;

public class MinimumAbsDifference {

    public int minimumAbsDifference(int[] nums) {

        int n = nums.length;

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: DP table
        boolean[][] dp = new boolean[n][totalSum + 1];

        // Base case: sum = 0 is always possible
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Base case for first element
        if (nums[0] <= totalSum) {
            dp[0][nums[0]] = true;
        }

        // Step 3: Fill DP table
        for (int ind = 1; ind < n; ind++) {
            for (int sum = 1; sum <= totalSum; sum++) {

                boolean notTaken = dp[ind - 1][sum];
                boolean taken = false;

                if (nums[ind] <= sum) {
                    taken = dp[ind - 1][sum - nums[ind]];
                }

                dp[ind][sum] = notTaken || taken;
            }
        }

        // Step 4: Find minimum difference
        int minDiff = Integer.MAX_VALUE;

        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }

        return minDiff;
    }
}