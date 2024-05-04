package com.Aditya_dynamic_programing.Matrix_chain_multiplication;

public class Palindrome_Partitioning_Memoization {
    static  int[][] dp;
    static int solve(String s, int i, int j) {
        // Base case
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        // Try all partitions
        for (int k = i; k < j; k++) {

            int left, right;

            if (dp[i][k] != -1) {/// 
                left = dp[i][k];
            } else {
                left = solve(s, i, k);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = solve(s, k + 1, j);
                dp[k + 1][j] = right;
            }

            int cuts = left + right + 1;
            min = Math.min(min, cuts);
        }

        return dp[i][j]= min;
    }

   static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "nitik";
        dp = new int[s.length()][s.length()];///note ham contraints ko dekh ker hi size decide karenge
                                            // 1<n<1000 hai to 100q*1001 ka dp array bana lenge

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(s, 0, s.length() - 1));
    }
}

