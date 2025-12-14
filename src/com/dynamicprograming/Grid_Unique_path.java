package com.dynamicprograming;

import java.util.Arrays;

public class Grid_Unique_path {

    static int[][] dp;

    // ===== Memoization (0-based) =====
    public static int uniquepath(int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (r == 0 && c == 0) return 1;
        if (dp[r][c] != -1) return dp[r][c];

        int up = uniquepath(r - 1, c);
        int left = uniquepath(r, c - 1);

        return dp[r][c] = up + left;
    }

    // ===== Tabulation (0-based) =====
    public static int uniquepath1(int row, int col) {
        if (row <= 0 || col <= 0) return 0;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
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

    // ===== Space Optimized =====
    public static int uniquepath2(int row, int col) {
        if (row <= 0 || col <= 0) return 0;

        int[] prev = new int[col];//we take only one  array to store the previous row(which is a dummy aray at the start)

        for (int i = 0; i < row; i++) {
            int[] curr = new int[col];//current row array that we campare with the previous row
            for (int j = 0; j < col; j++) {//this loop
                if (i == 0 && j == 0) {//it means that the first cell of the grid and there is only one way to reach there
                    curr[j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) up = prev[j];// just top cell value from the previous row
                    if (j > 0) left = curr[j - 1];// left cell value from the current row
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[col - 1];
    }

    public static void main(String[] args) {
        int row = 3, col = 3;

        dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(uniquepath(row - 1, col - 1)); // 6
        System.out.println(uniquepath1(row, col));        // 6
        System.out.println(uniquepath2(row, col));        // 6
    }
}