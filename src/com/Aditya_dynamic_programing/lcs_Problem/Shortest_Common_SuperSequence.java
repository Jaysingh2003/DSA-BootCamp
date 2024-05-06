package com.Aditya_dynamic_programing.lcs_Problem;

/// Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
/// Input:   str1 = "geek",  str2 = "eke"  ->   Output: "geeke"
/// meas ki totl string e se jo common h uski ek bar remove ker de to let string hi SCS bna jayega
/// because the two times hot h LCS in two staring
public class Shortest_Common_SuperSequence {

    public int longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        /// initialize the table
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }
        /// // Build DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        return (m + n) - lcs;

    }
}
