package com.Aditya_dynamic_programing.lcs_Problem;


import com.oops.interfaces.nestedinterface.A;

/// In this question we have to print the longest common subsequence means not the length but the actual string we have to print
public class Printing_Longest_common_subsequence {
    public String longestCommonSubsequence(String A, String B) {
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
        /// // Build DP table
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
               if(A.charAt(i - 1) == B.charAt(j - 1)) {
                   dp[i][j] = dp[i - 1][j - 1] + 1;
               }
               else{
                   dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
               }
            }
        }
        ///     // Backtracking to get LCS string
        StringBuilder sb = new StringBuilder();
        int i=m, j=n;
        while(i > 0 && j > 0) {//if either row ya fir column koi bhi end tak pahuch jaye to uski retun ker denge answer
            if(A.charAt(i - 1) == B.charAt(j - 1)) {
                sb.append(A.charAt(i - 1));
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }
            else{
                j--;
            }

        //since we are appending the common characters in reverse order, we need to reverse the string builder before returning the result
        }
        return sb.reverse().toString();


    }
}
