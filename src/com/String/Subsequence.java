package com.String;

/// the subsequence means the characters are in order but not necessarily contiguous
/// https://leetcode.com/problems/is-subsequence/
public class Subsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t)); // Output: true
    }

    private static boolean isSubsequence(String s, String t){
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {/// i will only move when we find a match
                i++;
            }
            j++;// j will always move
        }

        return i == s.length();// if i reaches the end of s, all characters were found in order
    }
}