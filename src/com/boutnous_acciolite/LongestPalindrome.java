package com.boutnous_acciolite;

public class LongestPalindrome {

    // Returns the longest palindromic substring
    public static String longestPalindrome(String s) {

        // If string is empty or has only one character
        if (s == null || s.length() < 2) return s;

        // start and end index of the longest palindrome found so far
        int start = 0, end = 0;

        // Treat every character as a center
        for (int i = 0; i < s.length(); i++) {

            // Case 1: Odd length palindrome (center at i)
            int len1 = expandFromCenter(s, i, i);

            // Case 2: Even length palindrome (center between i and i+1)
            int len2 = expandFromCenter(s, i, i + 1);

            // Take maximum length from both cases
            int len = Math.max(len1, len2);

            // If current palindrome is longer than previous one
            if (len > end - start) {

                // Calculate new start index
                start = i - (len - 1) / 2;

                // Calculate new end index
                end = i + len / 2;
            }
        }

        // Return longest palindromic substring
        return s.substring(start, end + 1);
    }

    // Expands around the given center and returns palindrome length
    private static int expandFromCenter(String s, int left, int right) {

        // Expand while characters match and bounds are valid
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Length of palindrome
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // Output: bab or aba
    }
}