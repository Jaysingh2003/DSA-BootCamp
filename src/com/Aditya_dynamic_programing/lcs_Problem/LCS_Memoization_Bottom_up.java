package com.Aditya_dynamic_programing.lcs_Problem;

import java.util.Arrays;

public class LCS_Memoization_Bottom_up {
  static int[][] dp;
    // Memoization without passing dp
    private static int lcsMemo(String s1, String s2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            dp[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(
                    lcsMemo(s1, s2, m - 1, n),
                    lcsMemo(s1, s2, m, n - 1)
            );
        }

        return dp[m][n];
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        dp = new int[m + 1][n + 1];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println("Length of LCS is" + " " + lcsMemo(s1, s2, m, n));
    }

}
