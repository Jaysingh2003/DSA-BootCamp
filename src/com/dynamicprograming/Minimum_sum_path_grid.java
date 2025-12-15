package com.dynamicprograming;

import java.util.Arrays;

public class Minimum_sum_path_grid {
    int[][] dp;

    public int minPathsum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(m - 1, n - 1, 0, grid);
    }
    private int helper(int m, int n, int sum, int[][] grid) {
        if (m < 0 || n < 0) return Integer.MAX_VALUE;//to avoid invalid path we take the maximum value so that it won't be considered it minim
        if (m == 0 && n == 0) return sum + grid[0][0];//base case when we reach the starting point we add the value at that point to sum and return
        if (dp[m][n] != -1) return dp[m][n];//if we have already calculated the minimum path sum for this cell return it
        int up = helper(m - 1, n, sum + grid[m][n], grid);//move up
        int left = helper(m, n - 1, sum + grid[m][n], grid);//move left
        return dp[m][n] = Math.min(up, left);//store the minimum path sum for this cell in dp array and return it
    }


    public int minPathSum1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = grid[i][j] + dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = grid[i][j] + dp[i][j - 1];
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
