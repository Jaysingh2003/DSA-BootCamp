package com.String;

/// https://leetcode.com/problems/palindromic-substrings/
///
///
/// Note see the soluthion of the longest palindromic substring because the only difference is that we are counting the palindromic substring
/// and in longest palindromic substring we are finding the longest one
public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i); // Odd length palindromes
            count += expandAroundCenter(s, i, i + 1); // Even length palindromes
        }
        return count;

    }
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
