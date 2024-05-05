package com.Aditya_dynamic_programing.lcs_Problem;


//Substring it is similar to that of the subsequence question
//Must be continuous 🔥
public class Longest_Common_Substring {
        public static int longestCommonSubstring(String A, String B) {
            int m = A.length();
            int n = B.length();
            int[][] dp = new int[m + 1][n + 1];
            int max = 0;

            // initialization (optional, default is 0)
            for(int i = 0; i <= m; i++) dp[i][0] = 0;
            for(int j = 0; j <= n; j++) dp[0][j] = 0;

            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {

                    if(A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]); // ✅ correct
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }

            return max; // ✅ correct
        }

}
