package com.dynamicprograming;

import java.util.Arrays;

public class Cherrypickup {

    int[][][] dp;

    public int cherrypickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][m];

        // Initialize dp with -1
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }

        // Start from row 0, robot1 at col 0, robot2 at col m-1
        return helper(0, 0, m - 1, grid);
    }

    public int helper(int i, int j1, int j2, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Out of bounds
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e8;
        }

        // Last row
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        // Memoization check
        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = Integer.MIN_VALUE;

        // Explore all 9 moves
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;

                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += helper(i + 1, j1 + dj1, j2 + dj2, grid);
                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}