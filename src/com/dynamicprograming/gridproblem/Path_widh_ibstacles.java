package com.dynamicprograming.gridproblem;

import java.util.Arrays;

public class Path_widh_ibstacles {
    int[][] dp;

    public int Path_widh_ibstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(row - 1, col - 1, obstacleGrid);
    }

    private int helper(int r, int c, int[][] obstacleGrid) {

        if (r < 0 || c < 0)
            return 0;

        // obstacle
        if (obstacleGrid[r][c] == 1)
            return 0;

        // ✅ START CELL (MISSING EARLIER)
        if (r == 0 && c == 0)
            return 1;

        if (dp[r][c] != -1)
            return dp[r][c];

        int up = helper(r - 1, c, obstacleGrid);
        int left = helper(r, c - 1, obstacleGrid);

        return dp[r][c] = up + left;
    }

    //tabulation
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // obstacle
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) { // start cell
                    dp[i][j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}

