// File: src/com/dynamicprograming/FrongJump.java
package com.dynamicprograming;

import java.util.Arrays;

public class FrongJump {

    public static int jump(int ind, int[] height, int[] dp) {
        if (ind == 0) return 0;
        if (dp[ind] != -1) return dp[ind];
        int left = jump(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
        int right = Integer.MAX_VALUE;//this will take the min value if not updated
        if (ind > 1) {
            right = jump(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }
        return dp[ind] = Math.min(left, right);
    }

    static int jump1(int n, int[] height, int[] dp) {
        dp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            int left = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            }
            dp[i] = Math.min(left, right);

        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] height = {10, 30, 40, 20};
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        int result = jump(height.length - 1, height, dp);
        System.out.println(result);
    }

}