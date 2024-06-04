package com.boutnous_acciolite;


/// it is a dynamic programming problem
/// https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {// it is used for the row
            for (int j = 1; j <= m; j++) {// it is used for the column
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {// if the characters do not match, take the maximum of the two possible subsequences
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);///left ya top me se kisi ek me se maximum value le lo
                }
            }
        }
        return dp[n][m];
    }
}
/*
        ""  B  D  C  A  B  A
     --------------------------------
""  |   0   0  0  0  0  0  0
A   |   0   0  0  0  1  1  1
B   |   0   1  1  1  1  2  2
C   |   0   1  1  2  2  2  2
B   |   0   1  1  2  2  3  3
D   |   0   1  2  2  2  3  3
A   |   0   1  2  2  3  3  4
B   |   0   1  2  2  3  4  4
*/