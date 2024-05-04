package com.Aditya_dynamic_programing.knpasack_pattern;

import java.util.Collections;
import java.util.List;

/// In this we have to divide the array into two subset such that the difference between the two subset is minimum
public class Minimum_Subset_Sum_Difference {

    public int minSubsetSum(int[] nums) {
        int n = nums.length;
        int range = 0;

        for (int i = 0; i < n; i++) {
            range += nums[i];
        }

        boolean[][] dp = new boolean[n + 1][range + 1];

        for (int j = 0; j <= range; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range; j++) {

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for (int j = 0; j <= range / 2; j++) {//we only need half of the array
            if (dp[n][j]) {/// dp[n][j] → already boolean (true / false) means ki ye automatically check karenge
                minDiff = Math.min(minDiff, range - 2 * j);
            }
        }
        return minDiff;

    }

}
