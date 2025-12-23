package com.dynamicprograming;

import java.util.Arrays;

public class Max_Min_pathSum {
    int[][] dp;

    public int maxPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, helper(n - 1, j, grid));
        }
        return max;
    }

    public int helper(int i, int j, int[][] grid) {
        int m = grid[0].length;

        if (j < 0 || j >= m) {//base case when we go out of bound
            return Integer.MIN_VALUE;
        }
        if (i == 0) {//base case when we rech the first row from the bottom
            return grid[0][j];
        }
        if (dp[i][j] != -1) {//if already calculated
            return dp[i][j];
        }
        int up = grid[i][j] + helper(i - 1, j, grid);//up
        int leftDiagonal = grid[i][j] + helper(i - 1, j - 1, grid);//left diagonal
        int rightDiagonal = grid[i][j] + helper(i - 1, j + 1, grid);//right diagonal
        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));

    }

    // Tabulation (Bottom-Up)
    public int maxPathSumTabulation(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        // Base case: first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = grid[0][j];
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = dp[i - 1][j];
                int leftDiag = (j > 0) ? dp[i - 1][j - 1] : Integer.MIN_VALUE;
                int rightDiag = (j < m - 1) ? dp[i - 1][j + 1] : Integer.MIN_VALUE;

                dp[i][j] = grid[i][j] + Math.max(up, Math.max(leftDiag, rightDiag));
            }
        }

        // Answer: max in last row
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }

        return max;
    }
}