package com.Aditya_dynamic_programing.lcs_Problem;

public class LCS_Itrative_Top_down {
 public int lcs(String s1, String s2) {
     int m = s1.length();
     int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
     // base case: first row & column = 0
     for (int i = 0; i <= m; i++){
         dp[i][0] = 0;
     }
     for (int j = 0; j <= n; j++){
         dp[0][j] = 0;
     }
        /// fill the left do table
     // fill DP table
     for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {

             if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                 dp[i][j] = 1 + dp[i - 1][j - 1]; // match → diagonal + 1
             } else {
                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // no match → max of top/left
             }
         }
     }

     return dp[m][n]; // final answer
 }

    public static void main(String[] args) {
        LCS_Itrative_Top_down lcs = new LCS_Itrative_Top_down();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Length of LCS is" + " " + lcs.lcs(s1, s2));
    }

}
