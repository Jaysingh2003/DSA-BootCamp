package com.Aditya_dynamic_programing.lcs_Problem;
/// Longest repeating subsequence ki ek hi sequence do bari repeat hoga order matter and contigeous not matter
///  means ki same string me same character repeat ho rha hai but uska index same nahi hona chahiye
///
public class Longest_repeating_subsequence {
    public int LongestRepeatingSubsequence(String A) {
        String B = A;

        return lcs(A, B);
    }
    private int lcs(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int[][] dp = new int[lenA + 1][lenB + 1];

        for(int i = 1; i <= lenA; i++) {
            for(int j = 1; j <= lenB; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1) && i != j) {/// here is only one condition is tha if i!=j means ke hi index ke chacter nahi hone cvhahiye
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenA][lenB];

    }

}
