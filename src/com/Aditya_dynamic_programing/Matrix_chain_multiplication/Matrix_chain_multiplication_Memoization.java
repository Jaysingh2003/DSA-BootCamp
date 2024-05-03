package com.Aditya_dynamic_programing.Matrix_chain_multiplication;

public class Matrix_chain_multiplication_Memoization {
    static int[][] dp;

    public static int solve(int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int temp = solve(arr, i, k, dp)
                    + solve(arr, k + 1, j, dp)
                    + arr[i - 1] * arr[k] * arr[j];

            min = Math.min(min, temp);
        }

        return dp[i][j] = min;
    }

    public static void main(String[] args) {
        int arr[] = {40, 20, 30, 10, 30};

        int n = arr.length;

        dp = new int[n][n];///also we can initialize by using the constarints of the questions

        // initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        int i = 1;
        int j = n - 1;

        System.out.println("Minimum cost: " + solve(arr, i, j, dp));
    }
}