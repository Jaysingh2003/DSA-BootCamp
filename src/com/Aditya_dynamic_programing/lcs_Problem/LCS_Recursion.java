package com.Aditya_dynamic_programing.lcs_Problem;

/// Given two sequences, find the length of longest subsequence present in both of them.
/// A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
public class LCS_Recursion {
    ///Recursive Approach.
    private static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        System.out.println("Length of LCS is" + " " + lcs(s1, s2, m, n));
    }

}
