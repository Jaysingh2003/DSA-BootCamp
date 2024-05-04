package com.Aditya_dynamic_programing.knpasack_pattern;

public class Equal_Sum_Partition {

    public static boolean equalSumpartion(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {///if the sum is odd then it is not possible to divide it into two equal part
            return false;
        } else {
            return canPartition(arr, sum / 2);///if sum is even then we just have to find the subset with sum/2

        }

    }
    public static boolean canPartition(int[] arr, int sum) {
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

    public static void main(String[] args) {
        System.out.println(equalSumpartion(new int[]{1,5,11,5}));

    }
}
