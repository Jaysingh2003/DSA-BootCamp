package com.Aditya_dynamic_programing.lcs_Problem;

/// in this we have to print the scs actually
/// 2 parts we have to solve this first we have to find that what is the  LCS
/// secondly w have to remove the lcs from the total substring

public class Printing_Shortest_Common_SuperSequence {

    public String scs(String A, String B) {
        int m = A.length();
        int n = B.length();

        int[][] dp = new int[m + 1][n + 1];

        /// initialize the table
        for(int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for(int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        // Build LCS table
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Build SCS - means jo common h usk append karo and jo raste me aur bhi h o bhi append karo.
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while(i > 0 && j > 0) {//jab tak ki  top pa na pahuch jaye or left me na pahuch jaye
            if(A.charAt(i - 1) == B.charAt(j - 1)) {
                sb.append(A.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(A.charAt(i - 1));
                i--;
            } else {
                sb.append(B.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters if any string left
        while(i > 0) {
            sb.append(A.charAt(i - 1));
            i--;
        }

        while(j > 0) {
            sb.append(B.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }
}